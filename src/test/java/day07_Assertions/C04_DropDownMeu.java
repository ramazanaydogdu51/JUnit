package day07_Assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C04_DropDownMeu {
    //amazon'a gidip dropdown books seceneginisecip Java aratalim
   static WebDriver driver;
    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }
    @AfterClass
    public static  void tearDown() {
     driver.close();
    }
    @Test
    public void test02() throws InterruptedException {
        driver.get("http://www.amazon.com");
        //dropdown'dan bir option secmek icin 3 adim vardir.,
        //1- dropdown'i locate edelim
        WebElement ddm=driver.findElement(By.xpath("//select[@id=\"searchDropdownBox\"]"));
        //2) bir select objesi olusturup
        // parametre olacak bir onceki adimda locate ettigimiz ddm'yu girelim
        Select select=new Select(ddm);
        //3- Dropdown'da var olan option'lardan  istedigimiz bir taneyi
                // select.selectByIndex();
                 //select.selectByValue();
        select.selectByVisibleText("Books");
        //Arama kutusuna Java yazdirlaim
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java" + Keys.ENTER);
        Thread.sleep(1500);
        WebElement sonucYazisiElementi=driver.findElement(By.xpath("(//div[@class=\"a-section a-spacing-small a-spacing-top-small\"])[1]")); //actual
        String actual=sonucYazisiElementi.getText();
        String arananKelim="Java";
        Assert.assertTrue(actual.contains(arananKelim));
    }
}
