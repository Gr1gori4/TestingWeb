package org.example.lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainMenu extends AbstractPage{

    @FindBy(xpath=".//ul[@class='menu']/li//a[@href='/abit/']")
    private WebElement abit;


    public MainMenu(WebDriver driver)
    {
        super(driver);
    }

    public MainMenu clickabit()
    {
        abit.click();
        return this;
    }
}
