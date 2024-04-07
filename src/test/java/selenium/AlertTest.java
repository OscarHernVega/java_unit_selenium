package selenium;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class AlertTest extends BaseTest {
    private final By JS_ALERT = By.xpath(String.format(PRECISE_TEXT_XPATH, "JavaScript Alerts"));
    private final By CLICK_FOR_JS_ALERT_BUTTON = By.xpath("//button[@onclick='jsAlert()']");
    private final By SUCCESS_MSG_LOCATION = By.xpath(String.format(PRECISE_TEXT_XPATH, "You succesfully clicked on alert"));




    @Test
    public void alertTest() {
        Assert.assertTrue(driver.findElement(By.xpath(JS_ALERT)).isDisplayed(), "alert is not displayed");
        driver.findElement(JS_ALERT).click();
        driver.switchTo().alert().accept();
        Assert.assertTrue(driver.findElement(SUCCESS_MSG_LOCATION).isDisplayed(), "Success message is not displayed");
        
        // todo: accept alert
        // todo: assert success message
    }

}

