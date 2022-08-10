package day05_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C03_JunitIlkTest_Tekrar {
    @Test
    public  void method1(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("http://www.amazon.com");
        driver.close();
    }
    @Test
    public  void method2(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("http://www.facebook.com/Cristiano");
        driver.close();
    }
    @Test
    public  void method3 (){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("http://twitter.com");
        driver.close();
    }
}
