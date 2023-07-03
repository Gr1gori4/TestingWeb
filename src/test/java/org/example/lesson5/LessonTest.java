package org.example.lesson5;

import org.checkerframework.checker.units.qual.A;
import org.checkerframework.checker.units.qual.K;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.time.Duration;

public class LessonTest extends AbstractTest
{

    @Test
    void myActiontest() throws InterruptedException
    {
        new WebDriverWait(getDriver(), Duration.ofSeconds(10)).until(ExpectedConditions.urlContains("https://www.vstu.ru"));
        Assertions.assertTrue((getDriver().getTitle().contains("университет")),"страница входа недоступна");

        Actions search = new Actions(getDriver());

        search.click(getDriver().findElement(By.cssSelector(".sb-icon-search")))
                .pause(1000l)
                .sendKeys(getDriver().findElement(By.cssSelector(".sb-search-input")),"кравец")
                .pause(1000l)
                .click(getDriver().findElement(By.cssSelector(".sb-search-submit")))
                .build()
                .perform();

        Thread.sleep(1000);
    }

    @Test
    void jsTest() throws InterruptedException
    {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) getDriver();
        long windowWidth =(long) jsExecutor.executeScript("return window.innerWidth");
        System.out.println("Размер окна" +windowWidth);
        jsExecutor.executeScript("window.scrollBy(0,500)");

        Thread.sleep(1000);
        getDriver().findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL,Keys.END);
    }

    @Test
    void cookieTest()
    {
        getDriver().manage().addCookie(new Cookie("promo_code","november2"));
        for(Cookie cookie: getDriver().manage().getCookies())
        {
            System.out.println(cookie.getName()+" "+cookie.getExpiry());
        }
        getDriver().manage().deleteCookie(new Cookie("promo_code","november2"));
    }

    @Test
    @Disabled
    void voidTest()
    {
        WebElement voidElement = getDriver().findElement(By.cssSelector(".sb-icon-search"));
        Actions actionProviderContex = new Actions(getDriver());

        actionProviderContex.contextClick(voidElement).build().perform();

        Actions actionProviderDouble = new Actions(getDriver());
        actionProviderDouble.doubleClick(voidElement).build().perform();

        Actions actionProviderMove = new Actions(getDriver());
        actionProviderMove.moveToElement(voidElement).build().perform();
        Actions actionProviderOffset = new Actions(getDriver());
        actionProviderOffset.moveByOffset(1,1).build().perform();

        Actions actionPrivider = new Actions(getDriver());
        actionPrivider.dragAndDrop(voidElement,voidElement).build().perform();

        Actions actionProviderHold = new Actions(getDriver());
        actionProviderHold.clickAndHold(voidElement).moveToElement(voidElement).build().perform();

        actionProviderHold.release().build().perform();
    }


//    @Test
//    @Disabled
//    void voidKeyTest()
//    {
//        Actions actionProvider = new Actions(getDriver());
//        Action keydown =  actionProvider.keyDown(Keys.CONTROL).sendKeys("a").build();
//
//        keydown.perform();
//        actionProvider.sendKeys(Keys.ENTER).perform();
//    }




    @Test
    @Disabled
    void voidBrowserTest()
    {
        System.out.println(getDriver().getTitle());
        System.out.println(getDriver().getCurrentUrl());
        getDriver().navigate().to("https://selenium.dev");
        getDriver().navigate().back();
        getDriver().navigate().forward();
        getDriver().navigate().refresh();
    }

    @Test
    @Disabled
    void voidElements()
    {
        WebElement selectElement = getDriver().findElement(By.id("selectElementID"));
        Select selestObject = new Select(selectElement);
        selestObject.selectByIndex(1);
        selestObject.selectByValue("value1");
        selestObject.deselectByVisibleText("Bread");
        selestObject.deselectAll();
    }
}
