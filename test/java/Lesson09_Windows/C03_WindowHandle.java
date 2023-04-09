package Lesson09_Windows;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.HashSet;
import java.util.Set;

public class C03_WindowHandle {

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
        driver.quit();
    }

    public void waitMethod (int duration) throws InterruptedException {
        Thread.sleep(duration);
    }

    @Test
    public void test01() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/windows");

        // sayfadaki textin  "..."  oldugunu test edin
        WebElement sayfadakiYaziElementi = driver.findElement(By.xpath("//h3"));
        String expectedYazi = "Opening a new window";
        String actualYazi =sayfadakiYaziElementi.getText();
        Assert.assertEquals(expectedYazi,actualYazi);

        // safyanin title'nin "...." oldugunu test edin
        String expectedTitle = "The Internet";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);

        String ilkSayfaninWindonHandleDegeri = driver.getWindowHandle();

        // tikla
        driver.findElement(By.xpath("//*[text()=\"Click Here\"]")).click();

        /*
        switchTo().newWindow() demeden click yaptiktan sonra yeni sekme actiginda
         ve biz switch etmedigimiz icin
         driver eski sayfada kalir
         yeni sayfada calismak icin once driver'i yeni sayfaya gondermeliyiz

         */

        /*
        kontrolsuz acilan tab veya window varsa
        bunlarin window handle degerlerini elde etmemiz gerekir
            1)  ilk sayfanin window handle degerini strig'e ata
            2)  window handles set'ini olustur
            3)  for-each ile birinciye esit olmayan hash code'u
                ikinci sayfanin hash code'u olarak ata
         */

        Set<String> windowHandleSeti = driver.getWindowHandles();

        String ikinciSayfaninWindowHandleDegeri = "";
        for (String each : windowHandleSeti
             ) {
            if (!each.equals(ilkSayfaninWindonHandleDegeri)){
                ikinciSayfaninWindowHandleDegeri = each;
            }
        }

        driver.switchTo().window(ikinciSayfaninWindowHandleDegeri);

        // title'in "...." oldugunu test edin
        String expextedSecondTitle = "New Window";
        String actualSecondTitle = driver.getTitle();
        Assert.assertEquals(expextedSecondTitle,actualSecondTitle);



    }
}
