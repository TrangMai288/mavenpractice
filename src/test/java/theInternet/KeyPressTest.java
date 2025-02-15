package theInternet;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class KeyPressTest {
    @Test
    void keyPress() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/key_presses");

        Actions actions = new Actions(driver);

        actions.keyDown("a").perform();
        Assert.assertEquals(driver.findElement(By.id("result")).getText(), "You entered: A");

        actions.keyDown(Keys.ESCAPE).perform();
        Assert.assertEquals(driver.findElement(By.id("result")).getText(), "You entered: ESCAPE");
    }
}
