package Lesson12_Synchronization;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C01_ExplicityWait extends TestBase {

    @Test
    public void implicityWaitTesti() {

        //  siteye git
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //  Remove butonuna tikla
        driver.findElement(By.xpath("//*[text()='Remove']")).click();

        //  "it's gone" mesajinin gorunurlugunu kontrol et
        WebElement itsGoneYazisi = driver.findElement(By.xpath("//p[@id='message']"));
        Assert.assertTrue(itsGoneYazisi.isDisplayed());

        //  Add butonuna tiklayin
        driver.findElement(By.xpath("//*[text()='Add']")).click();

        //  it's back yazisinin gornurlugunu test edin
        WebElement itsBackYazisi = driver.findElement(By.xpath("//p[text()=\"It's back!\"]"));
        Assert.assertTrue(itsBackYazisi.isDisplayed());

    }

    @Test
    public void explicitlyWaitTesti() {

        //  siteye git
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //  Remove butonuna tikla
        driver.findElement(By.xpath("//*[text()='Remove']")).click();

        //  "it's gone" mesajinin gorunurlugunu kontrol et
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        /*
        WebElement itsDoneYazisi = driver.findElement(By.xpath("//p[@id='message']"));

        wait.until(ExpectedConditions.visibilityOf(itsDoneYazisi));

        Assert.assertTrue(itsDoneYazisi.isDisplayed());


        yazinin gorunur olmasini beklerken yazinin locatini kullanmak sorun olusturur
        cunku henuz gorunmeyen bir yazinin locate edilmesi de mumkun olmayabilir

         */

        WebElement itsGoneYaziElementi = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
        Assert.assertTrue(itsGoneYaziElementi.isDisplayed());

        //  Add butonuna tiklayin
        driver.findElement(By.xpath("//*[text()='Add']")).click();

        //  it's back yazisinin gornurlugunu test edin
        WebElement itsBackYazisi = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()=\"It's back!\"]")));
        Assert.assertTrue(itsBackYazisi.isDisplayed());

    }
}
