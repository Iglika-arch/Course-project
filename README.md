## Repository for the QA automation code task


UI Automation has done with Java 8 and the used tool is Selenium.


#### Links to chromedriver and geckodriver. 
```bash
https://github.com/mozilla/geckodriver/releases/download/v0.29.0/geckodriver-v0.29.0-win64.zip - for Firefox browser v87
https://chromedriver.storage.googleapis.com/89.0.4389.23/chromedriver_win32.zip - For Chrome browser v89
```
### Description 
It's a Maven project. Used 3rd party dependencies are TestNG, Junit, Extent repohttps://chromedriver.storage.googleapis.com/89.0.4389.23/chromedriver_win32.ziprt and their versions are as follows :
``` bash
TesNG v7.3.0
Junit v4.12
Extent Reports v4.0.9
```
For better understanding which case is failure , which one is passed - a visual report tool (extent reports) is added.

### Execution
The tests can be run with Run command on testng.xml for the IDE.

Tests could be also run with executing the following commands:

``` bash
 mvn clean compile assembly:single
 copy the the testng.xml file to target directory and go to target directory and run the command 
 or copy jar file to previous directory and run the command
 java -jar Musalatest-1.0-SNAPSHOT-jar-with-dependencies.jar testng.xml
```
### Reports
Extent report has generated in test-output directory.
``` bash
 ..\test-output\HTMLReport.html
```