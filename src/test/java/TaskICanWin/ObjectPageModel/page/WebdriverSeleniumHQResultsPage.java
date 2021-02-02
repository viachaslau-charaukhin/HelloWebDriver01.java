package TaskICanWin.ObjectPageModel.page;

import TaskICanWin.ObjectPageModel.test.WebDriverSeleniumHQTestICanWin;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebdriverSeleniumHQResultsPage {

    private WebDriver driver;

    public WebdriverSeleniumHQResultsPage(WebDriver driver){
        this.driver = driver;
    }

    public String resultPage(){
        WebDriverSeleniumHQTestICanWin waiter = new WebDriverSeleniumHQTestICanWin();
        WebElement pasteTextArea =
            waiter.waitForElementLocatedBy(driver, By.xpath("//*[@class = 'textarea']"));
        String resultValue = pasteTextArea.getText();
        return resultValue;
    }
}
