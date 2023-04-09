package Lesson10_Actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C03_Keyboard extends TestBase {

    @Test
    public void test01 (){
        driver.get("https://www.amazon.com");
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));

        /*
         once arama kutusuna click
         sonra harf harf Nutella
         ardandan enter
         */

        Actions actions = new Actions(driver);

        actions.click(searchBox)
                .keyDown(Keys.SHIFT)
                .sendKeys("n")
                .keyUp(Keys.SHIFT)
                .sendKeys("u")
                .sendKeys("t")
                .sendKeys("e")
                .sendKeys("l")
                .sendKeys("l")
                .sendKeys("a")
                .sendKeys(Keys.ENTER)
                .perform();

    }
}
