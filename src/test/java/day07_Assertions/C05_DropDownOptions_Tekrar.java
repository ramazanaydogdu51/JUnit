package day07_Assertions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class C05_DropDownOptions_Tekrar extends TestBase {
    //amazon anasayfaya gidip dropdown menuden books'u secelim
    //sectigimiz option'u yazdiralim

    // dropdown'daki opsiyonlarin toplam sayisinin 28 oldgunu test edin


    @Test
    public void test01_DropDown() throws InterruptedException {
        driver.get("http://www.amazon.com");
        //once dropdownı locate edelim atayalım
        WebElement ddm= driver.findElement(By.xpath("//select[@class=\"nav-search-dropdown searchSelect nav-progressive-attrubute nav-progressive-search-dropdown\"]"));
        //Select class'ından select objesi olusturalım
        Select select=new Select(ddm);// ddm'i ona ekleyelim
        select.selectByVisibleText("Books");
        Thread.sleep(2000);

    }
}
