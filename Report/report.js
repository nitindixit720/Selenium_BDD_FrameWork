$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("A_Login.feature");
formatter.feature({
  "line": 1,
  "name": "Login CRM",
  "description": "This feature deals with login functionality of CRM web",
  "id": "login-crm",
  "keyword": "Feature"
});
formatter.before({
  "duration": 8877103575,
  "status": "passed"
});
formatter.before({
  "duration": 45145030,
  "status": "passed"
});
formatter.scenario({
  "line": 5,
  "name": "Gmail Login with the valid username and password",
  "description": "",
  "id": "login-crm;gmail-login-with-the-valid-username-and-password",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 4,
      "name": "@sanity"
    },
    {
      "line": 4,
      "name": "@regression"
    }
  ]
});
formatter.step({
  "line": 6,
  "name": "A user is on the Gmail login page",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "I enter the username \"nitindixit720\"",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "I click on the next button",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "I enter the password \"aspirine91\"",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "I click on the final next button",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "I should see the welcome label on the page",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginSteps.java:19"
});
formatter.result({
  "duration": 189040941,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "nitindixit720",
      "offset": 22
    }
  ],
  "location": "LoginSteps.java:21"
});
formatter.result({
  "duration": 469241575,
  "status": "passed"
});
formatter.match({
  "location": "LoginSteps.java:27"
});
formatter.result({
  "duration": 182142598,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "aspirine91",
      "offset": 22
    }
  ],
  "location": "LoginSteps.java:24"
});
formatter.result({
  "duration": 660997483,
  "error_message": "org.openqa.selenium.StaleElementReferenceException: stale element reference: element is not attached to the page document\n  (Session info: chrome\u003d84.0.4147.89)\nFor documentation on this error, please visit: http://seleniumhq.org/exceptions/stale_element_reference.html\nBuild info: version: \u00273.14.0\u0027, revision: \u0027aacccce0\u0027, time: \u00272018-08-02T20:19:58.91Z\u0027\nSystem info: host: \u0027Nitins-MacBook-Air.local\u0027, ip: \u0027fe80:0:0:0:6:be75:1590:b88a%en0\u0027, os.name: \u0027Mac OS X\u0027, os.arch: \u0027x86_64\u0027, os.version: \u002710.14.6\u0027, java.version: \u00271.8.0_242\u0027\nDriver info: org.openqa.selenium.chrome.ChromeDriver\nCapabilities {acceptInsecureCerts: false, browserName: chrome, browserVersion: 84.0.4147.89, chrome: {chromedriverVersion: 84.0.4147.30 (48b3e868b4cc0..., userDataDir: /var/folders/r3/m531ljq154b...}, goog:chromeOptions: {debuggerAddress: localhost:50749}, javascriptEnabled: true, networkConnectionEnabled: false, pageLoadStrategy: normal, platform: MAC, platformName: MAC, proxy: Proxy(), setWindowRect: true, strictFileInteractability: false, timeouts: {implicit: 0, pageLoad: 300000, script: 30000}, unhandledPromptBehavior: dismiss and notify, webauthn:virtualAuthenticators: true}\nSession ID: cb2a3a37e7332f1b0f6919b4cc2e552a\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)\n\tat java.lang.reflect.Constructor.newInstance(Constructor.java:423)\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.createException(W3CHttpResponseCodec.java:187)\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:122)\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:49)\n\tat org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:158)\n\tat org.openqa.selenium.remote.service.DriverCommandExecutor.execute(DriverCommandExecutor.java:83)\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:548)\n\tat org.openqa.selenium.remote.RemoteWebElement.execute(RemoteWebElement.java:276)\n\tat org.openqa.selenium.remote.RemoteWebElement.isDisplayed(RemoteWebElement.java:317)\n\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\n\tat sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\n\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\n\tat java.lang.reflect.Method.invoke(Method.java:498)\n\tat org.openqa.selenium.support.pagefactory.internal.LocatingElementHandler.invoke(LocatingElementHandler.java:51)\n\tat com.sun.proxy.$Proxy16.isDisplayed(Unknown Source)\n\tat org.openqa.selenium.support.ui.ExpectedConditions.elementIfVisible(ExpectedConditions.java:315)\n\tat org.openqa.selenium.support.ui.ExpectedConditions.access$100(ExpectedConditions.java:44)\n\tat org.openqa.selenium.support.ui.ExpectedConditions$10.apply(ExpectedConditions.java:301)\n\tat org.openqa.selenium.support.ui.ExpectedConditions$10.apply(ExpectedConditions.java:298)\n\tat org.openqa.selenium.support.ui.ExpectedConditions$23.apply(ExpectedConditions.java:686)\n\tat org.openqa.selenium.support.ui.ExpectedConditions$23.apply(ExpectedConditions.java:682)\n\tat org.openqa.selenium.support.ui.FluentWait.until(FluentWait.java:260)\n\tat main.java.utility.PagesHelper.waitExplicit(PagesHelper.java:116)\n\tat main.java.utility.PagesHelper.clearText(PagesHelper.java:25)\n\tat main.java.feature_pages.LoginPage.setPassWord(LoginPage.java:39)\n\tat test.java.steps.LoginSteps.lambda$new$2(LoginSteps.java:25)\n\tat ✽.And I enter the password \"aspirine91\"(A_Login.feature:9)\n",
  "status": "failed"
});
formatter.match({
  "location": "LoginSteps.java:30"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "LoginSteps.java:33"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "duration": 2107203360,
  "status": "passed"
});
});