package Lesson08_Alerts_Iframe;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_BasicAuthentication {
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
        //2- https://the-internet.herokuapp.com/basic_auth sayfasina gidin
        //3- asagidaki yontem ve test datalarini kullanarak authentication’i yapin
        //
        //  Html komutu : https://username:password@URL
        //	Username     : admin
        // 	password      : admin
        //
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");

        //4- Basarili sekilde sayfaya girildigini dogrulayin
        String actualGirisYazisi= driver.findElement(By.tagName("p")).getText();
        String expectedIcerik = "Congratulations";

        Assert.assertTrue(actualGirisYazisi.contains(expectedIcerik));

    }
}
