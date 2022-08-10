package day05_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_MavenIlkClass_Tekrar {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofDays(15));


        //1. http://zero.webappsecurity.com sayfasina gidin
        driver.get("http://zero.webappsecurity.com");
        //2. Signin buttonuna tiklayin
        driver.findElement(By.xpath("//button[@id=\"signin_button\"]")).click();

        //3. Login alanine  “username” yazdirin
        driver.findElement(By.xpath("//input[@name=\"user_login\"]")).sendKeys("username");

        //4. Password alanine “password” yazdirin
        driver.findElement(By.xpath("//input[@name=\"user_password\"]")).sendKeys("password");
        //5. Sign in buttonuna tiklayin (hata mesaji icin back tusuna tiklayin)
        driver.findElement(By.xpath("//input[@name=\"submit\"]")).click();
        driver.navigate().back();
        //6. Online Banking menusunden Pay Bills sayfasina gidin
        Thread.sleep(2000);

        driver.findElement(By.xpath("(//*[text()=\"Online Banking\"])[1]")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//span[@id=\"pay_bills_link\"]")).click();
        Thread.sleep(2000);

        //7. amount kismina yatirmak istediginiz herhangi bir miktari yazin
        driver.findElement(By.xpath("//input[@name=\"amount\"]")).sendKeys("1500");
        Thread.sleep(2000);

        //8. tarih kismina “2020-09-10” yazdirin
        driver.findElement(By.xpath("//input[@name=\"date\"]")).sendKeys("2020-09-10");
        Thread.sleep(2000);

        //9. Pay buttonuna tiklayin
        driver.findElement(By.xpath("//input[@type=\"submit\"]")).click();
        Thread.sleep(2000);
        driver.close();
        //10. “The payment was successfully submitted.” mesajinin ciktigini kontrol edin
    }
}
