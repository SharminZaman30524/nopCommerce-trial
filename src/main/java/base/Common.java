package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.xml.XmlTest;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class Common {
    public static WebDriver driver;
    public static WebDriverWait wait;
    public static JavascriptExecutor js;

    @Parameters({"browser", "url"})
    @BeforeMethod
    public void startUp(@Optional() String browser, @Optional() String url) {
        if (browser.equalsIgnoreCase("Chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        } else if (browser.equalsIgnoreCase("Safari")) {
            WebDriverManager.safaridriver().setup();
            driver = new SafariDriver();
        }
        driver.get(url);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(30)); //must create an instance of the webdriver in every test class
        js = (JavascriptExecutor) driver;
    }

    @AfterMethod
    public void tearDown(ITestResult testResult) {
        if (ITestResult.FAILURE == testResult.getStatus()) {
            takeScreenshot(testResult.getName());
        }
        {
            driver.quit();
        }
    }

    /**
     * Common API Methods
     */

    public void click(WebElement element) {
        try {
            element.click();
        } catch (NoSuchElementException ex) {
            wait.until(ExpectedConditions.visibilityOf(element));
            element.click();
        } catch (ElementClickInterceptedException ex) {
            js.executeScript("arguments[0].click();", element);
        }
        catch (ElementNotInteractableException ex) {
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
        }
    }

    public void submit(WebElement element) {
        try {
            element.submit();
        } catch (NoSuchElementException ex) {
            wait.until(ExpectedConditions.visibilityOf(element));
            element.submit();
        }
    }

    public void type(WebElement element, String text) {
        try {
            element.sendKeys(text);
        } catch (NoSuchElementException ex) {
            wait.until(ExpectedConditions.visibilityOf(element));
            element.sendKeys(text);
        }
    }

    public String getTextFromWebElement(WebElement element) {
        try {
            return element.getText().trim();
        } catch (NoSuchElementException ex) {
            wait.until(ExpectedConditions.visibilityOf(element));
            return element.getText().trim();
        }
    }

    public String getURL() {
        return driver.getCurrentUrl();
    }

    /**
     * Helper Methods
     */
    public void takeScreenshot(String testName) {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File fileSrc = ts.getScreenshotAs(OutputType.FILE);
        String fileDes = System.getProperty("user.dir") + ".\\screenshot\\" + testName + ".png";
        try {
            FileUtils.copyFile(fileSrc, new File(fileDes));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
