package selenium;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;


public class FileDownloadTest extends BaseTest {
    private final By FILE_DOWNLOAD = By.xpath(String.format(PRECISE_TEXT_XPATH, "File Download"));
    private final String FILE_NAME = "Test.txt";
    private final By FILE_NAME_XPATH = By.xpath(String.format(PRECISE_TEXT_XPATH, FILE_NAME));
    private final String FILE_PATH = RELATIVE_RESOURCE_PATH + FILE_NAME;
    private final File downloadedFile = new File(FILE_PATH);



    @Test
    public void fileUploadTest() {
        driver.findElement(FILE_DOWNLOAD).click();
        Assert.assertTrue(driver.findElement(FILE_NAME_XPATH).isDisplayed(), "File is not displayed");
        driver.findElement(FILE_NAME_XPATH).click();
        Asser.assertTrue(isFileExist(downloadedFile), "File is not downloaded");

        // todo: assert file is downloaded
    }
    private boolean isFileExist(File file){
        try {
            Awaitility.await().atMost(MAX_WAIT, TimeUnit.SECONDS).until(file::exists);
        } catch (conditionTimeoutException exception) {
            return false;
            // TODO: handle exception
        }
        return true;
    }


    // todo: delete file
    @Aftermethod
    public void deleteFile(){
        if(downloadedFile.exists()){
            downloadedFile.delete();
        }
    } 
}
