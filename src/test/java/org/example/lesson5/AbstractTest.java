package org.example.lesson5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.compress.compressors.lz4.XXHash32;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public abstract class AbstractTest {
    // static WebDriver driver;
    private static WebDriver driver;

    @BeforeAll
    static void init()
    {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @BeforeEach
    void goTo()
    {
        Assertions.assertDoesNotThrow(()->driver.navigate().to("https:/www.vstu.ru"),"Страница не доступна");
    }

    @AfterAll
    static void close()
    {
        //driver.quit();
    }

    public static WebDriver getDriver()
    {
        return driver;
    }

}
