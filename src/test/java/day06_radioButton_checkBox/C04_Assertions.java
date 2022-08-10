package day06_radioButton_checkBox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_Assertions         {
    WebDriver driver;
    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        driver.close();
    }

    @Test
    public void method1() {
        //Eger Test method'umuzda hicbir test yoksa, tes calistiktan sonra
        //Hicbir sorun yoksa "test passed" der.
        //Aslında biz bu zamana kadar locate yaptik.


        // Eğer testleri if ile yaparsak test failed olsa bile testler sorunsuz çalışsa bize bize
        //intelliji bize sol altta passed der ancak bize ekranda failed yazdırır
        driver.get("https://www.facebook.com");

        //url'in https://www.facebook.com oldgunu test edin
       // if (driver.getCurrentUrl().equals("https://www.facebook.com ")){
       //     System.out.println("passed");
       // }else System.out.println("failed");
        Assert.assertEquals("https://www.facebook.com",driver.getCurrentUrl());


        /*
        Assert  ile yaptigimiz testlerde assertion failed olursa Java kodlarinin calismasini durdurur ve Assert class'i
        bizi hata konusunda bilgilendirir
                org.junit.ComparisonFailure:
                Expected :https://www.amazon.com
                Actual   :https://www.amazon.com/
                <Click to see difference>
                Boylece hatanin ne oldgunu arasitrmamiza gerek kalmadan JUni bize raporlamis olacak

         */


    }
}
