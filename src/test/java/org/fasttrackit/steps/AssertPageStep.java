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
            assertThat("The products are not sorted by right type. ", exactNumberOfProducts, is(electronicsBody.getProductNames().size()));

        }


    @Then("^In the \"([^\"]*)\" and above price range are exactly \"([^\"]*)\" products$")
    public void inTheAndAbovePriceRangeAreExactlyProducts(String firstPrice, int exactNumberOfProducts) {
        electronicsBody.getProductNames();

            assertThat("The products are not sorted by right type. ",exactNumberOfProducts, is(electronicsBody.getProductNames().size()));

        }

    @Then("^With color \"([^\"]*)\"filter are exactly\"([^\"]*)\"products$")
    public void withColorFilterAreExactlyProducts(String selectedColor, int exactNumberOfProducts) {
        electronicsBody.getProductNames();
            assertThat("The products are not sorted by right type. ", exactNumberOfProducts, is(electronicsBody.getProductNames().size()));

        }


    @Then("^Applying \"([^\"]*)\" and \"([^\"]*)\"-\"([^\"]*)\" price range are exactly \"([^\"]*)\" products$")
    public void applyingAndPriceRangeAreExactlyProducts(String electronicsType, String firstPrice, String secondPrice, int exactNumber) {
        electronicsBody.getProductNames();
        assertThat("The products are not sorted by right type. ", exactNumber, is(electronicsBody.getProductNames().size()));

    }

    @Then("^After that there are exactly \"([^\"]*)\" products$")
    public void afterThatThereAreExactlyProducts(int exactNumber) {
        electronicsBody.getProductNames();
        assertThat("The products are not sorted by right type. ", exactNumber, is(electronicsBody.getProductNames().size()));

    }
}
