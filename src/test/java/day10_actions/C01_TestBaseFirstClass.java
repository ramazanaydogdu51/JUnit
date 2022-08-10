package day10_actions;

import org.junit.Test;
import utilities.TestBase;

public class C01_TestBaseFirstClass extends TestBase {//child yaptık TestBase'e
    // TestBase'i de protected yaptik ki driver d

    @Test
    public void test(){
        driver.get("http://www.amazon.com");
    }
}
