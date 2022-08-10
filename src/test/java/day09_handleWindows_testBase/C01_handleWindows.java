package day09_handleWindows_testBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_handleWindows {
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
        driver.get("https://www.amazon.com/");

        String ilkSayfaWindowDegeri=driver.getWindowHandle();
        /*
        CDwindow-F139337EC5F92F24458217669685203D
        bu kod acilan sayfanin unique has kodudur
        Selenium sayfalar arasi geciste bu window handle degerini kullanir


         */
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("nutella"+ Keys.ENTER);
        WebElement ilkUrunResmi=driver.findElement(By.xpath("(//div[@class=\"a-section aok-relative s-image-square-aspect\"])[1]"));
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.amazon.com/");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("nutella"+ Keys.ENTER);
        driver.findElement(By.xpath("(//div[@class=\"a-section aok-relative s-image-square-aspect\"])[1]")).click();
        System.out.println(driver.findElement(By.xpath("//span[@id=\"productTitle\"]")).getText());

        driver.switchTo().window(ilkSayfaWindowDegeri);
        Thread.sleep(1000);
    }
}
