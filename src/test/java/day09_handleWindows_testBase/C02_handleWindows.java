package day09_handleWindows_testBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_handleWindows {
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(13));

    }
    @After
    public void tearDown(){
        driver.quit();
    }
    @Test
    public void test01_handleWindows() throws InterruptedException {
        driver.get("http://www.amazon.com");
        String ilkSayfaKodu=driver.getWindowHandle();
        String actualUrl=driver.getCurrentUrl();
        String expectedUrl="amazon";
       Assert.assertTrue(actualUrl.contains(expectedUrl));
        driver.switchTo().newWindow(WindowType.WINDOW );
        driver.get("http://www.bestbuy.com");
        String ikinciSayfaDegeri=driver.getWindowHandle();
        Assert.assertTrue(driver.getTitle().contains("Best Buy"));
        //ilk sayfaya donmek
        driver.switchTo().window(ilkSayfaKodu);
        Thread.sleep(1500);
        driver.switchTo().window(ikinciSayfaDegeri);
        Thread.sleep(1500);



    }
}
