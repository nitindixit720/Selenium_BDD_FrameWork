package main.java.utility;

import io.github.bonigarcia.wdm.WebDriverManager;
import main.java.common.Common;
import main.java.constants.Constant;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import test.java.base.BaseUtil;

import java.io.IOException;

public class HooksHelper extends BaseUtil {

    public static WebDriver openChromeDriver() {
        /* To run your project in headless mode we have created different drivers */
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--no-sandbox");
//        options.addArguments("--headless");
//        options.addArguments("--start-maximized");
//        options.addArguments("--disable-dev-shm-usage");
//        options.addArguments("--disable-gpu");
        /* Here we have used web driver manager concept were we are not maintaining the drivers in our project
        * We are just downloading the dependency in our POM */
        ChromeOptions options = new ChromeOptions();
        options.setBinary("/Applications/Google Chrome.app/Contents/MacOS/Google Chrome");
        //WebDriver driver = new ChromeDriver(options);
        WebDriverManager.chromedriver().setup();
        /* This if body is operate on the env condition whether the env is local or server */
        if (System.getProperty(Constant.HooksConstant.ENVIRONMENT, Constant.HooksConstant.SERVERENVIRONMENT).equalsIgnoreCase(Constant.HooksConstant.SERVERENVIRONMENT)) {
            driver = new ChromeDriver(options);
        } else {
            //**************** When your running script on local *********************//
            driver=new ChromeDriver();
        }
        return driver;
    }

    public static WebDriver openFirefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        return driver;
    }

    public static void onFinish() {
        SlackMessageHelper slackMessage = new SlackMessageHelper();
        String[] values = System.getProperty("url", "provide your default URL").split("[^a-z]");
        String environment = values[3];
        int totalTestsCount = Common.TestCount.PASSCOUNT + Common.TestCount.FAILCOUNT + Common.TestCount.SKIPCOUNT;
        System.out.println("PASS---" + Common.TestCount.PASSCOUNT);
        System.out.println("FAIL---" + Common.TestCount.FAILCOUNT);
        System.out.println("SKIP---" + Common.TestCount.SKIPCOUNT);
        String reportLink = Constant.SlackMessageConstants.SERVER_URL + TestSuiteHelper.getFileName();
        /* In this if condition your passing the message to your slack channel along with pass fail condition */
        if (Common.TestCount.FAILCOUNT > 0) {
            String message = "[" + environment + "] " + Constant.ExtentManagerConstant.TESTCASENAME.toLowerCase() + ": " +
                    Common.TestCount.PASSCOUNT + "/" + totalTestsCount + " scenarios passed | " + reportLink +
                    " |One or more tests from one or more feature have failed. :cry:";
            try {
                S3UploadHelper.uploadReportToS3Bucket(Constant.S3UploadFileConstats.REPORTFILEOBJECTKEYNAME,
                        Constant.S3UploadFileConstats.REPORTFILENAME, Constant.S3UploadFileConstats.HTMLCONTENTTYPE);
                slackMessage.sendMessage(Constant.SlackMessageConstants.CHANNEL, message, Constant.SlackMessageConstants.TOKEN);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            String message = "[" + environment + "] " + Constant.ExtentManagerConstant.TESTCASENAME.toLowerCase() + ": " +
                    Common.TestCount.PASSCOUNT + "/" + totalTestsCount + " scenarios passed | " + reportLink +
                    " |All tests from all feature file have passed. :dancing_panda:";
            try {
                S3UploadHelper.uploadReportToS3Bucket(Constant.S3UploadFileConstats.REPORTFILEOBJECTKEYNAME,
                        Constant.S3UploadFileConstats.REPORTFILENAME, Constant.S3UploadFileConstats.HTMLCONTENTTYPE);
                slackMessage.sendMessage(Constant.SlackMessageConstants.CHANNEL, message, Constant.SlackMessageConstants.TOKEN);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        driver.quit();
    }

}
