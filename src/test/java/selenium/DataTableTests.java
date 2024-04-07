package selenium;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class DataTableTests extends BaseTest {
    private final By SORTABLE_DATA_TABLES = By.xpath(String.format(PRECISE_TEXT_XPATH, "Sortable Data Tables"));
    private final By DUE_ELEMENT_LOCATOR = By.xpath("//*[@id='table1']//td[4]");
    private final Double Expected_SUM = 251.0;
    private final String CURENCY_REGEX= "[^\\d.]";

    @Test
    public void dataTableTest() {
        driver.findElement(SORTABLE_DATA_TABLES).click();
        List<webElement> dueList = driver.findElements(DUE_ELEMENT_LOCATOR);
        Double actualSum=0.0;
        for(webElement element:dueList){
            string elementTest=element.getText();
            actualSum += Double.parseDouble(elementTest.replaceAll(CURENCY_REGEX,""));
        }
        Assert.assertEquals(actualSum, Expected_SUM, "Sum is not correct");
        // todo: assert due sum
    }
}
