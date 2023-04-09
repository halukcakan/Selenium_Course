package Lesson15_ScreenShot;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class C01_ScreenShot extends TestBase {

    @Test
    public void test01() throws IOException {

        driver.get("https://www.amazon.com");

        TakesScreenshot ts = (TakesScreenshot) driver;
        // cast et !

        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("YYMMddHHmmss");
        String zaman =date.format(dtf);

        File tumSayfaResim = new File("target/ekranGoruntuleri/tumSayfa"+zaman+".jpeg");

        File gececiDosya = ts.getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(gececiDosya,tumSayfaResim);

    }
}
