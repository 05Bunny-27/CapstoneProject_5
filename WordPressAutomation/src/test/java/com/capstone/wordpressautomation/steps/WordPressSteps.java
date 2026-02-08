package com.capstone.wordpressautomation.steps;


import com.capstone.wordpressautomation.base.BaseTest;
import com.capstone.wordpressautomation.pages.*;
import io.cucumber.java.en.*;
import org.testng.Assert;

public class WordPressSteps extends BaseTest {

    HomePage home;
    GetWordPressPage getPage;
    PhotoDirectoryPage photo;

    @Given("Launch WordPress website")
    public void launchSite() {
        setup();
        driver.get("https://wordpress.org/");
        Assert.assertEquals(driver.getTitle(),"Blog Tool, Publishing Platform, and CMS – WordPress.org");
    }

    @When("Navigate to Get WordPress page")
    public void navigateToGetWordPress() {
        home = new HomePage(driver);
        home.clickGetWordPress(); // ✅ NEW METHOD
    }

    @Then("Verify Get WordPress text")
    public void verifyText() {
        getPage = new GetWordPressPage(driver);
        Assert.assertEquals(getPage.getHeadingText(), "Get WordPress");
    }

    @And("Navigate to Photo Directory")
    public void navigatePhoto() {
        home.goToPhotoDirectory();
    }

    @Then("Search image and verify results")
    public void verifyImages() {

        photo = new PhotoDirectoryPage(driver);

        String keyword = "nature";
        photo.searchPhoto(keyword);

        Assert.assertTrue(
            photo.arePhotosDisplayed(keyword),
            "Photo search results not displayed"
        );

        tearDown();
    }



}
