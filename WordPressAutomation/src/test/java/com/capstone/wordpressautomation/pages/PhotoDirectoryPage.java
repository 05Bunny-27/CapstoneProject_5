package com.capstone.wordpressautomation.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.List;

public class PhotoDirectoryPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private JavascriptExecutor js;

    // ✅ Photo Directory search FORM (KEY FIX)
    private By photoSearchForm = By.xpath("//form[contains(@action,'/photos')]");

    // ✅ Search input INSIDE Photo Directory form
    private By photoSearchInput =
            By.xpath("//form[contains(@action,'/photos')]//input[@name='s']");

    // ✅ Search button INSIDE Photo Directory form
    private By photoSearchButton =
            By.xpath("//form[contains(@action,'/photos')]//button[@aria-label='Search']");

    // Photo results
    private By photoResults = By.cssSelector("article");

    public PhotoDirectoryPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        this.js = (JavascriptExecutor) driver;
    }

    public void searchPhoto(String keyword) {

        // 1️⃣ Ensure Photo Directory search form is present
        wait.until(ExpectedConditions.presenceOfElementLocated(photoSearchForm));

        // 2️⃣ Locate search input INSIDE the form
        WebElement search = wait.until(
                ExpectedConditions.presenceOfElementLocated(photoSearchInput)
        );

        // 3️⃣ Scroll & focus
        js.executeScript("arguments[0].scrollIntoView({block:'center'});", search);
        js.executeScript("arguments[0].focus();", search);

        // 4️⃣ Clear & type keyword
        js.executeScript("arguments[0].value='';", search);
        js.executeScript("arguments[0].value=arguments[1];", search, keyword);

        // 5️⃣ Click Search button (inside same form)
        WebElement searchBtn = wait.until(
                ExpectedConditions.presenceOfElementLocated(photoSearchButton)
        );
        js.executeScript("arguments[0].click();", searchBtn);
    }

    public boolean arePhotosDisplayed(String keyword) {

        // 1️⃣ Confirm search navigation
        wait.until(ExpectedConditions.urlContains("/search/"));

        // 2️⃣ Confirm at least one image is present
        By images = By.cssSelector("img");

        wait.until(ExpectedConditions.presenceOfElementLocated(images));

        return driver.findElements(images).size() > 0;
    }

}


