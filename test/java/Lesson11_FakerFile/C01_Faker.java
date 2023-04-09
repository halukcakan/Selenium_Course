package Lesson11_FakerFile;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C01_Faker extends TestBase {

    @Test
    public void test01() {

        Faker faker = new Faker();
        Actions actions = new Actions(driver);
        actions.sendKeys(faker.name().firstName())
                .sendKeys(faker.name().lastName())
                .sendKeys(faker.internet().emailAddress())
                .perform();

    }
}
