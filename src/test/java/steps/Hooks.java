package test.java.steps;


import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import main.java.common.Common;
import main.java.constants.Constant;
import main.java.utility.HooksHelper;
import main.java.utility.TestSuiteHelper;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogType;
import test.java.base.BaseUtil;

import java.util.concurrent.TimeUnit;

public class Hooks extends BaseUtil {

    private static boolean beforeFlag = false;

    @Before(order = 0)
    public void beforeAll() {
        if (!beforeFlag) {
            String browserName = System.getProperty("browser", "chrome");
            switch (browserName.toLowerCase()) {
                case "chrome":
                    driver = HooksHelper.openChromeDriver();
                    break;
                case "firefox":
                    driver = HooksHelper.openFirefoxDriver();
                    break;

                default:
                    HooksHelper.openChromeDriver();
                    break;
            }
            if (System.getProperty(Constant.HooksConstant.ENVIRONMENT, Constant.HooksConstant.LOCALENVIRONMENT).equalsIgnoreCase(Constant.HooksConstant.LOCALENVIRONMENT)) {
                driver.manage().timeouts().implicitlyWait(Constant.PagesHelperConstants.TIME, TimeUnit.SECONDS);
                driver.manage().window().maximize();
            }
            Common.HookClass.URL = System.getProperty(Constant.HooksConstant.URLKEY, Constant.HooksConstant.DEFAULTURL);
            driver.get(Common.HookClass.URL);
            beforeFlag = true;
        }
    }

    @After
    public void tearDown(Scenario scenario) {
        TestSuiteHelper.updateCount(scenario.getStatus());
        if (scenario.isFailed()) {
            LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
            TestSuiteHelper.takeScreenShotHelper();
            TestSuiteHelper.extractLogs(logEntries);
        }

    }


    private static final Thread CLOSE_THREAD = new Thread() {
        @Override
        public void run() {
            HooksHelper.onFinish();
        }
    };

    static {
        Runtime.getRuntime().addShutdownHook(CLOSE_THREAD);
    }


}
