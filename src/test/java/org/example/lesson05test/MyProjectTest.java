package org.example.lesson05test;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Dimension;

public class MyProjectTest {

    private WebDriver driver;

    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void setupTest() {
        driver = new ChromeDriver();
    }

    @After
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testCaseVerifyHomePage() {


        driver.get("https://www.diary.ru/");
        driver.manage().window().setSize(new Dimension(1050, 660));

        String actualTitle = "Главная страница — @дневники: асоциальная сеть";
        Assert.assertEquals(driver.getTitle(), actualTitle);
    }


    @Test
    public void testCaseLogin() {
        driver.get("https://www.diary.ru/");
        driver.manage().window().setSize(new Dimension(1050, 660));
        driver.findElement(By.id("drop-login")).click();
        driver.findElement(By.id("usrlog2")).click();
        driver.findElement(By.id("usrlog2")).sendKeys("LalaManana");
        driver.findElement(By.id("usrpass2")).click();
        driver.findElement(By.id("usrpass2")).sendKeys("18#5c73cd");
        driver.findElement(By.cssSelector(".btn-plain:nth-child(7)")).click();

    }

    @Test
    public void testCaseVerifyUserName() {

        driver.get("https://www.diary.ru/");
        driver.manage().window().setSize(new Dimension(1050, 660));

        driver.findElement(By.id("drop-login")).click();
        driver.findElement(By.id("usrlog2")).click();
        driver.findElement(By.id("usrlog2")).sendKeys("LalaManana");
        driver.findElement(By.id("usrpass2")).click();
        driver.findElement(By.id("usrpass2")).sendKeys("18#5c73cd");
        driver.findElement(By.cssSelector(".btn-plain:nth-child(7)")).click();


        WebElement actualUser = driver.findElement(By.className("username"));
        String ExpectedText = "LalaManana";
        Assert.assertEquals(ExpectedText, actualUser.getText());
    }

    @Test
    public void testCreatePost() {

        driver.get("https://www.diary.ru/");
        driver.manage().window().setSize(new Dimension(1050, 660));

        driver.findElement(By.id("drop-login")).click();
        driver.findElement(By.id("usrlog2")).click();
        driver.findElement(By.id("usrlog2")).sendKeys("LalaManana");
        driver.findElement(By.id("usrpass2")).click();
        driver.findElement(By.id("usrpass2")).sendKeys("18#5c73cd");
        driver.findElement(By.cssSelector(".btn-plain:nth-child(7)")).click();

        driver.findElement(By.cssSelector("li:nth-child(2) .alt")).click();
        driver.findElement(By.cssSelector("a > .i-menu-newpost")).click();

        driver.findElement(By.id("postTitle")).click();
        driver.findElement(By.id("postTitle")).sendKeys("Lala");
        driver.findElement(By.id("message")).click();
        driver.findElement(By.id("message")).sendKeys("Hello World");
        driver.findElement(By.id("rewrite")).click();

        driver.quit();
    }

}
