package day05_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_BeforeAfter_Tekrar {
       WebDriver driver;
       @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofDays(15));
       }
    @After
    public void tearDown(){
        driver.close();
    }
    @Test
    public void method1(){
           driver.get("http://www.amazon.com");

    }
    @Ignore
    public void method2(){
           driver.get("http://www.facebook.com");
    }
    @Test
    public void method3(){
          driver.get("http://www.twitter.com");
    }

}
