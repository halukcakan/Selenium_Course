package Lesson10_Actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C04_Keyboard_Actions extends TestBase {

    @Test
    public void test01 () throws InterruptedException {

        driver.get("https://facebook.com");


        /*
        <a role="button" class="_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy" href="#"
        ajaxify="/reg/spotlight/" id="u_0_0_1o" data-testid="open-registration-form-button"
        rel="async">Create new account</a>
         */

        driver.findElement(By.xpath("//a[text()='Create new account']")).click();

        /*
        <input type="text" class="inputtext _58mg _5dba _2ph-" data-type="text" name="firstname"
        value="" aria-required="true" placeholder="First name" aria-label="First name" id="u_2_b_28" tabindex="0">
         */

        WebElement isimKutusu = driver.findElement(By.xpath("//*[@placeholder='First name']"));

        Actions actions = new Actions(driver);
        actions.click(isimKutusu)
                        .sendKeys("Taha")
                        .sendKeys(Keys.TAB)
                        .sendKeys("Usta")
                        .sendKeys(Keys.TAB)
                        .sendKeys("arfda@hotmail.com")
                        .perform();

    }

}
