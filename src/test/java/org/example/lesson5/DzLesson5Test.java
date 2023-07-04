package org.example.lesson5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DzLesson5Test extends AbstractDz5Test{

    @Test
    void test1()
    {
        new WebDriverWait(getDriver(), Duration.ofSeconds(10)).until(ExpectedConditions.urlContains("https://repetit.ru/"));

        Actions search = new Actions(getDriver());

        search.	moveToElement(getDriver().findElement(By.cssSelector("span#ctl00_lblUserName")))
                .pause(1000l)
                .click(getDriver().findElement(By.cssSelector("#ctl00_pnlUserUnauthenticated > div > button")))
                .pause(1000l)
                .build()
                .perform();

        Actions search1 = new Actions(getDriver());
        search1.sendKeys(getDriver().findElement(By.cssSelector("#aspnetForm > div.shade.modal-close > div > div > div.modal-body.login-state > input.input.login")),"89612639475")
                .pause(1000l)
                .sendKeys(getDriver().findElement(By.cssSelector("#aspnetForm > div.shade.modal-close > div > div > div.modal-body.login-state > input.input.password")),"Grigori4_9475")
                .pause(1000l)
                .click(getDriver().findElement(By.cssSelector("#aspnetForm > div.shade.modal-close > div > div > div.modal-footer.login-state > button.btn.btn-big.btn-blue.btn-justify.login-btn")))
                .build()
                .perform();

        //Thread.sleep(1000);

    }
    @Test
    void test2()
    {
        new WebDriverWait(getDriver(), Duration.ofSeconds(10)).until(ExpectedConditions.urlContains("https://repetit.ru/"));

        Actions search = new Actions(getDriver());

        search.	moveToElement(getDriver().findElement(By.cssSelector("span#ctl00_lblUserName")))
                .pause(1000l)
//                .click(getDriver().findElement(By.cssSelector("a#logout")))
//                .pause(1000l)
                .build()
                .perform();
    }

}
