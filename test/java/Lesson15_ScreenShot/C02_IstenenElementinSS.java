package Lesson15_ScreenShot;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C02_IstenenElementinSS extends TestBase {

    @Test
    public void test01() throws IOException {

        driver.get("https://www.amazon.com");
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Nutella" + Keys.ENTER);

        WebElement sonucYaziElementi = driver.findElement(By.xpath("(//div[@class='sg-col-inner'])[1]"));

        File sonucYaziElementSS = new File ("target/ekranGoruntuleri/sonucYazisiSS.png");

        File temp = sonucYaziElementi.getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(temp,sonucYaziElementSS);
    }
}
