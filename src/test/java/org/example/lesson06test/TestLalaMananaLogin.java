package org.example.lesson06test;

import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.example.lesson06.LalaMananaHomePage;
import org.example.lesson06.LalaMananaLogin;

public class TestLalaMananaLogin {

    private WebDriver driver;

    LalaMananaLogin objLogin;
    LalaMananaHomePage objHomePage;

    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void setupTest() {

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.diary.ru/");
        driver.manage().window().maximize();
    }

    @Test
    public void test_Login_Page_Appear_Correct() {

        //Create Login Page object
        objLogin = new LalaMananaLogin(driver);

        //Verify login page title
        String loginPageTitle = objLogin.getLoginTitle();
        Assert.assertTrue(loginPageTitle.toLowerCase().contains("где я и кто здесь"));


        //login to application
        objLogin.loginToLalaManana("lalamanana", "lalamananapassword");

        // go the next page
        objHomePage = new LalaMananaHomePage(driver);

        //Verify home page
        Assert.assertTrue(objHomePage.getHomePageDashboardUserName().toLowerCase().contains("lalamanana"));
    }
}