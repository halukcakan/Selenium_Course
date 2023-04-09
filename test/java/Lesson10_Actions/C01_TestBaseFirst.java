package Lesson10_Actions;

import org.junit.Test;
import utilities.TestBase;

public class C01_TestBaseFirst extends TestBase {

    @Test
    public void test01(){
        driver.get("https://www.amazon.com");
    }
}
