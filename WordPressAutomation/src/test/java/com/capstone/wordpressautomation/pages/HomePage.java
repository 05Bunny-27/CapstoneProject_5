package com.capstone.wordpressautomation.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class HomePage {

    private WebDriver driver;
    private WebDriverWait wait;
    private Actions actions;

    /* ===================== LOCATORS ===================== */

    // Community menu (hover only)
    // <a><span>Community</span></a>
    private By communityMenu =
            By.xpath("//a[.//span[normalize-space()='Community']]");

    // Photo Directory (submenu)
    private By photoDirectoryLink =
            By.xpath("//a[contains(@href,'/photos') and normalize-space()='Photo Directory']");

    // Get WordPress link
    private By getWordPressLink =
            By.linkText("Get WordPress");

    /* ===================== CONSTRUCTOR ===================== */

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        this.actions = new Actions(driver);
    }

    /* ===================== ACTION METHODS ===================== */

    public void clickGetWordPress() {
        wait.until(ExpectedConditions.elementToBeClickable(getWordPressLink)).click();
    }

    public void goToPhotoDirectory() {

        // Ensure header is visible
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0,0);");

        // 1️⃣ Hover on Community menu
        WebElement community = wait.until(
                ExpectedConditions.visibilityOfElementLocated(communityMenu)
        );

        actions.moveToElement(community)
               .pause(Duration.ofMillis(300)) // allow dropdown animation
               .perform();

        // 2️⃣ Wait for Photo Directory to appear
        WebElement photoDir = wait.until(
                ExpectedConditions.elementToBeClickable(photoDirectoryLink)
        );

        // 3️⃣ Click Photo Directory
        photoDir.click();
    }
}
