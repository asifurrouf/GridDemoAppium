#Appium Parallel Testing using Selenium Grid


#Preconditions:
1. download selenium-server-standalone-2.53.1.jar  
link: http://selenium-release.storage.googleapis.com/index.html?path=2.53/

2. run all command from same directory where both above jars are present
Note: Every node should have both the jars 

3. Apk to be tested should present in specific path of every node(See AppiumGrid.java)
Window path: C:\\ApiDemos-debug.apk
Mac path:    /Users/sheetalsingh/Documents/workspace/SeleniumGridDemo/src/test/resources/apps/ApiDemos-debug.apk

4. Appium/Genymotion for virtual devices should be installed in nodes

5. Note that currently following are the hub and node ip
hub ip: 192.168.2.109  (my m/c)
node ip: 192.168.2.148 (window m/c)

make sure hub and node are on same n/w


Steps:
1. start hub in hub m/c
java -jar selenium-server-standalone-2.53.1.jar -role hub

Info comes:
09:49:49.393 INFO - Nodes should register to http://192.168.58.1:4444/grid/register/
09:49:49.394 INFO - Selenium Grid hub is up and running
Note: info say connect to 192.168.58.1:4444 but that is not working and we generally connect to host m/c i/p

2.verify hub start :  
http://localhost:4444/grid/console#
http://192.168.2.109:4444/grid/console#
Note: localhost because current machine is hub

3. register node with following details

#appium with ui
-node m/c > open appium ui > settings > selenium grid config file : give path of json file here
-start appium
-same with with second json if running in parallel

#appium with command line
#node 1 setup:
C:\Program Files (x86)\Appium>appium --nodeconfig "C:\Users\Sheetal\Desktop\remote_android_iamnodewin1.json"
note: here node will start on default 4723 port |  192.168.2.148:4723

#node 2 setup
C:\Program Files (x86)\Appium>appium --port 4724 --nodeconfig "C:\Users\Sheetal\Desktop\remote_android_iamnodewin2.json"
note: here node will start on 4724 port |  192.168.2.148:4724


4. Start Genymotion and add two devices
Nexus 6.0
Nexus 5.1


5. Run testng xml from host machine
testng_native_app_parallel.xml   | for parallel execution
testng_native_app_sequential.xml	| for sequential execution

note:
local_android_app.json  | this is just for testing on personal m/c both host and node present in same m/c


