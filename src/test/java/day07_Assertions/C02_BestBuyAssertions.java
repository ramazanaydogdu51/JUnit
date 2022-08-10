package day07_Assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_BestBuyAssertions {

    //https://www.bestbuy.com/ A dresine gidin farkli test method’lari olusturarak asagidaki
    //testleri yapin
    //○Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin
    //○titleTest => Sayfa başlığının “ Rest” içer me diğini(contains) test edin
    //○logoTest => BestBuy logosunun görüntülen digini test edin
    //○Francais LinkTest => Fransizca Linkin görüntüle n diğini test edin
    static WebDriver driver;
    @BeforeClass
    public static  void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
        driver.get("https://www.bestbuy.com/");
    }
    @AfterClass
    public static void tearDown(){
      driver.close();
    }

    @Test
    public void method(){
        //https://www.bestbuy.com/ A dresine gidin farkli test method’lari olusturarak asagidaki

        //testleri yapin
        //○Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin
        String actualUrl=driver.getCurrentUrl();
        String expectedUrl="https://www.bestbuy.com/";
        Assert.assertEquals(expectedUrl,actualUrl);


    }

    @Test
    public void method2(){
        //○titleTest => Sayfa başlığının “ Rest” içer me diğini(contains) test edin
       String actualTitle=driver.getTitle();
        String expectedTitle = "Rest";
        Assert.assertFalse(expectedTitle==actualTitle);
    }
    @Test
    public void method3(){
        //○logoTest => BestBuy logosunun görüntülendigini test edin
WebElement logo=        driver.findElement(By.xpath("(//img[@class=\"logo\"])[1]"));
        Assert.assertTrue(logo.isDisplayed());

    }
    @Test
    public void method4(){
        //○Francais LinkTest => Fransizca Linkin görüntüle n diğini test edin
        WebElement frLink=driver.findElement(By.xpath("//button[@lang=\"fr\"]"));
        Assert.assertTrue(frLink.isDisplayed());
    }
}
