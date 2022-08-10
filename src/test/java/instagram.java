import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class instagram {

    WebDriver driver;
    @Test
    public  void setup() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.instagram.com/?hl=tr");
        driver.findElement(By.xpath("//input[@aria-label=\"Telefon numarası, kullanıcı adı veya e-posta\"]")).sendKeys("ramazanaydogdu51");
        driver.findElement(By.xpath("//input[@aria-label=\"Şifre\"]")).sendKeys("51Ramazanarey."+ Keys.ENTER);
        Thread.sleep(1500);
        driver.findElement(By.xpath("//input[@aria-label=\"Arama Girdisi\"]")).sendKeys("Cansu"+Keys.ENTER);
        Thread.sleep(1500);
        driver.findElement(By.xpath("//*[text()=\"cans_caa\"]")).click();
        Thread.sleep(1500);
        driver.findElement(By.xpath("(//div[@class=\"_9AhH0\"])[3]")).click();
        Thread.sleep(1500);
        driver.findElement(By.xpath("(//div[@class='QBdPU rrUvL'])[1]")).click();
        Thread.sleep(1500);

       // driver.close();
    }


}
