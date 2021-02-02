package TaskBringItOn.WithoutOP;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;


public class WebDriverSeleniumHQTestBringItOn {
    @Test
    public void pasteBringItOn() {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://pastebin.com/");

        //pastebin.com has banner which can affect clicking on the button for creation paste
        //but this banner appears time to time and it's a problem
        /*WebElement banner =
                waitForElementLocatedBy(driver,By.xpath("//*[@id='google_ads_iframe_/8691100/Pastebin_S2S_FixedFooter_ROS_0']"));
        WebElement bannerCloseButton = waitForElementLocatedBy(driver,By.xpath("//a[text()='x']"));
        bannerCloseButton.click();*/

        String titleText = "how to gain dominance among developers";
        WebElement postTitle = waitForElementLocatedBy(driver, By.xpath("//*[@id='postform-name']"));
        postTitle.sendKeys(titleText);

        String areaText = "git config --global user.name  \"New Sheriff in Town\"\n" +
                "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                "git push origin master --force";
        WebElement postFormText = waitForElementLocatedBy(driver,By.xpath("//*[@id='postform-text']"));
        postFormText.sendKeys(areaText);

        WebElement postExpirationTimeList =
                waitForElementLocatedBy(driver,By.xpath("//*[@id='select2-postform-expiration-container']"));
        postExpirationTimeList.click();

        WebElement postExpirationTimeValue =
                waitForElementLocatedBy(driver,(By.xpath("/html/body/span[2]/span/span[2]/ul/li[3]")));
        postExpirationTimeValue.click();

        WebElement highlightingContainer =
                waitForElementLocatedBy(driver,By.xpath("//*[@id='select2-postform-format-container']"));
        highlightingContainer.click();

        WebElement postHighlightingType =
                driver.findElement(By.xpath("/html/body/span[2]/span/span[2]/ul/li[2]/ul/li[1]"));
        String postHighlightingTypeName = postHighlightingType.getText();
        postHighlightingType.click();

        WebElement createNewPaste =
                waitForElementLocatedBy(driver,By.xpath("//*[@class='btn -big']"));
        createNewPaste.click();

        WebElement highlightingSynValue =
                waitForElementLocatedBy(driver,(By.xpath("//*[@class = 'left']/descendant::*[text()='Bash']")));
        String synValue = highlightingSynValue.getText();
        System.out.println("\nHighlighting type is:\n" + synValue);

        WebElement textAreaContainer =
                waitForElementLocatedBy(driver,(By.xpath("//*[@class = 'textarea']")));
        String textAreaResult = textAreaContainer.getAttribute("value");
        System.out.println("\nText in text container is:\n" + textAreaResult);

        String nameOfThePage = driver.getTitle();
        System.out.println("\nTitle is:\n" + nameOfThePage);

        Assert.assertTrue(synValue.contains(postHighlightingTypeName), "Type of highlighting is not correct!");
        Assert.assertTrue(nameOfThePage.contains(titleText), "Title of the page is not correct!");
        Assert.assertTrue(textAreaResult.contentEquals(areaText), "Text container contains wrong text!");

        driver.quit();
    }
    public static WebElement waitForElementLocatedBy(WebDriver driver, By by) {
        return new WebDriverWait(driver, 25)
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }
}
