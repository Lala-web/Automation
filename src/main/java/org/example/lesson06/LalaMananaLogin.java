package org.example.lesson06;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LalaMananaLogin {

    WebDriver driver;

    @FindBy(id = "drop-login")
    WebElement submit;

    @FindBy(id = "usrlog2")
    WebElement userLalaMananaName;

    @FindBy(id = "usrpass2")
    WebElement passwordLalaManana;

    @FindBy(xpath = "//*[@id=\"page_content\"]/div[1]/h1")
    WebElement titleText;

    @FindBy(id = "signin_btn")
    WebElement login;

    public LalaMananaLogin(WebDriver driver) {
        this.driver = driver;
        //This initElements method will create all WebElements
        PageFactory.initElements(driver, this);
    }

    //Click on submit button
    public void clickSubmit() {
        submit.click();
    }

    //Set user name in textbox
    public void setUserName(String strUserName) {
        userLalaMananaName.sendKeys(strUserName);
    }

    //Set password in password textbox
    public void setPassword(String strPassword) {
        passwordLalaManana.sendKeys(strPassword);
    }

    //Click on login button
    public void clickLogin() {
        login.click();
    }

    //Get the title of Login Page
    public String getLoginTitle() {
        return titleText.getText();
    }


    public void loginToLalaManana(String strUserName, String strPassword) {

        //Click Droplogin button
        this.clickSubmit();
        //Fill user name
        this.setUserName(strUserName);
        //Fill password
        this.setPassword(strPassword);
        //Click Login button
        this.clickLogin();
    }
}


