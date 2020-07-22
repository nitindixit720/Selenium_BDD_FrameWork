package main.java.utility;

import com.github.javafaker.Faker;
import main.java.constants.Constant;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.java.base.BaseUtil;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;

import static java.util.concurrent.TimeUnit.SECONDS;

public class PagesHelper extends BaseUtil {

    public static void clearText(WebElement element) {
        waitExplicit(element, Constant.PagesHelperConstants.ELEMENTTOBECLICKABLE, Constant.PagesHelperConstants.TIME);
        element.clear();
    }

    //get text.
    public static String getText(WebElement element) {
        waitExplicit(element, Constant.PagesHelperConstants.ELEMENTTOBECLICKABLE, Constant.PagesHelperConstants.TIME);
        String value = element.getText().toLowerCase();
        return value;
    }

    //click element.
    public static void click(WebElement element) {
        waitExplicit(element, Constant.PagesHelperConstants.ELEMENTTOBECLICKABLE, Constant.PagesHelperConstants.TIME);
        element.click();
    }

    public static void wait(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void clickByIndexNo(List<WebElement> element, int i) {
        element.get(i).click();
    }

    public static void dragAndDrop(WebElement element1, int xOffset, int yOffset) {
        waitExplicit(element1, Constant.PagesHelperConstants.VISIBILITYOF, Constant.PagesHelperConstants.TIME);
        Actions act = new Actions(driver);
        act.dragAndDropBy(element1, xOffset, yOffset).perform();
    }

    public static String genarateRandomName() {
        Faker faker = new Faker();
        Random rand = new Random();
        return faker.name().fullName() + " " + rand.nextInt(100);
    }

    public static String getCurrentDate(String pattern) {
        DateFormat dateFormat = new SimpleDateFormat(pattern);
        Date today = Calendar.getInstance().getTime();
        String date = dateFormat.format(today);
        return date;
    }

    //open link in new tab.
    public static void openLinkInNewTab(WebElement element) {
        waitExplicit(element, Constant.PagesHelperConstants.ELEMENTTOBECLICKABLE, Constant.PagesHelperConstants.TIME);
        String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL, Keys.RETURN);
        element.sendKeys(selectLinkOpeninNewTab);
    }

    //Using java script click on element.
    public static void javaScriptClick(WebElement element) {
        waitExplicit(element, Constant.PagesHelperConstants.ELEMENTTOBECLICKABLE, Constant.PagesHelperConstants.TIME);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }

    //Send data.
    public static void sendKeys(WebElement element, String text) {
        waitExplicit(element, Constant.PagesHelperConstants.ELEMENTTOBECLICKABLE, Constant.PagesHelperConstants.TIME);
        element.sendKeys(text);
    }

    public static void pressEnter(WebElement element) {
        waitExplicit(element, Constant.PagesHelperConstants.ELEMENTTOBECLICKABLE, Constant.PagesHelperConstants.TIME);
        element.sendKeys(Keys.ENTER);
    }

    //extract numbers from String
    public static String getNumberFromString(String str) {
        String regex = "[^\\d]+";
        String[] numbers = str.split(regex);
        return numbers.length > 0 ? numbers[1] : "";
    }

    //Wait explicit for single element the element to load.
    public static void waitExplicit(WebElement element, String type, long waittime) {
        driver.manage().timeouts().implicitlyWait(10, SECONDS);
        System.out.println("Inside WaitExplicit " + element);
        WebDriverWait wait = new WebDriverWait(driver, waittime);
        String CaseType = type;
        switch (CaseType.toLowerCase()) {
            case Constant.PagesHelperConstants.VISIBILITYOF:
                wait.until(ExpectedConditions.visibilityOf(element));
                break;
            case Constant.PagesHelperConstants.ELEMENTTOBECLICKABLE:
                wait.until(ExpectedConditions.elementToBeClickable(element));
                break;
            case Constant.PagesHelperConstants.ELEMENTTOBESELECTED:
                wait.until(ExpectedConditions.elementToBeSelected(element));
                break;
            case Constant.PagesHelperConstants.INVISIBILITYOF:
                wait.until(ExpectedConditions.invisibilityOf(element));
                break;
            case Constant.PagesHelperConstants.STALENESSOF:
                wait.until(ExpectedConditions.stalenessOf(element));
                break;
            default:
                System.out.println("Method Name: waitexplicit-->Wrong Method Passed");
                break;
        }
    }

