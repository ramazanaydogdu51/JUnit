package day06_radioButton_checkBox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static day06_radioButton_checkBox.C01_BeforeClass_AfterClass.driver;

public class C01_BeforeClass_AfterClass_Tekrar {

    //beforeClass ve afterclass notasyonları sadece staticclass'larda calisir.BeforeClass ve AfterClass static olmalidir
    static WebDriver driver;
    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));

    }
    @AfterClass
    public static void tearDown(){
        driver.close();
    }

    @Test
    public void method(){
        driver.get("http://www.amazon.com");
    }
    @Test
    public void  method1(){
        driver.get("http://twitter.com");
    }
    @Test
    public void method2(){
        driver.get("http://www.facebook.com");
    }

}
