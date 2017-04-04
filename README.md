# sonar-tsql-plugin
This repository contains T-SQL language plug-in for Sonar.

## Description ##
Currently plug-in supports:

- 14 code analysis rules by Microsoft. Details can be found at [https://msdn.microsoft.com/en-us/library/dd172133(v=vs.100).aspx](https://msdn.microsoft.com/en-us/library/dd172133(v=vs.100).aspx "https://msdn.microsoft.com/en-us/library/dd172133(v=vs.100).aspx").
- 120 code analysis rules by SQL Code Guard tool. Details can be found at [http://sqlcodeguard.com/index-database-issues.html](http://sqlcodeguard.com/index-database-issues.html "http://sqlcodeguard.com/index-database-issues.html")


In the future it is planned to:

- Implement syntax highlighting of the reserved words
 

## Usage ##

1. Download and install SonarQube
2. Download plugin from the [releases](https://github.com/gretard/sonar-tsql-plugin/releases) and copy it to sonarqube's extensions\plugins directory
3. Start SonarQube and enable rules
4. If you want plug-in to automatically run SQL Code guard analysis part, please install [SQL Code Guard](http://sqlcodeguard.com/ "SQL Code Guard") onto your build machines and make sure that property **sonar.tsql.cg.path** is set to an existing installation (default is **C:\\Program Files (x86)\\SqlCodeGuard\\SqlCodeGuard.Cmd.exe**), otherwise please run analysis before invoking sonar analysis step as in it is shown in Example project's **run.bat** file.
5. If you want plugin to import issues found by Microsoft, please before running a sonar analysis build solution with setting */p:RunSqlCodeAnalysis=true*. 

## Plugin parameters and configuration ##
By default plugin tries to find all xml files in base directory ending in *staticcodeanalysis.results.xml* and *cgresults.xml*. It is possible to override these by specifying the following parameters:

- **sonar.tsql.cg.path** - path where SQL code guard tool is, defaults to *C:\\Program Files (x86)\\SqlCodeGuard\\SqlCodeGuard.Cmd.exe*
- **sonar.tsql.cg.report** - SQL Code Guard results file, defaults to *cgresults.xml*, required only if you run analysis manually, before build
- **sonar.tsql.ms.report** - ms static code analysis report file, defaults to *staticcodeanalysis.results.xml*

### Using default configuration ###
In example, the following settings will force plugin to run *C:\\Program Files (x86)\\SqlCodeGuard\\SqlCodeGuard.Cmd.exe* and pick up any *staticcodeanalysis.results.xml* produced by msbuild which are found in the sources directory
<pre>
sonar.projectKey=test:sql:database1
sonar.projectName=sql database
sonar.projectVersion=1.0
sonar.sources=.
sonar.sourceEncoding=UTF-8
</pre>

### Using custom configuration  ###
In example, the following settings will force plugin to run *C:\\Program Files\\SqlCodeGuard\\SqlCodeGuard.Cmd.exe* and pick up any *msstaticcodeanalysis.results.xml* produced by msbuild which are found in the sources directory
<pre>
sonar.projectKey=test:sql:database1
sonar.projectName=sql database
sonar.projectVersion=1.0
sonar.sources=.
sonar.sourceEncoding=UTF-8
sonar.tsql.cg.path=C:\\Program Files\\SqlCodeGuard\\SqlCodeGuard.Cmd.exe
sonar.tsql.ms.report=msstaticcodeanalysis.results.xml
</pre>

Please see *Example* directory where sample T-SQL project is stored for manual configuration of running SQL Code Guard.

