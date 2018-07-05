package com.epam.atm.demo1v2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class WebDriverBonusTask {

    @BeforeClass(description = "Start browser")
    public void StartBrowser() {
        System.setProperty("webdriver.chrome.driver", "d:\\_webdriver\\chromedriver\\chromedriver.exe");
    }

    @Test
    public void YouTube() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");

        WebDriver driver = new ChromeDriver(options);

        driver.get("https://youtube.com//");

        WebElement fieldInput = driver.findElement(By.xpath("//div[@id='search-input']/input[@id='search']"));
        fieldInput.click();
        fieldInput.sendKeys("Banana Song");

        WebElement searchButton = driver.findElement(By.xpath("//button[@id='search-icon-legacy']"));
        searchButton.click();

        WebElement videoDespicableMe = driver.findElement(By.xpath("//a[@title='Best Of The Minions - Despicable Me 1 and Despicable Me 2']"));
        videoDespicableMe.click();

        WebElement pageText = driver.findElement(By.id("youtube-paths"));
        Assert.assertTrue(pageText.isDisplayed(), "It is NOT YouTube page!");

        WebElement moreThan50BilTimes = driver.findElement(By.xpath("//span[@class='short-view-count style-scope yt-view-count-renderer']"));
        Assert.assertTrue(moreThan50BilTimes.isDisplayed(), "It is less than 50Bil Times");


    }
}
