package rave.code.selenium;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

/**
 * Unit test for simple App.
 */
public class DryRunTest {

    /**
     * Rigorous Test :-)
     */
    @Test
    public void seleniumDryRun() {

        /*
        * Note when you use chrome for automation make sure the browser and its driver are of same version...
        * In my case
        *
        * Chrome Version: 132.0.6834.110
        * Driver Version : 132.0.6834.110
        *
        * */

        String chromeDriverLocation = this.getClass().getResource("/chromedriver-132.0.6834.110").getFile();

        System.setProperty("webdriver.chrome.driver", chromeDriverLocation);
        //System.setProperty("webdriver.gecko.driver", geckoDriverLocation);

        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--headless");
        options.addArguments("--disable-gpu");
        options.addArguments("--start-maximized");
        options.setExperimentalOption("excludeSwitches", new String[]{"disable-popup-blocking" ,"enable-automation"});

        WebDriver driver = new ChromeDriver(options);

        driver.get("https://www.selenium.dev/selenium/web/web-form.html");
        driver.getTitle();

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

        WebElement textBox = driver.findElement(By.name("my-text"));
        WebElement submitButton = driver.findElement(By.cssSelector("button"));

        textBox.sendKeys("Selenium");
        submitButton.click();

        WebElement message = driver.findElement(By.id("message"));
        message.getText();

        driver.quit();

        assertTrue(true);
    }
}
