package day07_Assertions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class C04_DropDownMeu_Tekrar extends TestBase {

    @Test
    public void test01() {
    driver.get("http://www.amazon.com");
        //dropdown icin 3 asama vardir
        //1-- dropdown'i locate etmek
        //2-- Select objesi olusturup locate ettigimiz dropDownMenu'yu atamak
        WebElement dropDownMenu=driver.findElement(By.xpath("//select[@class='nav-search-dropdown searchSelect nav-progressive-attrubute nav-progressive-search-dropdown']"));
        Select select=new Select(dropDownMenu);
        //3--DropDown'da var olan option'lardan istegiimiz bir taneyi
        //select.selectByValue();
        //select.selectByIndex();
        select.selectByVisibleText("Deals");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java"+ Keys.ENTER) ;
    }
}
