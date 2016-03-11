

//Run selenium grid server

C:\Users\Brijesh\git\Sample-Project\Sample_Automation_Project\lib\Selenium Server\selenium-server-standalone-2.48.2.jar

Open the first cmd , execute below command

java -jar selenium-server-standalone-2.48.2.jar -role hub
Then start the node like this:

 http://localhost:4444/grid/console

Open the second cmd , execute below command

java -jar selenium-server-standalone-2.48.2.jar -role webdriver -hub http://localhost:4444/grid/register -browser browserName="chrome",version=ANY,platform=WINDOWS,maxInstances=5 -Dwebdriver.chrome.driver=C:\Users\brijesh-yadav\workspace\Sample_Automation_Project\resources\browser-driver\chrome\chromedriver.exe 

// IP Address : Hub machine IP address
java -jar selenium-server-standalone-2.48.2.jar -role node -hub http://hubmachine-IP:4444/grid/register


java -jar selenium-server-standalone-2.48.2.jar -role webdriver -hub http://hubmachine-IP:4444/grid/register -browser browserName="firefox",version=ANY,platform=WINDOWS,maxInstances=5
