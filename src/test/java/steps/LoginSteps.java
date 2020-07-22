package test.java.steps;

import cucumber.api.java.Before;
import cucumber.api.java8.En;
import main.java.feature_pages.LoginPage;

import static main.java.utility.TestSuiteHelper.verifyTrueBooleanValue;


public class LoginSteps implements En {
    LoginPage loginObj;

    @Before
    public void before() {
        loginObj = new LoginPage();
    }

    public LoginSteps() {
        Given("^A user is on the Gmail login page$", () -> {
        });
        When("^I enter the username \"([^\"]*)\"$", (String userName) -> {
            loginObj.setUserName(userName);
        });
        And("^I enter the password \"([^\"]*)\"$", (String password) -> {
            loginObj.setPassWord(password);
        });
        And("^I click on the next button$", () -> {
            loginObj.setNext1Button();
        });
        And("^I click on the final next button$", () -> {
            loginObj.setNext2Button();
        });
        Then("^I should see the welcome label on the page$", () -> {
            verifyTrueBooleanValue(loginObj.verifyWelcomeLable());
        });
    }
}
