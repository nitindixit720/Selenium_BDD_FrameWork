package main.java.constants;

import main.java.utility.TestSuiteHelper;

import java.io.File;

public class Constant {

    public static final String PROJECTPATH = System.getProperty("user.dir");


    public static class PagesHelperConstants {
        public static final String VISIBILITYOF = "visibilityof";
        public static final String VISIBILITYOFALLELEMENTS = "visibilityOfAllElements";
        public static final String ELEMENTTOBECLICKABLE = "elementtobeclickable";
        public static final String ELEMENTTOBESELECTED = "elementtobeselected";
        public static final String INVISIBILITYOF = "invisibilityof";
        public static final String INVISIBILITYOFALLELEMENTS = "invisibilityOfAllElements";
        public static final String STALENESSOF = "stalenessOf";
        public static final int TIME = 20;
    }

    // Give the report Name and Path
    public static class ExtentManagerConstant {
        public static final String TESTCASENAME = "project_name";
        public static final String REPORTSPATH = PROJECTPATH + File.separatorChar + "Reports" + File.separatorChar;
    }

    // If your run the project through command line these are the key and their respective default
    // values (if in case you forget to pass it)
    public static class HooksConstant {
        public static final String URLKEY = "url";
        public static final String DEFAULTURL = "Default base URL";
        public static final String ENVIRONMENT = "env";
        public static final String LOCALENVIRONMENT = "local";
        public static final String SERVERENVIRONMENT = "server";
    }

    //From here your providing the screenshot path from this project and also you have to provide path to upload S3 bucket URL
    public static class TakeScreenShotConstant {
        public static final String SCREENSHOTPATH = PROJECTPATH + File.separatorChar + "src" + File.separatorChar + "test" + File.separatorChar + "resources" + File.separatorChar + "ScreenShots" + File.separatorChar;
        public static final String SCREENSHOTS3PATH = "provide S3 bucket URL (URL= S3 bucket base url + bucket name + screnntshot folder name )";
    }

    /* In your organization if your using the slack chanel, Then you can also send your test result report on
     * slack channel along with pass and fail count. here you just have to add your slack token and chanel name with
     * S3 bucket path to the report folder  */
    public static class SlackMessageConstants {
        public static final String TOKEN = " Provide Slack auth token";
        public static final String CHANNEL = "Slack Chanel Name";
        public static final String SERVER_URL = "provide S3 bucket URL (URL= S3 bucket base url + bucket name + report folder name)";
    }

    /* Here your getting the no of passed and failed test cases count .. Which you can send into your slack channel
     * So that non tech user will also get the status of report without opening it*/
    public static class ExtentTestResult {
        public static final String PASSTEST = "passed";
        public static final String FAILTEST = "failed";
        public static final String SKIPTEST = "skiped";
    }

    /* Thease are the S3 bucket upload constants*/
    public static class S3UploadFileConstats {
        public static final String BUCKETNAME = "provide bucket name";
        public static final String REPORTFILEOBJECTKEYNAME = "Provide path to your report folder" + TestSuiteHelper.getFileName();
        public static final String REPORTFILENAME = ExtentManagerConstant.REPORTSPATH + TestSuiteHelper.getFileName();
        public static final String ACCESSKEY = "S3 bucket access keys";
        public static final String SECRETKEY = "S3 bucket secret key";
        public static final String HTMLCONTENTTYPE = "text/html";
        public static final String SCREENSHOTFILEOBJECTKEYNAME = "Provide path to your screenshot folder";
        public static final String PNGCONTENTYPE = "image/png";
    }

}


