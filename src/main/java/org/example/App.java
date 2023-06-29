package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://google.com");
        //driver.get("https://repetit.ru/");

        WebElement webElement1 = driver.findElement(By.name("q"));
        WebElement webElement2 = driver.findElement(By.cssSelector("textarea#APjFqb"));
        WebElement webElement3 = driver.findElement(By.xpath(".//textarea[@name='q']"));

       /* try {
            WebElement webElementError = driver.findElement(By.name("error"));
        }
        catch (NoSuchElementException e)
        {
            System.out.println("Не найдено");
        }

        List<WebElement> webElements = driver.findElements(By.name("error"));
        if(webElements.size()>1)
        {

        }*/

        webElement1.click();
//        webElement2.sendKeys(new String[] { "Поиск" });
        webElement2.sendKeys("Search" );

        try {
            Thread.sleep(10000);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }

        new WebDriverWait(driver,5).until(ExpectedConditions.urlContains("google"));

        driver.navigate().to("https://google.com");

        webElement3 = driver.findElement(By.xpath(".//textarea[@name='q']"));

        try {
            webElement3.sendKeys("Hello");
        }
        catch (StaleElementReferenceException e)
        {
            System.out.println(e.getSupportUrl());
        }

        try
        {
            driver.findElement(By.xpath(".//textares")).click();
        }
        catch (ElementNotInteractableException e)
        {
            System.out.println(e.getSupportUrl());
        }

        //driver.quit();
    }
}
