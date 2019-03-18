Created Best buy api test in‘TestMonefyAppPyd’ framework under a seprate package ‘com.bestbuy.api.test’

The package has following classes :-
ApiUtility :- created an utility file to keep generic HTTP methods to be consumed in the tests. like getStatusCode, doGet 
BaseSetup:- to initialize testng annotation methods.
BestBuyApiTests :- Actual tests resides.

Api test data is fetched from apiTestData.properties under resource file.
apiEndPointList file is used to perform iteration for tests using dataProvider. E.g verifyLimitEqualToSizeOfData, verifyTotalProductCount and verifySucessSatusCode
