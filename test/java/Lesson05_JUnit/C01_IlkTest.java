package Lesson05_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;


public class C01_IlkTest {

        @Test
        public void method1 () {


//        System.setProperty("webriver.chrome.driver","src/resources/drivers/chromedriver.exe");
//        WebDriver driver = new ChromeDriver();
//        driver.manage().window().maximize();

            WebDriverManager.chromedriver().setup();
            WebDriver driver1 = new ChromeDriver();
            driver1.manage().window().maximize();
            driver1.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
            driver1.get("https://www.amazon.com");
            driver1.close();

//        WebDriverManager.edgedriver().setup();
//        WebDriver driver2 = new EdgeDriver();
//        driver2.manage().window().maximize();





    }

        @Test
        public void method2 () {


//        System.setProperty("webriver.chrome.driver","src/resources/drivers/chromedriver.exe");
//        WebDriver driver = new ChromeDriver();
//        driver.manage().window().maximize();

        WebDriverManager.chromedriver().setup();
        WebDriver driver1 = new ChromeDriver();
        driver1.manage().window().maximize();
        driver1.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver1.get("https://www.facebook.com");
        driver1.close();

//        WebDriverManager.edgedriver().setup();
//        WebDriver driver2 = new EdgeDriver();
//        driver2.manage().window().maximize();




    }


}
