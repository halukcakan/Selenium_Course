package Lesson06_CheckBox_RadioButton;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Radiobutton {
    WebDriver driver;

    @Before
    public void setUp (){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown (){
        driver.close();
    }

    @Test
    public void test01(){
        driver.get("https://www.facebook.com");
        driver.findElement(By.xpath("//*[text()='Create new account']")).click();
        driver.findElement(By.xpath("//input[@value=1]")).click();
        driver.findElement(By.xpath("//button[text()='Sign Up']")).click();

    }
}
