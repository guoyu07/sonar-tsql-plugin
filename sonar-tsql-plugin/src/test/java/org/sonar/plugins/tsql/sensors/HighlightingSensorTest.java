package org.sonar.plugins.tsql.sensors;

import java.io.File;
import java.nio.file.Files;
import java.util.Collection;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.sonar.api.batch.fs.internal.DefaultInputFile;
import org.sonar.api.batch.sensor.internal.SensorContextTester;
import org.sonar.api.batch.sensor.issue.Issue;
import org.sonar.api.config.Settings;
import org.sonar.api.utils.internal.JUnitTempFolder;
import org.sonar.plugins.tsql.Constants;
import org.sonar.plugins.tsql.languages.TSQLLanguage;


public class HighlightingSensorTest {

	@Rule
	public TemporaryFolder folder = new TemporaryFolder();

	@org.junit.Rule
	public JUnitTempFolder temp = new JUnitTempFolder();

	@Test
	public void testHighlighting() throws Throwable {

		File baseFile0 = temp.newFile("customRulesSample", "xml");

		FileUtils.copyURLToFile(getClass().getResource("/customRulesSample.xml"), baseFile0);

		Settings settings = new Settings();
		settings.setProperty(Constants.PLUGIN_CUSTOM_RULES_PATH, baseFile0.getAbsolutePath());
		settings.setProperty(Constants.PLUGIN_CUSTOM_RULES_PREFIX, "customRulesSample");

		File baseFile = folder.newFile("test.sql");

		FileUtils.copyURLToFile(getClass().getResource("/testFiles/scriptExample.sql"), baseFile);

		DefaultInputFile file1 = new DefaultInputFile("test", "test.sql");

		file1.initMetadata(new String(Files.readAllBytes(baseFile.toPath())));
		file1.setLanguage(TSQLLanguage.KEY);

		DefaultInputFile file2 = new DefaultInputFile("test", "test.php");
		file2.setLanguage("php");
		SensorContextTester ctxTester = SensorContextTester.create(folder.getRoot());
		ctxTester.fileSystem().add(file1);
		ctxTester.fileSystem().add(file2);
		HighlightingSensor sensor = new HighlightingSensor(settings);
		sensor.execute(ctxTester);
		Collection<Issue> issues = ctxTester.allIssues();

		Assert.assertEquals(3, issues.size());
		Assert.assertEquals(0, ctxTester.highlightingTypeAt("test:test.sql", 0, 0).size());
		Assert.assertEquals(0, ctxTester.highlightingTypeAt("test:test.sql", 2, 0).size());
		Assert.assertEquals(0, ctxTester.highlightingTypeAt("test:test.sql", 5, 0).size());
		Assert.assertEquals(16, ctxTester.cpdTokens("test:test.sql").size());

	}

	@Test
	public void testHighlighting2() throws Throwable {

		Settings settings = new Settings();

		File baseFile = folder.newFile("test.sql");
		FileUtils.write(baseFile, "SELECT * FROM dbo.test");

		DefaultInputFile file1 = new DefaultInputFile("test", "test.sql");

		file1.initMetadata(new String(Files.readAllBytes(baseFile.toPath())));
		file1.setLanguage(TSQLLanguage.KEY);

		SensorContextTester ctxTester = SensorContextTester.create(folder.getRoot());
		ctxTester.fileSystem().add(file1);
		HighlightingSensor sensor = new HighlightingSensor(settings);
		sensor.execute(ctxTester);

		Assert.assertEquals(1, ctxTester.highlightingTypeAt("test:test.sql", 1, 5).size());
		Assert.assertEquals(0, ctxTester.highlightingTypeAt("test:test.sql", 2, 0).size());
		Assert.assertEquals(0, ctxTester.highlightingTypeAt("test:test.sql", 5, 0).size());
		Assert.assertEquals(1, ctxTester.cpdTokens("test:test.sql").size());

	}

}
