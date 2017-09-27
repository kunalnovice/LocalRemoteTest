$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("ContactUs.feature");
formatter.feature({
  "line": 1,
  "name": "ContactUs.feature",
  "description": "",
  "id": "contactus.feature",
  "keyword": "Feature"
});
formatter.before({
  "duration": 5558195723,
  "status": "passed"
});
formatter.scenario({
  "line": 4,
  "name": "Contact Us1",
  "description": "",
  "id": "contactus.feature;contact-us1",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 3,
      "name": "@one"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "I am on QAWorks Site",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "I should be able to contact QA Works with the following information",
  "rows": [
    {
      "cells": [
        "name",
        "J.Bloggs"
      ],
      "line": 7
    },
    {
      "cells": [
        "email",
        "J.Bloggs@Qaworks.com"
      ],
      "line": 8
    },
    {
      "cells": [
        "message",
        "Please contact me I want to find out more"
      ],
      "line": 9
    }
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "ContactUsStepdefs.iAmOnQAWorksSite()"
});
formatter.result({
  "duration": 3836211789,
  "status": "passed"
});
formatter.match({
  "location": "ContactUsStepdefs.iShouldBeAbleToContactQAWorksWithTheFollowingInformation(DataTable)"
});
formatter.result({
  "duration": 6642958020,
  "status": "passed"
});
formatter.after({
  "duration": 3099560508,
  "status": "passed"
});
formatter.before({
  "duration": 3122650766,
  "status": "passed"
});
formatter.scenario({
  "line": 13,
  "name": "Picking Test Data from Proper File",
  "description": "",
  "id": "contactus.feature;picking-test-data-from-proper-file",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 12,
      "name": "@one"
    }
  ]
});
formatter.step({
  "line": 14,
  "name": "I am on QAWorks Site",
  "keyword": "Given "
});
formatter.step({
  "line": 15,
  "name": "I should be able to contact QA Works with the following information",
  "rows": [
    {
      "cells": [
        "name",
        "J.Bloggs"
      ],
      "line": 16
    },
    {
      "cells": [
        "email",
        "J.Bloggs@Qaworks.com"
      ],
      "line": 17
    },
    {
      "cells": [
        "message",
        "Please contact me I want to find out more"
      ],
      "line": 18
    }
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "ContactUsStepdefs.iAmOnQAWorksSite()"
});
formatter.result({
  "duration": 2094711934,
  "status": "passed"
});
formatter.match({
  "location": "ContactUsStepdefs.iShouldBeAbleToContactQAWorksWithTheFollowingInformation(DataTable)"
});
formatter.result({
  "duration": 7585652674,
  "status": "passed"
});
formatter.after({
  "duration": 2661317223,
  "status": "passed"
});
formatter.before({
  "duration": 3366880255,
  "status": "passed"
});
formatter.scenario({
  "line": 27,
  "name": "some scenario- Exception failing scenario always",
  "description": "",
  "id": "contactus.feature;some-scenario--exception-failing-scenario-always",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 26,
      "name": "@one"
    }
  ]
});
formatter.step({
  "line": 28,
  "name": "I am on some Page",
  "keyword": "Given "
});
formatter.match({
  "location": "MyTestStepdefs.iAmOnThPage()"
});
formatter.result({
  "duration": 2165625927,
  "error_message": "java.lang.Exception\r\n\tat StepDefinitions.MyTestStepdefs.iAmOnThPage(MyTestStepdefs.java:12)\r\n\tat ✽.Given I am on some Page(ContactUs.feature:28)\r\n",
  "status": "failed"
});
formatter.embedding("image/png", "embedded0.png");
formatter.after({
  "duration": 5545817694,
  "status": "passed"
});
});