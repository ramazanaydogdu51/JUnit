package day07_Assertions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_Assertions_Tekrar extends TestBase {
    //amazon ana sayfaya gidin
    // 3 farkli test methodu olusturarak asagidaki gorvleri yapin
    //1) url'in amazon icerdigini test edin
    //2) Title'in facebook icermedigini test edin
    //3) Sol ust kosed amazon logosunun gorundugunu test edin.
    @Test
    public void testUrl() {
        driver.get("https://www.amazon.com/");
        String actualUrl =driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains("amazon"));
    }

    @Test
    public void testTitle() {
        driver.get("https://www.amazon.com/");
        Assert.assertFalse(driver.getTitle().contains("facebook"));
    }

    @Test
    public void testLogo() {
        driver.get("https://www.amazon.com/");
        Assert.assertTrue(driver.findElement(By.id("nav-logo-sprites")).isDisplayed());
    }
}
