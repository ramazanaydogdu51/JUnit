package day06_radioButton_checkBox;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C03_RadioButton_Tekrar extends TestBase {
    //1. Bir class oluşturun : RadioButtonTest
    //2. Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.

    //https://www.facebook.com adresine gidin

    //Cookies’i kabul edin
    //driver.findElement(By.xpath("//*[text()='Allow essential and optional cookies']")).click();
    //“Create an Account” button’una basin

    //“radio buttons” elementlerini locate edin

    //Secili degilse cinsiyet butonundan size uygun olani secin

    @Test
    public void test01() throws InterruptedException {
        driver.get("https://www.facebook.com");
        driver.findElement(By.xpath("(//a[@role=\"button\"])[2]")).click();
        WebElement erkekElementi=driver.findElement(By.xpath("(//input[@type=\"radio\"])[2]"));
        if (!erkekElementi.isSelected()){
            erkekElementi.click();
        }
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//*[text()='Kaydol'])[3]")).click();
        Assert.assertTrue(erkekElementi.isSelected());


    }
}
