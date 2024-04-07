package selenium;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.io.File;


public class FileUploadTest extends BaseTest {
    private final By FILE_UPLOAD = By.xpath(String.format(PRECISE_TEXT_XPATH, "File Upload"));
    private final By CHOOSE_FILE = By.id("file-upload");
    private final By FILE_SUBMIT = By.id("file-submit");
    private final By UPLOADED_FILE = By.id("uploaded-files");
        
    private final String FILE_NAME = "file.json";
    private final String FILE_PATH = RELATIVE_RESOURCE_PATH + FILE_NAME;


    @Test
    public void fileUploadTest() {
        driver.findElement(FILE_UPLOAD).click();
        File fileToUpload = new File(FILE_PATH);
        driver.findElement(CHOOSE_FILE).sendkeys(fileToUpload.getAbsolutePath());
        driver.findElement(FILE_SUBMIT).click();
        Assert.assertEquals(driver.findElement(UPLOADED_FILE).getText(), FILE_NAME, "File name is incorrect or missing");
        
        // todo: upload the file
        // todo: assert file is uploaded
    }
}
