argos-saleslogix-selenium
===================
This repo contains both the Selenium WebDriver test scripts used for argos-saleslogix mobile.

Required Test Environment:
----------------------------------------
1. Selenium [Grid](https://code.google.com/p/selenium/wiki/Grid2) Setup with nodes for desired browsers
2. Java JDK1.7
3. IntelliJ Community Edition or maven if using command line

Setup Instructions:
---------------------------
Clone this repo to a local folder on your test machine. Example: `$ git clone git://github.com/Saleslogix/argos-saleslogix-selenium.git`

For the WebDriver Java Project:

1. Open argos-saleslogix-selenium in IntelliJ Community edition IDE
2. Add your JDK path to the project's Platform Settings SDKs section

Running the tests:
* Configure app.properties to your setup (selenium grid, mobile URL, etc)
  * You can override app.properties by passing the key/value pairs into maven test as system properties: `mvn  -Dbrowser=firefox test`
  * You can target specific tests this way as well: `mvn -Dbrowser=internetExplorer -Dtest=TicketViewsTest test`

Browsers strings accepted (must have a node connected to the grid or indivdually running as a standalone hub):
* `chrome` - Requires [ChromeDriver](https://code.google.com/p/selenium/wiki/ChromeDriver)
* `firefox`
* `internetExplorer` - Requires [InternetExplorerDriver](https://code.google.com/p/selenium/wiki/InternetExplorerDriver)
* `android` - Requires [Selendroid](http://selendroid.io/mobileWeb.html)
* `ipad` - Requries [ios-driver](http://ios-driver.github.io/ios-driver/)
* `iphone` - Requires [ios-driver](http://ios-driver.github.io/ios-driver/)
* `phantomjs` - Requires [PhantomJS](http://phantomjs.org/)