    //Wait explicit for more than one element.
    public static void waitExplicitElements(List<WebElement> elements, String type, long waittime) {
        driver.manage().timeouts().implicitlyWait(0, SECONDS);
        System.out.println("Inside waitExplicitElements ");
        WebDriverWait wait = new WebDriverWait(driver, waittime);
        String CaseType = type;
        switch (CaseType.toLowerCase()) {

            case Constant.PagesHelperConstants.VISIBILITYOFALLELEMENTS:
                wait.until(ExpectedConditions.visibilityOfAllElements(elements));
                break;
            case Constant.PagesHelperConstants.INVISIBILITYOFALLELEMENTS:
                wait.until(ExpectedConditions.invisibilityOfAllElements(elements));
                break;


            default:
                System.out.println("Method Name: waitExplicitElements-->Wrong Method Passed");
                break;
        }
    }

    //Is element displayed.

    public static int getOptionsListSize(WebElement element) {
        waitExplicit(element, Constant.PagesHelperConstants.ELEMENTTOBECLICKABLE, Constant.PagesHelperConstants.TIME);
        Select selectObj = new Select(element);
        return selectObj.getOptions().size();
    }

    public static int getSize(List<WebElement> element) {
        return element.size();
    }

    public static void sendFileImage(WebElement element, String text) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        element.sendKeys(text);
    }

    public static boolean isDisplayed(WebElement element) {
        waitExplicit(element, Constant.PagesHelperConstants.ELEMENTTOBECLICKABLE, Constant.PagesHelperConstants.TIME);
        boolean flag = element.isDisplayed();
        return flag;
    }


    protected boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }


    public static boolean isEnabled(WebElement element) {
        boolean flag = element.isEnabled();
        return flag;
    }

    //Is element selected.
    public static boolean isSelected(WebElement element) {
        waitExplicit(element, Constant.PagesHelperConstants.ELEMENTTOBECLICKABLE, Constant.PagesHelperConstants.TIME);
        boolean flag = element.isSelected();
        return flag;
    }

    //Select element.
    public static void selectElement(WebElement element, String type) {
        waitExplicit(element, Constant.PagesHelperConstants.ELEMENTTOBECLICKABLE, Constant.PagesHelperConstants.TIME);
        Select selectObj = new Select(element);
        int index = 0;
        List<WebElement> options = selectObj.getOptions();
        for (WebElement option : options) {
            if (option.getText().equalsIgnoreCase(type))
                break;
            index++;
        }
        selectObj.selectByIndex(index);
    }

    //select element by index
    public static void selectElementByIndex(WebElement element, int index) {
        //waitExplicit(element, Constant.PagesHelperConstants.ELEMENTTOBECLICKABLE, Constant.PagesHelperConstants.TIME);
        Select selectObj = new Select(element);
        selectObj.selectByIndex(index);
    }

    //Switch to active element.
    public static void switchToActiveElement() {
        driver.switchTo().activeElement();
    }

    //Select multiple checkbox.
    public static void selectMultipleElements(List<WebElement> elements) {
        for (int i = 0; i < elements.size(); i++) {
            WebElement element = elements.get(i);
            waitExplicit(element, Constant.PagesHelperConstants.ELEMENTTOBECLICKABLE, Constant.PagesHelperConstants.TIME);
            javaScriptClick(element);
        }
    }

    //Select Value from list.
    public static void waitForElementToDisplay(List<WebElement> elements, String value) {
        int number = Integer.parseInt(value);
        WebElement element = elements.get(number);
        boolean flag = element.isDisplayed();
        if (flag == true)
            javaScriptClick(element);
        else
            waitForElementToDisplay(elements, value);
    }

    //Check for element available.
    public static boolean isElementAvailable(List<WebElement> elements) {
        boolean flag = elements.size() > 0;
        return flag;
    }

