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

public class C03_Assertions {
static     WebDriver driver;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
        driver.manage().window().maximize();
        //https://www.youtube.com adresine gidin
        driver.get("https://www.youtube.com");
    }
    @AfterClass
    public static void tearDown(){
        driver.close();
    }

    @Test
    public void titleTest(){
        //titleTest => Sayfa başlığının YouTube ” oldugunu test edin
String        actualTitle=driver.getTitle();
        String expectedTitle="YouTube";
        Assert.assertTrue(expectedTitle.equals(actualTitle));
    }
    @Test
    public void imageTest(){
        //imageTest => YouTube resminin görüntülendiğini isDisplayed()) test edin
        WebElement ytLogoElementi=driver.findElement(By.xpath("(//yt-icon[@class=\"style-scope ytd-logo\"])[1]"));
        Assert.assertTrue(ytLogoElementi.isDisplayed());
    }
    @Test
    public void searchBox(){
        //Search Box 'in erisilebilir oldugunu test edin (isEnabled())
        WebElement searchBoxElement=driver.findElement(By.xpath("//input[@id=\"search\"]"));
        Assert.assertTrue(searchBoxElement.isEnabled());

    }
    @Test
    public void wrongTitleTest(){
        String pageTitle=driver.getTitle();
        Assert.assertFalse(pageTitle=="youtube");
    }


    //wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin

}
