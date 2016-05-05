
For Parallel execution, need to start only selenium server using below command

--> Enter the folder where the below jar is availabel and then execute the below command. selenium server will get start
-->java -jar selenium-server-standalone-2.48.2.jar
--> Do the changes with your suite.xml file (<suite thread-count="4" name="Suite" parallel="classes">)

//For remotely execution
//Run selenium grid server

C:\Users\Brijesh\git\Sample-Project\Sample_Automation_Project\lib\Selenium Server\selenium-server-standalone-2.48.2.jar

Open the first cmd , execute below command

java -jar selenium-server-standalone-2.48.2.jar -role hub

Then start the node like this:
 http://localhost:4444/grid/console

//ignore this command
java -jar selenium-server-standalone-2.48.2.jar -role webdriver -hub http://localhost:4444/grid/register -browser browserName="chrome",version=ANY,platform=WINDOWS,maxInstances=5 -Dwebdriver.chrome.driver=C:\Users\brijesh-yadav\workspace\Sample_Automation_Project\resources\browser-driver\chrome\chromedriver.exe 

Open the second cmd , execute below command
//Execute below command on first machine
// IP Address : Hub machine IP address
java -jar selenium-server-standalone-2.48.2.jar -role node -hub http://hubmachine-IP:4444/grid/register

Second machine machine must have Selenium grid server, browser

//Execute below command on second machine using cmd
java -jar selenium-server-standalone-2.48.2.jar -role node webdriver -hub http://hubmachine-IP:4444/grid/register -browser browserName="firefox",version=ANY,platform=WINDOWS,maxInstances=5

run it http://localhost:4444/grid/console in browser on host machine : 
you will find the instance of secondd machine on your host machine, this way your virtual mchine gets conneccted with host machine.

run your test on host machine. This test will also run on second machine.
