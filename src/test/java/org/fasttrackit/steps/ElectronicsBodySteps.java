package org.fasttrackit.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.fasttrackit.TestBase;
import org.fasttrackit.pageobjects.ElectronicsBody;
import org.openqa.selenium.support.PageFactory;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class ElectronicsBodySteps extends TestBase {

    private ElectronicsBody electronicsBody = PageFactory.initElements(driver, ElectronicsBody.class);

    @And("^I click on \"([^\"]*)\" electronics type filter$")
    public void iClickOnElectronicsType(String electronicsType) {
        electronicsBody.getElectronicsTypeNumberOfElements(driver, electronicsType);
        electronicsBody.clickAccessoriesButton(driver, electronicsType);
    }


    @Then("^With \"([^\"]*)\"filter are exactly\"([^\"]*)\"products$")
    public void allProductsAreSortedByType(String electronicsType,int exactNumber) {
        electronicsBody.getProductNames();
        assertThat("The products are not sorted by right type. ", exactNumber+1,is(electronicsBody.getProductNames().size()));

    }

    @And("^I click on \"([^\"]*)\"-\"([^\"]*)\" RON electronics price$")
    public void iClickOnElectronicsPrice(String selectedPrice, String lastPrice) {
        electronicsBody.clickElectronicsSelectedPriceButton(driver, selectedPrice);
    }

    @Then("^All products are in \"([^\"]*)\"-\"([^\"]*)\" range$")
    public void allProductsAreSortedBySelectedPrice(String selectedPrice, double lastPrice) {
        electronicsBody.getProductPrice();
        System.out.println(electronicsBody.getProductPrice());
        for (int i = 0; i < electronicsBody.getProductPrice().size(); i++) {
            assertThat("The products are not sorted by right price. ", electronicsBody.getProductPrice().get(i), lessThan(lastPrice + 1));
        }
    }

    @And("^I click on \"([^\"]*)\" RON and above electronics price$")
    public void iClickOnRONAndAboveElectronicsPrice(String selectedPrice) {
        electronicsBody.clickElectronicsSelectedPriceButton(driver, selectedPrice);
    }

    @Then("^All products are in \"([^\"]*)\" RON and above range$")
    public void allProductsAreInRONAndAboveRange(String selectedPrice) {
        electronicsBody.getProductPrice();
        System.out.println(electronicsBody.getProductPrice());
        selectedPrice = selectedPrice.replaceAll("\\D+",".");
        double doubleSelectedPrice = Double.parseDouble(selectedPrice);
        for (int i = 0; i < electronicsBody.getProductPrice().size(); i++) {
            assertThat("The products are not sorted by right price. ", electronicsBody.getProductPrice().get(i), greaterThanOrEqualTo(doubleSelectedPrice));
        }
    }

    @And("^I click on \"([^\"]*)\"-\"([^\"]*)\" price range$")
    public void iClickOnPriceRange(String selectedPrice, String lastPrice) {
        electronicsBody.clickElectronicsSelectedPriceButton(driver, selectedPrice);
    }

    @And("^I click on \"([^\"]*)\" and above price range$")
    public void iClickOnAndAbovePriceRange(String selectedPrice) {
        electronicsBody.clickElectronicsSelectedPriceButton(driver, selectedPrice);
    }

    @And("^I click on color \"([^\"]*)\" filter$")
    public void iClickOnColorFilterElectronicsTypeFilter(String selectedColor) {
        electronicsBody.clickOnSelectedColor(driver, selectedColor);
    }

    @And("^I delete one filter$")
    public void iDeleteOneFilter() {
electronicsBody.clickOnDeleteOneFilter(driver);
    }
}