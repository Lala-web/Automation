package org.example.lesson03;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;


public class CRM {


    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();


        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-bloking");

        WebDriver driver = new ChromeDriver(options);
        driver.get("https://crm.geekbrains.space/user/login");
        driver.manage().window().setSize(new Dimension(1296, 696));
        driver.findElement(By.id("prependedInput")).sendKeys("Applanatest");
        driver.findElement(By.id("prependedInput2")).click();
        driver.findElement(By.id("prependedInput2")).sendKeys("Student2020!");
        driver.findElement(By.id("_submit")).click();
        {
            WebElement element = driver.findElement(By.linkText("Контрагенты"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).perform();
        }


        driver.findElement(By.xpath("//span[contains(text(),'Контактные лица')]")).click();
        driver.findElement(By.xpath("//div[@id=\"container\"]/div[1]/div/div/div[2]/div//a")).click();

        driver.findElement(By.name("crm_contact[lastName]")).sendKeys("Manana");
        driver.findElement(By.name("crm_contact[firstName]")).sendKeys("Lala");

        driver.findElement(By.id("crm_contact_jobTitle-uid-5fe3af5359016")).click();
        driver.findElement(By.name("crm_contact[jobTitle]")).sendKeys("Менеджер");
        {
            WebElement element = driver.findElement(By.cssSelector(".select2-chosen"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).perform();
        }
        {
            WebElement element = driver.findElement(By.tagName("body"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element, 0, 0).perform();
        }
        {
            WebElement element = driver.findElement(By.cssSelector(".select2-chosen"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).clickAndHold().perform();
        }
        {
            WebElement element = driver.findElement(By.id("select2-drop-mask"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).release().perform();
        }
        driver.findElement(By.cssSelector(".lang-ru")).click();
        driver.findElement(By.xpath("//div[7]/div/input")).click();
        driver.findElement(By.xpath("//div[7]/div/input")).sendKeys("erert");
        driver.findElement(By.xpath("//span[contains(text(),'erert')]")).click();
        driver.findElement(By.cssSelector(".btn-group:nth-child(4) > .btn")).click();
        driver.quit();
    }
}
