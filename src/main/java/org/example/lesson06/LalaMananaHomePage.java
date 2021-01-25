package org.example.lesson06;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LalaMananaHomePage {

    WebDriver driver;
    @FindBy(xpath = "//*[@id=\"body\"]/div[2]/div/ul[2]/li[9]/a")
    WebElement homePageUserName;

    public LalaMananaHomePage(WebDriver driver) {
        this.driver = driver;

        //This initElements method will create all WebElements
        PageFactory.initElements(driver, this);
    }

    //Get the User name from Home Page
    public String getHomePageDashboardUserName() {
        return homePageUserName.getText();
    }
}