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

public class C01_Assertions {
    //amazon ana sayfaya gidin
    // 3 farkli test methodu olusturarak asagidaki gorvleri yapin
    //1) url'in amazon icerdigini test edin
    //2) Title'in facebook icermedigini test edin
    //3)Sol ust kosed amazon logosunun gorundugunu test edin.
static     WebDriver driver;
    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
        driver.get("http://www.amazon.com");
    }
    @AfterClass
    public static void tearDown() {
        driver.close();
    }

    @Test
    public void amazonTest() {
        //amazon ana sayfaya gidin

        // 3 farkli test methodu olusturarak asagidaki gorvleri yapin
        //1) url'in amazon icerdigini test edin
        String expectedUrl = "amazon";
        String actualdUrl=driver.getCurrentUrl();
        Assert.assertTrue(actualdUrl.contains(expectedUrl));

        //3)Sol ust kosed amazon logosunun gorundugunu test edin.
    }
    @Test
    public void method2(){
        //2) Title'in facebook icermedigini test edin.
        String actualTitle=driver.getTitle();
        String istenmeyenKelime="facebook";
        Assert.assertFalse(actualTitle.contains(istenmeyenKelime));
    }

    @Test
    public  void method3(){
        //3)Sol ust kosed amazon logosunun gorundugunu test edin.
        WebElement logoElementi=driver.findElement(By.id("nav-logo-sprites"));
        Assert.assertTrue(logoElementi.isDisplayed());
    }

}
