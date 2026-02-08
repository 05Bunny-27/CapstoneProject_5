package com.capstone.wordpressautomation.pages;


import org.openqa.selenium.*;

public class GetWordPressPage {

    WebDriver driver;
    By heading = By.xpath("//h1");

    public GetWordPressPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getHeadingText() {
        return driver.findElement(heading).getText();
    }
}

