$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/ProfileSettings.feature");
formatter.feature({
  "name": "As a user, I should be able to change profile info settings under the Profile module",
  "description": "  AC:\n  Display personal info under Profile Settings page\n  User can change any info under Profile Settings page",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "The user should change profile settings",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@login"
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
  "location": "com.meetsky.step_definitions.ProfileSettingsStepDef.the_user_is_on_the_login_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user enters Profile Settings",
  "keyword": "When "
});
formatter.match({
  "location": "com.meetsky.step_definitions.ProfileSettingsStepDef.theUserEntersProfileSettings()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user change profile settings",
  "keyword": "And "
});
formatter.match({
  "location": "com.meetsky.step_definitions.ProfileSettingsStepDef.theUserChangeProfileSettings()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user verify that the modification as follows",
  "rows": [
    {},
    {},
    {},
    {}
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "com.meetsky.step_definitions.ProfileSettingsStepDef.theUserVerifyThatTheModificationAsFollows(java.util.List\u003cjava.lang.String\u003e)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});