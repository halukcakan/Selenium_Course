package Lesson15_ScreenShot;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C03_JavascriptExecutor extends TestBase {

    @Test
    public void test01() throws InterruptedException {

        // amazona git
        driver.get("https://www.amazon.com");

        //  asagidaki sign in butonunu gorunceye kadar js ile scrool yapalim
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        //  CAST YAP !!
        WebElement singInButonu = driver.findElement(By.xpath("(//span[text()='Sign in'])[2]"));

        jse.executeScript("arguments[0].scrollIntoView(true);",singInButonu);
        Thread.sleep(3000);

        //  sing in butonu js ile click yapalim
        jse.executeScript("arguments[0].click();",singInButonu);
        Thread.sleep(3000);


    }
}
