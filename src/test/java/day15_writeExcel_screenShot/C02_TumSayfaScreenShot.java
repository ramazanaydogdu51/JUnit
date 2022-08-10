package day15_writeExcel_screenShot;

import com.github.javafaker.DateAndTime;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.TestBase;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
public class C02_TumSayfaScreenShot extends TestBase {
    @Test
    public void tumSayfa() throws IOException {
        // amazon sayfasina gidip tum sayfanin fotografini cekelim
        driver.get("https://www.amazon.com");
        //1
        TakesScreenshot ts = (TakesScreenshot) driver;

        LocalDateTime date=LocalDateTime.now();
        DateTimeFormatter dtf= DateTimeFormatter.ofPattern("YYMMddHHmmss");
        String tarih = date.format(dtf);

        //2
        File tumSayfaResim= new File("target/ekranGoruntuleri/tumSayfa"+tarih+".jpeg"); // proje'nin target klasorunde
        //3
        File geciciDosya= ts.getScreenshotAs(OutputType.FILE);
        //4
        FileUtils.copyFile(geciciDosya,tumSayfaResim);
    }
}
