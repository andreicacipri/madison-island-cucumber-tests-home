package org.fasttrackit.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import org.fasttrackit.AppConfig;
import org.fasttrackit.TestBase;
import org.fasttrackit.pageobjects.Header;
import org.fasttrackit.pageobjects.HomePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class HomepageSteps extends TestBase {

    private HomePage mouseHover = PageFactory.initElements(driver, HomePage.class);

    @Given("^I open the homepage$")

    public void iOpenTheHomepage() {
        driver.get(AppConfig.getSiteUrl());
    }


    @And("^I move the mouse on Home&Decor and click$")
    public void iMoveTheMouseOnHomeDecorAndClick() {

        mouseHover.getMouseHover(driver);
    }
}
