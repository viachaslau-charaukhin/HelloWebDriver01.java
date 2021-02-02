package TaskBringItOn.ObjectPageModel.page;

import TaskBringItOn.ObjectPageModel.test.WebDriverSeleniumHQTestBringItOn;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebDriverSeleniumHQResultPage {

    private WebDriver driver;
    public WebDriverSeleniumHQResultPage(WebDriver driver){
        this.driver = driver;
    }
    WebDriverSeleniumHQTestBringItOn waiter = new WebDriverSeleniumHQTestBringItOn();

    public String highlighting(){
        WebElement highlightingSynValue =
                waiter.waitForElementLocatedBy(driver,(By.xpath("//*[@class = 'left']/descendant::*[text()='Bash']")));
        return highlightingSynValue.getText();
    }

    public String areaContainer(){
        WebElement textAreaContainer =
                waiter.waitForElementLocatedBy(driver,(By.xpath("//*[@class = 'textarea']")));
        return textAreaContainer.getAttribute("value");
    }

    public String nameOfThePage(){
        return driver.getTitle();
    }
}
