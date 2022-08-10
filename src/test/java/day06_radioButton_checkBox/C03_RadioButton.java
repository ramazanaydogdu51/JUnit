package day06_radioButton_checkBox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_RadioButton {
    //1. Bir class oluşturun : RadioButtonTest
    //2. Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.

        //https://www.facebook.com adresine gidin

        //Cookies’i kabul edin
        //driver.findElement(By.xpath("//*[text()='Allow essential and optional cookies']")).click();
        //“Create an Account” button’una basin

        //“radio buttons” elementlerini locate edin

        //Secili degilse cinsiyet butonundan size uygun olani secin
    static WebDriver driver;
    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @AfterClass
    public static void tearDown() {
       driver.close();
    }

    @Test
    public void facebook() throws InterruptedException {

        //https://www.facebook.com adresine gidin
        driver.get("https://www.facebook.com");

        //Cookies’i kabul edin
        //driver.findElement(By.xpath("//*[text()='Allow essential and optional cookies']")).click();
        //“Create an Account” button’una basin
        driver.findElement(By.xpath("(//a[@role=\"button\"])[2]")).click();
        Thread.sleep(1500);
        //“radio buttons” elementlerini locate edin
        WebElement kadin=driver.findElement(By.xpath("(//input[@type=\"radio\"])[1]"));
        WebElement erkek=driver.findElement(By.xpath("(//input[@type=\"radio\"])[2]"));
        WebElement istek=driver.findElement(By.xpath("(//input[@type=\"radio\"])[3]"));

        //Secili degilse cinsiyet butonundan size uygun olani secin
        if (!erkek.isSelected()){
            erkek.click();
        }
        Thread.sleep(1500);
    }
}
