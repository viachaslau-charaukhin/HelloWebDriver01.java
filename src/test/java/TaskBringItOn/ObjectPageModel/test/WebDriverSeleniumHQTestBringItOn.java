package TaskBringItOn.ObjectPageModel.test;

import TaskBringItOn.ObjectPageModel.page.WebDriverSeleniumHQHomePage;
import TaskBringItOn.ObjectPageModel.page.WebDriverSeleniumHQResultPage;
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


public class WebDriverSeleniumHQTestBringItOn {

    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test (description = "Test for task 'Bring It On'")
    public void pasteBringItOn() {

        String titleText = "how to gain dominance among developers";

        String areaText = "git config --global user.name  \"New Sheriff in Town\"\n" +
                "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                "git push origin master --force";

        String highlightingType = "Bash";

        new WebDriverSeleniumHQHomePage(driver)
                .openPage()
                .setDataToTheForm(titleText,areaText);

        String resultHighlighting = new WebDriverSeleniumHQResultPage(driver).highlighting();

        String resultTextAreaContainer = new WebDriverSeleniumHQResultPage(driver).areaContainer();

        String resultTitleOfThePage = new WebDriverSeleniumHQResultPage(driver).nameOfThePage();

        Assert.assertTrue(resultHighlighting.contains(highlightingType),
                "Type of the highlighting is not correct!");
        Assert.assertTrue(resultTitleOfThePage.contains(titleText),
                "Title of the page is not correct!");
        Assert.assertTrue(resultTextAreaContainer.contentEquals(areaText),
                "Text container contains wrong text!");
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown(){
        driver.quit();
        driver = null;
    }

    public static WebElement waitForElementLocatedBy(WebDriver driver, By by) {
        return new WebDriverWait(driver, 25)
                .until(ExpectedConditions.elementToBeClickable(by));
    }
}
