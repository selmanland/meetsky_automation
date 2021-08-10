$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/login.feature");
formatter.feature({
  "name": "Only authorized users should be able to login to the application",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@wip"
    }
  ]
});
formatter.scenario({
  "name": "the user logs in with valid credentials",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@wip"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "the user is on the login page",
  "keyword": "Given "
});
formatter.match({
  "location": "com.zerobank.step_definitions.LoginStepDefs.the_user_is_on_the_login_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user enters credentials",
  "keyword": "When "
});
formatter.match({
  "location": "com.zerobank.step_definitions.LoginStepDefs.the_user_enters_credentials()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the account summary page should be displayed",
  "keyword": "Then "
});
formatter.match({
  "location": "com.zerobank.step_definitions.LoginStepDefs.the_account_summary_page_should_be_displayed()"
});
formatter.result({
  "error_message": "java.lang.AssertionError: verify the account summary page is displayed\r\n\tat org.junit.Assert.fail(Assert.java:89)\r\n\tat org.junit.Assert.assertTrue(Assert.java:42)\r\n\tat com.zerobank.step_definitions.LoginStepDefs.the_account_summary_page_should_be_displayed(LoginStepDefs.java:37)\r\n\tat ✽.the account summary page should be displayed(file:///C:/Users/Administrator/IdeaProjects/fromgit/ZerobankAutomation/src/test/resources/features/login.feature:8)\r\n",
  "status": "failed"
});
formatter.embedding("image/png", "embedded0.png", "screenshot");
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "the user logs in with invalid credentials",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@wip"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "the user is on the login page",
  "keyword": "Given "
});
formatter.match({
  "location": "com.zerobank.step_definitions.LoginStepDefs.the_user_is_on_the_login_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user enters invalid credentials \"\" \"password\"",
  "keyword": "When "
});
formatter.match({
  "location": "com.zerobank.step_definitions.LoginStepDefs.the_user_enters_invalid_credentials(java.lang.String,java.lang.String)"
});
formatter.result({
  "error_message": "java.lang.NullPointerException\r\n\tat com.zerobank.step_definitions.LoginStepDefs.the_user_enters_invalid_credentials(LoginStepDefs.java:46)\r\n\tat ✽.the user enters invalid credentials \"\" \"password\"(file:///C:/Users/Administrator/IdeaProjects/fromgit/ZerobankAutomation/src/test/resources/features/login.feature:13)\r\n",
  "status": "failed"
});
formatter.step({
  "name": "error message should be displayed",
  "keyword": "Then "
});
formatter.match({
  "location": "com.zerobank.step_definitions.LoginStepDefs.error_message_should_be_displayed()"
});
formatter.result({
  "status": "skipped"
});
formatter.embedding("image/png", "embedded1.png", "screenshot");
formatter.after({
  "status": "passed"
});
});