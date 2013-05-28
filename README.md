argos-saleslogix-selenium
===================
This repo contains both the Selenium WebDriver and IDE test scripts used for SalesLogix WebClient 2.x testing.

Required Test Environment:
----------------------------------------
1. Windows 7 (requires at least 2.5GB of RAM)
2. Firefox 10 (DO NOT UPGRADE - newer versions may work but are not yet tested)
2. Java SE1.7
3. Selenium Server 2.31.0
4. TestNG 6.8.1
5. Chromedriver
6. IEDriverServer
7. Eclipse SDK 4.2.2

Setup Instructions:
---------------------------
1. Please see the Word .docx files under the \docs folder in this repo.
2. Clone this repo to a local folder on your test machine.
    (e.g. $ git clone git://github.com/SageSalesLogix/argos-saleslogix-selenium.git)
	
For the Selenium IDE tests:
1. Simply launch Selenium IDE from FF and use the 'File-Open' menu to navigate to the '\selenium.ide.saves' folder.
2. Open the selected .html test script under the appropriate 'Mobile 2.x' folder.

For the WebDriver Java Project:
1. Launch Eclipse then select the 'File-Open File...' menu.
2. From the Open File dialog, navigate to the path to the '.project' file of where you cloned this 'argos-saleslogix-selenium' repo.
