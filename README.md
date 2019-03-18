# kamlesh-yadav

Test Automation Framework:-
Setup:-
a)	Maven
b)	Testng
c)	POM 
d)	Java-client
e)	Appium
f)	Selenium 
  
pre-requiste :- I had installed Monefy app on my android device and ran appium(1.10.0).
		Remember to switch on USB debugging mode on mobile device before running tests.

Testng :- created a @before class method to invoke monify app though appium and @afterclass to close and quit app.
	  Its under BaseTest file	

POM :- It’s a page object model where all UI elements of the Modefy app  and methods that operates on these elements are maintained inside the class file.
Under package ‘.*pages’. The verfications are done in the ‘.*Test’ package  file.

Data Driven Test:- Test data is maintained under resource package(‘testData.Properties’ file) and the data is fetched and stored in a hashMap and further consumed in tests.

Test Iteration :- used @dataprovider to get the list of data ([‘expenseList’]) to be consumed  in the same test. It’s maintained under resource file.

Configuration File :- to fetch data related to configuration of device.

Modular Approach:- added modular/small methods which can be used over and over again in the tests

Testng Assertion :- validate checkpoints in tests.
