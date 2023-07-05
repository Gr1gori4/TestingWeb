package org.example.lesson5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DzLesson5Test extends AbstractDz5Test{

    @Test
    @Order(1)
    void logintest()
    {
        new WebDriverWait(getDriver(), Duration.ofSeconds(10)).until(ExpectedConditions.urlContains("https://repetit.ru/"));

        Actions searchMainMenu = new Actions(getDriver());

        searchMainMenu.	moveToElement(getDriver().findElement(By.id("ctl00_lblUserName")))
                .pause(1000l)
                .click(getDriver().findElement(By.cssSelector("#ctl00_pnlUserUnauthenticated > div > button")))
                .pause(1000l)
                .build()
                .perform();

        Actions search2 = new Actions(getDriver());
        search2.sendKeys(getDriver().findElement(By.cssSelector("#aspnetForm > div.shade.modal-close > div > div > div.modal-body.login-state > input.input.login")),"89612639475")
                .pause(1000l)
                .sendKeys(getDriver().findElement(By.cssSelector("#aspnetForm > div.shade.modal-close > div > div > div.modal-body.login-state > input.input.password")),"Grigori4_9475")
                .pause(1000l)
                .click(getDriver().findElement(By.cssSelector("#aspnetForm > div.shade.modal-close > div > div > div.modal-footer.login-state > button.btn.btn-big.btn-blue.btn-justify.login-btn")))
                .build()
                .perform();

        Actions searchPause = new Actions(getDriver());
        searchPause.pause(5000l).build().perform();

        Assertions.assertEquals("https://repetit.ru/teacher/orders.aspx", getDriver().getCurrentUrl());
    }

    @Test
    @Order(2)
    void repetitortest()
    {
        Actions searchMainMenu = new Actions(getDriver());

        searchMainMenu.	moveToElement(getDriver().findElement(By.cssSelector("#aspnetForm > div.wrapper.adaptive > div.navbar > div > div > div.menu-item.repetits > a > span")))
                .pause(1000l)
                .click(getDriver().findElement(By.cssSelector("#aspnetForm > div.wrapper.adaptive > div.navbar > div > div > div.menu-item.repetits > div > div > ul > li:nth-child(1) > a")))
                .pause(1000l)
                .build()
                .perform();

        Actions searchRepetitors= new Actions(getDriver());

        searchRepetitors.click(getDriver().findElement(By.cssSelector("#aspnetForm > div.wrapper.adaptive > div.content.short-footer > div.container.repetitiors-catalog > div.row > div.col.filter > div.extended-filter > div > div.panel.no-shadow.lesson-place > p:nth-child(1)")))
                .pause(1000l)
                .sendKeys(getDriver().findElement(By.cssSelector("#aspnetForm > div.wrapper.adaptive > div.content.short-footer > div.container.repetitiors-catalog > div.row > div.col.filter > div.extended-filter > div > div.panel.no-shadow.price.control > div > div.price-from > input")),"100")
                .sendKeys(getDriver().findElement(By.cssSelector("#aspnetForm > div.wrapper.adaptive > div.content.short-footer > div.container.repetitiors-catalog > div.row > div.col.filter > div.extended-filter > div > div.panel.no-shadow.price.control > div > div.price-to > input")),"900")
                .click(getDriver().findElement(By.cssSelector("#aspnetForm > div.wrapper.adaptive > div.content.short-footer > div.container.repetitiors-catalog > div.row > div.col.filter > div.update-results > p")))
                .pause(3000l)
                .build()
                .perform();

        Actions searchPerson = new Actions(getDriver());
        searchPerson.click(getDriver().findElement(By.cssSelector("#aspnetForm > div.wrapper.adaptive > div.content.short-footer > div.container.repetitiors-catalog > div > div.col.catalog > div.teachers > div:nth-child(1) > a")))
                .build()
                .perform();

        Assertions.assertEquals("https://repetit.ru/repetitor.aspx?id=146553", getDriver().getCurrentUrl());
    }

    @Test
    @Order(3)
    void changeRegiontest()
    {
        Actions searchMainMenu = new Actions(getDriver());

        searchMainMenu.click(getDriver().findElement(By.cssSelector("#aspnetForm > div.wrapper.adaptive > div.header > div.container > div > div.col-2 > span")))
                .pause(1000l)
                .build()
                .perform();

        Actions changeRegion = new Actions(getDriver());

        changeRegion.sendKeys(getDriver().findElement(By.cssSelector("#aspnetForm > div.shade.modal-close > div > div > div > div.search > input")),"Ту")
                .pause(1000l)
                .click(getDriver().findElement(By.cssSelector("#aspnetForm > div.shade.modal-close > div > div > div > div.areas > div > div.areas-scrolling-box > ul > li:nth-child(75) > a")))
                .pause(1000l)
                .build()
                .perform();


        Actions MathRepetitors= new Actions(getDriver());
        MathRepetitors.click(getDriver().findElement(By.cssSelector("#aspnetForm > div.wrapper.adaptive > div.content.short-footer > div.subjects > div > div.row.collapsed.middle-high > div:nth-child(1) > a"))).build().perform();

        Actions searchRepetitors= new Actions(getDriver());
        searchRepetitors
                .click(getDriver().findElement(By.cssSelector("#aspnetForm > div.wrapper.adaptive > div.content.short-footer > div.container.repetitiors-catalog > div.row > div.col.filter > div.extended-filter > div > div.panel.no-shadow.lesson-place > p.item.control.active")))
                .pause(1000l)
                .sendKeys(getDriver().findElement(By.cssSelector("#aspnetForm > div.wrapper.adaptive > div.content.short-footer > div.container.repetitiors-catalog > div.row > div.col.filter > div.extended-filter > div > div.panel.no-shadow.price.control > div > div.price-from > input")),"700")
                .sendKeys(getDriver().findElement(By.cssSelector("#aspnetForm > div.wrapper.adaptive > div.content.short-footer > div.container.repetitiors-catalog > div.row > div.col.filter > div.extended-filter > div > div.panel.no-shadow.price.control > div > div.price-to > input")),"850")
                .click(getDriver().findElement(By.cssSelector("#aspnetForm > div.wrapper.adaptive > div.content.short-footer > div.container.repetitiors-catalog > div.row > div.col.filter > div.update-results > i")))
                .pause(3000l)
                .build()
                .perform();

        Actions searchPerson = new Actions(getDriver());
        searchPerson.click(getDriver().findElement(By.cssSelector("#aspnetForm > div.wrapper.adaptive > div.content.short-footer > div.container.repetitiors-catalog > div.row > div.col.catalog > div.teachers > div:nth-child(4) > a")))
                .build()
                .perform();

        Assertions.assertEquals("https://tula.repetit.ru/repetitor.aspx?id=206921", getDriver().getCurrentUrl());

        Actions personRepet = new Actions(getDriver());
        personRepet.click(getDriver().findElement(By.cssSelector("#ctl00_ContentPlaceHolder1_pnlTeacher > div.row > div.col.side-column > div > div:nth-child(6) > button")))
                .pause(1000l)
                .sendKeys(getDriver().findElement(By.cssSelector("#your-name")),"Имя")
                .perform();

        Assertions.assertEquals("https://tula.repetit.ru/repetitor.aspx?id=206921", getDriver().getCurrentUrl());



    }


    @Test
    @Order(4)
    void unLogintest()
    {

        Actions search = new Actions(getDriver());

        search.moveToElement(getDriver().findElement(By.id("ctl00_lblUserName")))
                .pause(1000l)
                .click(getDriver().findElement(By.cssSelector("#ctl00_pnlUserAuthenticated > ul > li:nth-child(17) > a")))
                .pause(3000l)
                .build()
                .perform();

        Assertions.assertEquals("https://repetit.ru/", getDriver().getCurrentUrl());
    }

}
