package TaskICanWin.ObjectPageModel.test;

import TaskICanWin.ObjectPageModel.page.WebDriverSeleniumHQHomePage;
import TaskICanWin.ObjectPageModel.page.WebdriverSeleniumHQResultsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WebDriverSeleniumHQTestICanWin {

    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test (description = "Test for task 'I Can Win'")
    public void creatingPaste() {
        String titleText = "helloweb";
        String areaText = "Hello from WebDriver";

        new WebDriverSeleniumHQHomePage(driver)
                .openPage()
                .setDataToTheForm(titleText,areaText);

        String resultValue = new WebdriverSeleniumHQResultsPage(driver).resultPage();

        Assert.assertTrue(resultValue.contains(areaText), "Result value is not the same as entered!");
    }

    @AfterMethod (alwaysRun = true)
    public void browserTearDown(){
        driver.quit();
        driver = null;
    }

    public static WebElement waitForElementLocatedBy(WebDriver driver, By by) {
        return new WebDriverWait(driver, 20)
                .until(ExpectedConditions.elementToBeClickable(by));
    }
}