//    public static void waitFluent(WebElement element) {
//        driver.manage().timeouts().implicitlyWait(0, SECONDS);
//
//        FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
//        wait.pollingEvery(250, TimeUnit.MILLISECONDS);
//        wait.withTimeout(50, TimeUnit.SECONDS);
//        wait.ignoring(NoSuchElementException.class);
//
//        Function<WebDriver, Boolean> function = new Function<WebDriver, Boolean>() {
//            public Boolean apply(WebDriver driver) {
//                return null;
//            }
//        };
//
//        wait.until(function);
//    }

    //wait for elements to load.
    public static void waitIfElementsIsDisplayed(List<WebElement> elements, String value) {
        int number = Integer.parseInt(value);
        WebElement element = elements.get(number);
        if (element.isDisplayed())
            waitIfElementsIsDisplayed(elements, value);
    }

    public static void waitIfElementIsDisplayed(WebElement element) {
        if (element.isDisplayed())
            waitIfElementIsDisplayed(element);
    }

    public static void moveToElement(WebElement element) {
        waitExplicit(element, Constant.PagesHelperConstants.ELEMENTTOBECLICKABLE, Constant.PagesHelperConstants.TIME);
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
    }

    public static void scrollDown(WebElement element) {
        waitExplicit(element, Constant.PagesHelperConstants.ELEMENTTOBECLICKABLE, Constant.PagesHelperConstants.TIME);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();", element);

    }

    public static String removeExtraValues(String value) {
        String replaceValue = value.replace("₹", " ").replace("-", " ").
                replace("\n", " ").replace(",", " ").replace("|", "").replaceAll(" +", " ").trim();
        return replaceValue;
    }


    public static String[] getAddress(String nameNumberAndAddress, String splitType) {
        String[] splitAddressValue = nameNumberAndAddress.split("\\|");
        String firstPartOfAddress = splitAddressValue[0].trim();
        String[] splitFirstPartOfAddress = firstPartOfAddress.split(splitType);
        String mobileNumber = splitFirstPartOfAddress[1].trim();
        String remainingFirstPartOfAddress = "";
        for (int i = 2; i < splitFirstPartOfAddress.length; i++) {
            remainingFirstPartOfAddress = remainingFirstPartOfAddress + splitFirstPartOfAddress[i];
        }
        String remainingPartOfAddress = "";
        for (int i = 1; i < splitAddressValue.length; i++) {
            remainingPartOfAddress = remainingPartOfAddress + splitAddressValue[i];
        }
        String address = removeExtraValues(remainingFirstPartOfAddress + " " + remainingPartOfAddress);
        return new String[]{mobileNumber, address};
    }

    public static void scrollToEndOfPage() {
        System.out.println("Inside scrollToEndOfPage");
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public static void scrollUsingValue(int value) {
        System.out.println("Inside scrollUsingValue");
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("scroll(0, " + value + ");");
    }

    public static void scrollUsingRobot() throws AWTException {
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_PAGE_DOWN);
        robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
    }

    public static void readTableClickOnHyperlink(LinkedHashMap<String, String> data, List<WebElement> orderIdNumbers) throws InterruptedException {
        for (int i = 0; i < Integer.parseInt(data.get("size")); i++) {
            openLinkInNewTab(orderIdNumbers.get(i));
        }
    }

    public static String getWindowHandle() {
        return driver.getWindowHandle();
    }

    public static Set<String> getWindowHandles() {
        return driver.getWindowHandles();
    }

    public static void switchToWindow(String winHandle) {
        driver.switchTo().window(winHandle);
    }

    public static void closeWindow() {
        driver.close();
    }

    public static List<String> getElementsValue(List<WebElement> elements) {
        PagesHelper.waitExplicitElements(elements, Constant.PagesHelperConstants.VISIBILITYOFALLELEMENTS, Constant.PagesHelperConstants.TIME);
        List<String> getElementsValueList = new ArrayList<String>();
        for (int i = 0; i < elements.size(); i++) {
            WebElement element = elements.get(i);
            getElementsValueList.add(getText(element).toLowerCase());
        }
        return getElementsValueList;
    }

    //Custom function for search four character and append all character one by one.
    public static void searchText(WebElement searchFilter, WebElement loading, String text) {
        String firstFourText = TestSuiteHelper.getCharFromText(text, 0, 4);
        sendKeys(searchFilter, firstFourText);
        waitIfElementIsDisplayed(loading);
        for (int i = 4; i < text.length(); i++) {
            String value = TestSuiteHelper.getCharFromText(text, i, i + 1);
            PagesHelper.sendKeys(searchFilter, value);
            waitIfElementIsDisplayed(loading);
        }
    }


}
