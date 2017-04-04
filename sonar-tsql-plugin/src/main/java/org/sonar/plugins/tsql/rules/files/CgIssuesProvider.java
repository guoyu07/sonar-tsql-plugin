package org.sonar.plugins.tsql.rules.files;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.sonar.api.batch.fs.FileSystem;
import org.sonar.api.config.Settings;
import org.sonar.api.utils.TempFolder;
import org.sonar.api.utils.log.Logger;
import org.sonar.api.utils.log.Loggers;
import org.sonar.plugins.tsql.Constants;

public class CgIssuesProvider implements IReporsProvider {

	private static final String cgCommandLine = "\"%s\" -source \"%s\" -out \"%s\" -config \"%s\"";

	private static final Logger LOGGER = Loggers.get(CgIssuesProvider.class);

	private final FileSystem fileSystem;

	private final TempFolder folder;

	private Settings settings;

	public CgIssuesProvider(final Settings settings, final FileSystem fileSystem, final TempFolder folder) {
		this.settings = settings;
		this.fileSystem = fileSystem;
		this.folder = folder;
	}

	private File[] getCGANalysisFiles() {
		return new CgIssuesFilesProvider(this.settings, this.fileSystem).get();
	}

	@Override
	public File[] get() {
		final String cgPath = this.settings.getString(Constants.CG_APP_PATH);

		if (StringUtils.isEmpty(cgPath) || !new File(cgPath).exists()) {
			LOGGER.info(String.format("SQL Code guard not found at %s, trying to search directories instead", cgPath));
			return getCGANalysisFiles();
		}

		final File sourceDir = fileSystem.baseDir().toPath().toFile();
		final File configFile = folder.newFile("temp", "config.xml");
		final File tempResultsFile = folder.newFile("temp", "results.xml");
		try {
			FileUtils.copyURLToFile(getClass().getResource("/config/sqlcodeguardsettings.xml"), configFile);
		} catch (final Throwable e1) {
			LOGGER.warn("Was not able to copy sql code guard config settings, trying to search directories instead",
					e1);
			return getCGANalysisFiles();

		}

		final String command = String.format(cgCommandLine, cgPath, sourceDir.getAbsolutePath(),
				tempResultsFile.getAbsolutePath(), configFile.getAbsolutePath());

		try {
			LOGGER.debug("Running command", command);
			final Process process = new ProcessBuilder(command).start();
			process.waitFor();
			LOGGER.debug("Running command finished");
		} catch (final Throwable e) {
			LOGGER.warn("Error executing SQL code guard tool, trying to search directories instead", e);
			return getCGANalysisFiles();
		}

		return new File[] { tempResultsFile };
	}

}
