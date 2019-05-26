package org.fasttrackit.steps;

import cucumber.api.java.en.Then;
import org.fasttrackit.TestBase;
import org.fasttrackit.pageobjects.ElectronicsBody;
import org.openqa.selenium.support.PageFactory;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class AssertPageStep  extends TestBase {
    private ElectronicsBody electronicsBody = PageFactory.initElements(driver, ElectronicsBody.class);

    @Then("^In the \"([^\"]*)\"-\"([^\"]*)\" price range are exactly \"([^\"]*)\" products$")
    public void inThePriceRangeAreExactlyProducts(String firstPrice, String lastPrice, int exactNumberOfProducts) {
        electronicsBody.getProductNames();
            assertThat("The products are not sorted by right type. ",getStepVariables().get("storedNumberOfPriceRangeType"), is(electronicsBody.getProductNames().size()));

        }


    @Then("^In the 400 and above price range are exactly 2 products$")
    public void inTheAndAbovePriceRangeAreExactlyProducts() {
        electronicsBody.getProductNames();

            assertThat("The products are not sorted by right type. ",getStepVariables().get("storedNumberOfPriceRangeType"), is(electronicsBody.getProductNames().size()));

        }

    @Then("^With black color filter are exactly 8 products$")
    public void withBlackColorFilterAreExactlyProducts() {
        electronicsBody.getProductNames();
            assertThat("The products are not sorted by right type. ", getStepVariables().get("storedNumberOfProductsInBlackColor"), is(electronicsBody.getProductNames().size()));

        }

    @Then("^With Charcoal color filter are exactly 2 products$")
    public void withCharcoalColorFilterAreExactlyProducts() {
        electronicsBody.getProductNames();
        assertThat("The products are not sorted by right type. ", getStepVariables().get("storedNumberOfProductsInCharcoalColor"), is(electronicsBody.getProductNames().size()));

    }

    @Then("^Applying Accessories and 0,00-99,99 price range are exactly 3 products$")
    public void applyingAndPriceRangeAreExactlyProducts() {
        electronicsBody.getProductNames();
        assertThat("The products are not sorted by right type. ", getStepVariables().get("storedNumberOfPriceRangeType"), is(electronicsBody.getProductNames().size()));

    }

    @Then("^After that there are exactly 4 products$")
    public void afterThatThereAreExactlyProducts() {
        electronicsBody.getProductNames();
        assertThat("The products are not sorted by right type. ",getStepVariables().get("storedNumberOfElectronicsType"), is(electronicsBody.getProductNames().size()));

    }
    @Then("^With \"([^\"]*)\"filter are exactly\"([^\"]*)\"products$")
    public void allProductsAreSortedByType(String electronicsType,int exactNumber) {
        electronicsBody.getProductNames();
        assertThat("The products are not sorted by right type. ", getStepVariables().get("storedNumberOfElectronicsType"),is(electronicsBody.getProductNames().size()));

    }
}
