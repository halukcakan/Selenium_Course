package Lesson08_Alerts_Iframe;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_SwitchToIframe {
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

    public void waitMethod (int number) throws InterruptedException {
        Thread.sleep(number);
    }

    @Test
    public void test01() throws InterruptedException {
        // https://the-internet.herokuapp.com/iframe  adresine gidin
        driver.get("https://the-internet.herokuapp.com/iframe");
        // "Your content goes here." yazisinin gorunur oldugunu test edin
        /*
            Bazen locate islemimizden emin olmamiza ragmen
            Locator calismaz
            Bunun sebebi kullanmak istedigimiz webelement'in
            bir iframe'in child'i olmasi olabilir.
            Eger Kullanmak istedigimiz webelement
            anasayfa icine gomulen baska bir websayfasinin elementi ise
            once gomulu sayfaya gecmemiz gerekir
            HTML komutlarinda sayfa icerisine sayfa gomebilmek icin
            <iframe> kullanilir
            Biz de istedigimiz elementi kullanmak icin once
            o frame'e switch yapmaliyiz
            1- gecis yapmak istediginiz frame'i locate edin
            2- switchTo() ile o frame'e gecis yapin
            3- Sonra istediginiz element ile istediginiz islemi yapin
         */
        WebElement frameElementi= driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(frameElementi);


        WebElement yaziElementi = driver.findElement(By.tagName("p"));
        Assert.assertTrue(yaziElementi.isDisplayed());

        // Elemental Selenium linkine click yapin
        /*
            Bir frame'e gecis yaptiktan sonra
            oradan cikincaya veya baska bir frame'e gecinceye kadar
            driver o frame icerisinde kalir
            isimiz bittiginde veya baska frame'e gecmek istedigimizde
            once calisacagimiz yere gecis yapmaliyiz
         */

        driver.switchTo().parentFrame(); // icice frame'lerde bir ust seviyeye cikar
        //driver.switchTo().defaultContent();// direk anasayfaya cikar
        driver.findElement(By.linkText("Elemental Selenium")).click();


        waitMethod(3);

    }
}
