
//Run selenium grid server

C:\Users\Brijesh\git\Sample-Project\Sample_Automation_Project\lib\Selenium Server\selenium-server-standalone-2.48.2.jar

first, do the usual:

java -jar selenium-server-standalone-2.48.2.jar -role hub
Then start the node like this:

 http://localhost:4444/grid/console

java -jar selenium-server-standalone-2.48.2.jar -role webdriver -hub http://localhost:4444/grid/register -browser browserName="chrome",version=ANY,platform=WINDOWS,maxInstances=5 -Dwebdriver.chrome.driver=resources\browser-driver\chrome\chromedriver.exe 
More specifically: You have to start up the NODE with parameter browser and add -D parameter specifying the full path to the ChromeDriver

