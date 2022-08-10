package day06_radioButton_checkBox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_CheckBox_Tekrar {
    //a. Verilen web sayfasına gidin.
    //https://the-internet.herokuapp.com/checkboxes
    //b. Checkbox1 ve checkbox2 elementlerini locate edin.
    //c. Checkbox1 seçili değilse onay kutusunu tıklayın
    //d. Checkbox2 seçili değilse onay kutusunu tıklayın
    static WebDriver driver;
    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }
    @AfterClass
    public static void tearDown() {
        driver.close();
    }
    @Test
    public void CheckBoxControl() throws InterruptedException {
        //https://the-internet.herokuapp.com/checkboxes
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        //b. Checkbox1 ve checkbox2 elementlerini locate edin.
        WebElement checkbox1 = driver.findElement(By.xpath("(//input[@type=\"checkbox\"])[1]"));
        WebElement checkbox2 = driver.findElement(By.xpath("(//input[@type=\"checkbox\"])[2]"));
        Thread.sleep(2000);
        //c. Checkbox1 seçili değilse onay kutusunu tıklayın
        if (!checkbox1.isSelected()){
            checkbox1.click();
        }
        Thread.sleep(2000);
        //d. Checkbox2 seçili değilse onay kutusunu tıklayın
        if (!checkbox2.isSelected()){
            checkbox2.click();
        }
        Thread.sleep(2000);

    }




}
