package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public abstract class TestBase {

    /*
    bu class'tan obje uretip ondan sonra kullanalimin onune gecmektir
     */

    protected WebDriver driver;

    /*

      protected veya public olmali
      protected daha dar kapsamli ve guvenlik aciklarini engeller
        sadece child class'lardan kullanacagim icin protected yaptik

     */

    @Before
    public void setUp (){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown (){
        driver.quit();
    }
}
