package day07_Assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C05_DropDownOptions {
    //amazon anasayfaya gidip dropdown menuden books'u secelim
    //sectigimiz option'u yazdiralim

    // dropdown'daki opsiyonlarin toplam sayisinin 28 oldgunu test edin
    WebDriver driver;
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(13));
        driver.get("https://www.amazon.com/");

    }
    @After
    public void tearDown() {
        driver.close();
    }
    @Test
    public void method1() {
        WebElement ddm=driver.findElement(By.xpath("//select[@name=\"url\"]"));
        Select select=new Select(ddm);
        select.selectByVisibleText("Books");
        //Bir dropdown ile calisiyorken son seclien option'a ulasmak isterseniz
        //select.getFirstSelectedOption() methodunu kullanmaliyiz
        //bu method bize WebElement dondurur ve getText(); ile String getirelim
        select.getFirstSelectedOption().getText();//

        //toplam opsiyon sayisini bulmak icin liste atalim
        List<WebElement> optionList=select.getOptions();

        int actualOptionSayisi=optionList.size();
        int expectedOptionSayisi=28;
        Assert.assertEquals(expectedOptionSayisi,actualOptionSayisi);

    }
}
