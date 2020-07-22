package main.java.feature_pages;


import main.java.utility.PagesHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import test.java.base.BaseUtil;

public class LoginPage extends BaseUtil {

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@type='email']")
    @CacheLookup
    WebElement userName;

    @FindBy(xpath = "//div[@class='VfPpkd-RLmnJb']")
    @CacheLookup
    WebElement next1Button;

    @FindBy(xpath = "//div[@id='passwordNext']//div[2]")
    @CacheLookup
    WebElement next2Button;

    @FindBy(xpath = "//input[@type='password']")
    @CacheLookup
    WebElement passWord;

    @FindBy(xpath = "x path of welcome lable")
    @CacheLookup
    WebElement welcomeLable;

    public void setUserName(String setUName) {
        PagesHelper.clearText(userName);
        PagesHelper.sendKeys(userName, setUName);
    }

    public void setPassWord(String enterPassword) {
        PagesHelper.clearText(passWord);
        PagesHelper.sendKeys(passWord, enterPassword);
    }

    public void setNext1Button() {
        PagesHelper.click(next1Button);
    }

    public void setNext2Button() {
        PagesHelper.click(next2Button);
    }

    public boolean verifyWelcomeLable(){
        return PagesHelper.isDisplayed(welcomeLable);
    }

}




