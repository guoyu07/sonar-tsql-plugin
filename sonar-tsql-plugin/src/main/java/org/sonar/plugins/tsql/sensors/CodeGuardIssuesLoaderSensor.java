package org.sonar.plugins.tsql.sensors;

import org.sonar.api.config.Settings;
import org.sonar.api.utils.TempFolder;
import org.sonar.plugins.tsql.Constants;
import org.sonar.plugins.tsql.rules.issues.CodeGuardIssuesProvider;

public class CodeGuardIssuesLoaderSensor extends BaseTsqlSensor {

	public CodeGuardIssuesLoaderSensor(final Settings settings, final TempFolder tempFolder) {
		super(settings, new CodeGuardIssuesProvider(settings, tempFolder), Constants.CG_REPO_KEY);
	}
}
