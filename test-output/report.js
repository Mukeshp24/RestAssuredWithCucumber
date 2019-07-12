$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("featureFiles/getPost.feature");
formatter.feature({
  "line": 1,
  "name": "test social account",
  "description": "",
  "id": "test-social-account",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 3,
  "name": "test list of user on friendbook",
  "description": "",
  "id": "test-social-account;test-list-of-user-on-friendbook",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 4,
  "name": "send GET request \"https://reqres.in/api/users?page\u003d2\"",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "then tesponce code should be 200",
  "keyword": "And "
});
formatter.step({
  "line": 6,
  "name": "veryfy total pages are 4",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "https://reqres.in/api/users?page\u003d2",
      "offset": 18
    }
  ],
  "location": "testScocialAccountAPI.send_GET_request(String)"
});
formatter.result({
  "duration": 3852688172,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "200",
      "offset": 29
    }
  ],
  "location": "testScocialAccountAPI.then_tesponce_code_should_be(int)"
});
formatter.result({
  "duration": 1436993833,
  "error_message": "java.lang.SecurityException: class \"org.hamcrest.Matchers\"\u0027s signer information does not match signer information of other classes in the same package\r\n\tat java.lang.ClassLoader.checkCerts(Unknown Source)\r\n\tat java.lang.ClassLoader.preDefineClass(Unknown Source)\r\n\tat java.lang.ClassLoader.defineClass(Unknown Source)\r\n\tat java.security.SecureClassLoader.defineClass(Unknown Source)\r\n\tat java.net.URLClassLoader.defineClass(Unknown Source)\r\n\tat java.net.URLClassLoader.access$100(Unknown Source)\r\n\tat java.net.URLClassLoader$1.run(Unknown Source)\r\n\tat java.net.URLClassLoader$1.run(Unknown Source)\r\n\tat java.security.AccessController.doPrivileged(Native Method)\r\n\tat java.net.URLClassLoader.findClass(Unknown Source)\r\n\tat java.lang.ClassLoader.loadClass(Unknown Source)\r\n\tat sun.misc.Launcher$AppClassLoader.loadClass(Unknown Source)\r\n\tat java.lang.ClassLoader.loadClass(Unknown Source)\r\n\tat io.restassured.internal.ResponseSpecificationImpl.statusCode(ResponseSpecificationImpl.groovy:131)\r\n\tat io.restassured.internal.ValidatableResponseOptionsImpl.statusCode(ValidatableResponseOptionsImpl.java:119)\r\n\tat steps.testScocialAccountAPI.then_tesponce_code_should_be(testScocialAccountAPI.java:30)\r\n\tat ✽.And then tesponce code should be 200(featureFiles/getPost.feature:5)\r\n",
  "status": "failed"
});
formatter.match({
  "arguments": [
    {
      "val": "4",
      "offset": 23
    }
  ],
  "location": "testScocialAccountAPI.veryfy_total_pages_are(int)"
});
formatter.result({
  "status": "skipped"
});
});