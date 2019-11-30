$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri('placeHolder.feature');
formatter.feature({
  "line": 1,
  "name": "test calculator service",
  "description": "\r\nScenario : test calculator with integer\r\n  Given I have MainApp running\r\n  When I set value to 2\r\n  And I wait for 1 seconds\r\n  Then I should have 4\r\n\r\n  Given I have MainApp running\r\n  When I set value to 5\r\n  And I wait for 1 seconds\r\n  Then I should have 7\r\n\r\n  Given I have MainApp running\r\n  When I set value to 1000\r\n  And I wait for 1 seconds\r\n  Then I should have 1002",
  "id": "test-calculator-service",
  "keyword": "Feature"
});
});