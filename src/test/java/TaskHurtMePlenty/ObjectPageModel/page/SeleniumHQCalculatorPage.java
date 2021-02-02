package TaskHurtMePlenty.ObjectPageModel.page;

import TaskHurtMePlenty.ObjectPageModel.test.WebDriverSeleniumHQTestHurtMePlenty;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SeleniumHQCalculatorPage {
    private WebDriver driver;
    WebDriverSeleniumHQTestHurtMePlenty waiter = new WebDriverSeleniumHQTestHurtMePlenty();

    public SeleniumHQCalculatorPage(WebDriver driver){
        this.driver = driver;
    }

    public SeleniumHQCalculatorPage setParams(){
        driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='cloud-site']/descendant::iframe")));
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='myFrame']")));

        WebElement numberOfInstances = waiter.waitForElementLocatedBy(driver,By.xpath("//*[@id='input_63']"));
        numberOfInstances.click();
        numberOfInstances.sendKeys("4");

        WebElement operatingSystemList = waiter.waitForElementLocatedBy(driver,
                By.xpath("//*[@id='select_value_label_56']"));
        operatingSystemList.click();

        WebElement operatingSystemValue =
                waiter.waitForElementLocatedBy(driver,By.xpath("//*[@id='select_option_65']"));
        operatingSystemValue.click();

        WebElement machineClassList =
                waiter.waitForElementLocatedBy(driver,By.xpath("//*[@id='select_value_label_57']"));
        machineClassList.click();

        WebElement machineClassValue = waiter.waitForElementLocatedBy(driver,By.xpath("//*[@id='select_option_78']"));
        machineClassValue.click();

        WebElement seriesList = waiter.waitForElementLocatedBy(driver,By.xpath("//*[@id='select_value_label_59']"));
        seriesList.click();

        WebElement seriesValue = waiter.waitForElementLocatedBy(driver,By.xpath("//*[@id='select_option_188']"));
        seriesValue.click();

        WebElement machineTypeList =
                waiter.waitForElementLocatedBy(driver,By.xpath("//*[@id='select_value_label_60']"));
        machineTypeList.click();

        WebElement machineTypeValue = waiter.waitForElementLocatedBy(driver,By.xpath("//*[@id='select_option_360']"));
        machineTypeValue.click();

        WebElement checkboxAddGPU =
                waiter.waitForElementLocatedBy(driver,By.xpath("//*[@ng-model='listingCtrl.computeServer.addGPUs']"));
        checkboxAddGPU.click();

        WebElement numberGPUList = waiter.waitForElementLocatedBy(driver,By.xpath("//*[@id='select_value_label_392']"));
        numberGPUList.click();

        WebElement numberGPUValue = waiter.waitForElementLocatedBy(driver,By.xpath("//*[@id='select_option_399']"));
        numberGPUValue.click();

        WebElement typeGPUList = waiter.waitForElementLocatedBy(driver,By.xpath("//*[@id='select_value_label_393']"));
        typeGPUList.click();

        WebElement typeGPUValue = waiter.waitForElementLocatedBy(driver,By.xpath("//*[@id='select_option_406']"));
        typeGPUValue.click();

        WebElement localSSDList = waiter.waitForElementLocatedBy(driver,By.xpath("//*[@id='select_value_label_354']"));
        localSSDList.click();

        WebElement localSSDValue = waiter.waitForElementLocatedBy(driver,By.xpath("//*[@id='select_option_381']"));
        localSSDValue.click();

        WebElement datacenterLocationList = waiter.waitForElementLocatedBy(driver,
                By.xpath("//*[@id='select_value_label_61']"));
        datacenterLocationList.click();

        WebElement datacenterLocationValue = waiter.waitForElementLocatedBy(driver,
                By.xpath("//*[@id='select_option_205']"));
        datacenterLocationValue.click();

        WebElement committedUsageList = waiter.waitForElementLocatedBy(driver,
                By.xpath("//*[@id='select_value_label_62']"));
        committedUsageList.click();

        WebElement committedUsageValue = waiter.waitForElementLocatedBy(driver,By.xpath("//*[@id='select_option_97']"));
        committedUsageValue.click();

        WebElement addToEstimateButton =
                waiter.waitForElementLocatedBy(driver,
                        By.xpath("//*[@id='mainForm']/descendant::button[contains(@ng-disabled,'computeServer')]"));
        addToEstimateButton.click();

        return new SeleniumHQCalculatorPage(driver);
    }
}
