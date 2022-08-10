package day05_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_JunitIlkTest {

    @Test
    public   void method(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofDays(15));
        driver.manage().window().maximize();

        driver.get("http://www.amazon.com");
        driver.close();

    }
    @Test
    public  void method1(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofDays(15));
        driver.manage().window().maximize();

        driver.get("http://www.facebook.com");
        driver.close();
    }
    @Test
    public  void method2(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofDays(15));
        driver.manage().window().maximize();

        driver.get("http://www.twitter.com");
        driver.close();
    }
}
