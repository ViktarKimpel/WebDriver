package com.epam.atm.demo1v2;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class WebDriverHomeTask {

    @BeforeClass(description = "Start browser")
    public void StartBrowser() {
        System.setProperty("webdriver.chrome.driver", "d:\\_webdriver\\chromedriver\\chromedriver.exe");
    }
    @Test
    public void MailCreation () {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");

        WebDriver driver = new ChromeDriver(options);

        driver.get("https://gmail.com/");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement emailInput = driver.findElement(By.cssSelector("input#identifierId.whsOnd.zHQkBf"));
        emailInput.sendKeys("viktar.kimpel@gmail.com");

        WebElement emailButton = driver.findElement(By.cssSelector("#identifierNext"));
        emailButton.click();

        WebElement gmailPasswordPage = driver.findElement(By.id("yDmH0d"));
        Assert.assertTrue(gmailPasswordPage.isDisplayed(), "Our email are invalid!");

        WebElement passwordInput = driver.findElement(By.xpath("//div[@class='Xb9hP']/input[@type='password']"));
        passwordInput.sendKeys("Imrahil1216");

        WebElement passwordButton = driver.findElement(By.cssSelector("#passwordNext"));
        passwordButton.click();

        WebElement gmailMainPage = driver.findElement(By.xpath("//body[@class='aAU']"));
        Assert.assertTrue(gmailMainPage.isDisplayed(), "Our password are invalid!");


        WebElement composeButton = driver.findElement(By.xpath("//div[text()='COMPOSE']"));
        composeButton.click();

        WebElement recipientInput = driver.findElement(By.xpath("//textarea[@name='to']"));
        recipientInput.click();
        recipientInput.sendKeys("viktar.kimpel@aerlingus.com");

        WebElement subjectInput = driver.findElement(By.xpath("//div[@class='aoD az6']/input[@placeholder='Subject']"));
        subjectInput.sendKeys("Test");

        WebElement bodyInput = driver.findElement(By.xpath("//div[@class='Am Al editable LW-avf']"));
        bodyInput.click();
        bodyInput.sendKeys("Hello, World!");

        WebElement saveAndCLoseButton = driver.findElement(By.xpath("//td[@class='Hm']/img[@class='Ha']"));
        saveAndCLoseButton.click();

        WebElement draftButton = driver.findElement(By.xpath("//span[@class='nU n1']/a[@href='https://mail.google.com/mail/u/0/#drafts']"));
        draftButton.click();

        WebElement draftButton1 = driver.findElement(By.xpath("//div[@class='yW']/font[@color='#DD4B39']"));
        Assert.assertTrue(draftButton1.isDisplayed(),"Draft is disappeared!");
        draftButton1.click();

        WebElement recipientResult = driver.findElement(By.xpath("//div[@class='oL aDm az9']/span[@email='viktar.kimpel@aerlingus.com']"));
        Assert.assertTrue(recipientResult.isDisplayed(), "Recipient is invalid!");

        WebElement subjectResult = driver.findElement(By.xpath("//div[text()='Test']"));
        Assert.assertTrue(subjectResult.isDisplayed(), "Subject is invalid!");

        WebElement bodyResult = driver.findElement(By.xpath("//div[text()='Hello, World!']"));
        Assert.assertTrue(bodyResult.isDisplayed(), "Recipient is invalid!");

        WebElement sendButton = driver.findElement(By.xpath("//div[text()='Send']"));
        sendButton.click();


        WebElement sentButton = driver.findElement(By.xpath("//a[@href='https://mail.google.com/mail/u/0/#sent']"));
        sentButton.click();

        WebElement draftsButton = driver.findElement(By.xpath("//a[@href='https://mail.google.com/mail/u/0/#drafts']"));
        draftsButton.click();

        WebElement draftsText = driver.findElement(By.xpath("//tr[@class='TD']/td[@class='TC']"));
        Assert.assertTrue(draftsText.isDisplayed(), "Draft is here!");

        WebElement imageButton = driver.findElement(By.xpath("//a[@href='https://accounts.google.com/SignOutOptions?hl=en&continue=https://mail.google.com/mail&service=mail']"));
        imageButton.click();

        WebElement logOutButton = driver.findElement(By.xpath("//a[@class='gb_Ea gb_1f gb_8f gb_Oe gb_Jb']"));
        logOutButton.click();

        driver.quit();
        System.out.println("Browse was successfully quited");





    }
}
