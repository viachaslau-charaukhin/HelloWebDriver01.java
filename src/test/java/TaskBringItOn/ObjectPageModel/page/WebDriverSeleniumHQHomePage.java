package TaskBringItOn.ObjectPageModel.page;

import TaskBringItOn.ObjectPageModel.test.WebDriverSeleniumHQTestBringItOn;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebDriverSeleniumHQHomePage {
    private static final String HOMEPAGE_URL = "https://pastebin.com/";
    private WebDriver driver;

    public WebDriverSeleniumHQHomePage(WebDriver driver){
        this.driver = driver;
    }

    public WebDriverSeleniumHQHomePage openPage(){
        driver.get(HOMEPAGE_URL);
        return this;
    }

    public WebDriverSeleniumHQHomePage setDataToTheForm(String titleText, String areaText){
        WebDriverSeleniumHQTestBringItOn waiter = new WebDriverSeleniumHQTestBringItOn();

        WebElement postTitle = waiter.waitForElementLocatedBy(driver, By.xpath("//*[@id='postform-name']"));
        postTitle.sendKeys(titleText);

        WebElement postFormText = waiter.waitForElementLocatedBy(driver,By.xpath("//*[@id='postform-text']"));
        postFormText.sendKeys(areaText);

        WebElement postExpirationTimeList =
                waiter.waitForElementLocatedBy(driver,By.xpath("//*[@id='select2-postform-expiration-container']"));
        postExpirationTimeList.click();

        WebElement postExpirationTimeValue =
                waiter.waitForElementLocatedBy(driver,(By.xpath("//li[text()='10 Minutes']")));
        postExpirationTimeValue.click();

        WebElement highlightingContainer =
                waiter.waitForElementLocatedBy(driver,By.xpath("//*[@id='select2-postform-format-container']"));
        highlightingContainer.click();

        WebElement postHighlightingType =
                driver.findElement(By.xpath("//li[text()='Bash']"));
        postHighlightingType.click();

        //pastebin.com has banner which can affect clicking on the button for creating paste
        //but this banner appears time to time

        Boolean isBannerPresent01 = driver.findElements(By.xpath("//div[@class='bsa_fixed-leaderboard']")).size() > 0;

        if(isBannerPresent01 == true){
            waiter.waitForElementLocatedBy(driver,By.xpath("//div[@class='bsa_fixed-leaderboard']"));
            WebElement bannerCloseButton = waiter.waitForElementLocatedBy(driver,By.xpath("//a[text()='x']"));
            bannerCloseButton.click();
        };

        Boolean isBannerPresent02 = driver.findElements(By.xpath("//button[@id='pixfuture-close']")).size() > 0;

        if(isBannerPresent02 == true){
            WebElement bannerCloseButton = waiter.waitForElementLocatedBy(driver,By.xpath("//button[@id='pixfuture-close']"));
            bannerCloseButton.click();
        };

        WebElement createNewPaste =
                waiter.waitForElementLocatedBy(driver,By.xpath("//*[@class='btn -big']"));
        createNewPaste.click();
        return new WebDriverSeleniumHQHomePage(driver);
    }
}
