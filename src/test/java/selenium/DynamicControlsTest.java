package selenium;

import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class DynamicControlsTest extends BaseTest {
    private final By DYNAMIC_CONTROL = By.xpath(String.format(PRECISE_TEXT_XPATH, "Dynamic Controls"));
    private final By ENABLE = By.xpath(String.format(PRECISE_TEXT_XPATH, "Enable"));
    private final By INPUT =By.xpath ( "//*[@id='input-example']//input");
    private final String RANDOM_TEXT = UUID.randomUUID().toString();



    @Test
    public void dynamicControlsTest() {
        driver.findElement(DYNAMIC_CONTROL).click();
        driver.findElement(ENABLE).click();
        WebElement inputField= driver.findElement(INPUT);
        Assert.assertTrue(isClickable(inputField),"element wasn't enabled");
        inputField.sendKeys(RANDOM_TEXT);
        Assert.assertTrue(driver.findElement(INPUT).getAttribute("value"), RANDOM_TEXT, "Text is not displayed");
        // todo: assert input is enabled
        // todo: input random generated text
        // todo: assert inputted text
    }

    private boolean isClickable(WebElement element){
        try{
            wait.until(ExpectedConditions.elementToBeClickeable(element));

        }
        catch (TimeoutException exception){
            return false;
        }
        return true;
    }
}
