package Lesson08_Alerts_Iframe;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_JSAlerts {
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

    public void waitMethod (int duration) throws InterruptedException {
        Thread.sleep(duration);
    }

    @Test
    public void test01() throws InterruptedException {
        // Gerekli ayarlamalari yapip
        // https://the-internet.herokuapp.com/javascript_alerts  adresine gidin
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        // 1.alert'e tiklayalim
        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();
        waitMethod(2);

        // Alert'deki yazinin "I am a JS Alert" oldugunu test edelim
        String expectedAlertYazisi="I am a JS Alert";
        String actualAlertYazisi= driver.switchTo().alert().getText();

        Assert.assertEquals(expectedAlertYazisi,actualAlertYazisi);

        // OK tusuna basip alert'i kapatalim
        driver.switchTo().alert().accept();
        waitMethod(2);
    }

    @Test
    public void test02() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        // 2.alert'e tiklayalim
        driver.findElement(By.xpath("//*[text()='Click for JS Confirm']")).click();

        // cancel'a basip, cikan sonuc yazisinin "You clicked: Cancel" oldugunu test edin
        waitMethod(2);
        driver.switchTo().alert().dismiss();
        waitMethod(2);
        String expectedSonucYazisi="You clicked: Cancel";
        String actualSonucYazisi= driver
                .findElement(By.xpath("//*[@id='result']"))
                .getText();

        Assert.assertEquals(expectedSonucYazisi,actualSonucYazisi);

    }


    @Test
    public void test03() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        // 3.alert'e tiklayalim
        driver.findElement(By.xpath("//*[text()='Click for JS Prompt']")).click();

        // Cikan prompt ekranina "Abdullah" yazdiralim ve OK tusuna basarak alert'i kapatalim
        driver
                .switchTo()
                .alert()
                .sendKeys("Abdullah");
        waitMethod(2);
        driver
                .switchTo()
                .alert()
                .accept();

        // Cikan sonuc yazisinin Abdullah icerdigini test edelim
        waitMethod(2);
        String actualSonucYazisi= driver
                .findElement(By.xpath("//*[@id='result']"))
                .getText();
        String expectedIcerik="Abdullah";

        Assert.assertTrue(actualSonucYazisi.contains(expectedIcerik));

    }
}
