package org.fasttrackit.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.fasttrackit.TestBase;
import org.fasttrackit.pageobjects.ElectronicsBody;
import org.fasttrackit.pageobjects.HomePage;
import org.openqa.selenium.support.PageFactory;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.lessThan;

public class ElectronicsBodySteps extends TestBase {

    private ElectronicsBody electronicsBody = PageFactory.initElements(driver, ElectronicsBody.class);
    private HomePage mouseHover = PageFactory.initElements(driver, HomePage.class);

    @And("^I click on \"([^\"]*)\" electronics type filter$")
    public void iClickOnElectronicsType(String electronicsType) {
        electronicsBody.getElectronicsTypeNumberOfElements(driver, electronicsType);

        int storedNumberOfElectronicsType = electronicsBody.getElectronicsTypeNumberOfElements(driver, electronicsType);
        getStepVariables().put("storedNumberOfElectronicsType" ,storedNumberOfElectronicsType);
        electronicsBody.clickAccessoriesButton(driver, electronicsType);
    }


    @And("^I click on \"([^\"]*)\"-\"([^\"]*)\" RON electronics price$")
    public void iClickOnElectronicsPrice(String selectedPrice, String lastPrice) {
        electronicsBody.clickElectronicsSelectedPriceButton(driver, selectedPrice);
    }

    @Then("^All products are in \"([^\"]*)\"-\"([^\"]*)\" range$")
    public void allProductsAreSortedBySelectedPrice(String selectedPrice, String lastPrice) {
        electronicsBody.getProductPrice();
        System.out.println(electronicsBody.getProductPrice());
        selectedPrice = selectedPrice.replaceAll("\\D+",".");
        double doubleSelectedPrice = Double.parseDouble(selectedPrice);

        lastPrice = lastPrice.replaceAll("\\D+",".");
        double doubleLastPrice = Double.parseDouble(lastPrice);

        for (int i = 0; i < electronicsBody.getProductPrice().size(); i++) {
            assertThat("The products are not sorted by right price.Some products are not in the price range.", electronicsBody.getProductPrice().get(i), lessThan(doubleLastPrice + 1));
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
        selectedPrice = selectedPrice.replaceAll("\\D+", ".");
        double doubleSelectedPrice = Double.parseDouble(selectedPrice);
        //String stringSpecialPrice = getStepVariables().get("storedDoubleSpecialPrice").toString();
        //double storedDoubleSpecialPrice = Double.parseDouble(stringSpecialPrice);
        //if (storedDoubleSpecialPrice < doubleSelectedPrice) {
        //    assertThat("The products are not sorted by right price. ", storedDoubleSpecialPrice, greaterThanOrEqualTo(doubleSelectedPrice));
        //} else {
            for (int i = 0; i < electronicsBody.getProductPrice().size(); i++) {
                assertThat("The products are not sorted by right price. ", electronicsBody.getProductPrice().get(i), greaterThanOrEqualTo(doubleSelectedPrice));
            }
        }


    @And("^I click on \"([^\"]*)\"-\"([^\"]*)\" price range$")
    public void iClickOnPriceRange(String selectedPrice, String lastPrice) {

        int storedNumberOfPriceRangeType = electronicsBody.getNumberOfElementsInThatRange(driver, selectedPrice);
        getStepVariables().put("storedNumberOfPriceRangeType" ,storedNumberOfPriceRangeType);

        electronicsBody.clickElectronicsSelectedPriceButton(driver, selectedPrice);
    }

    @And("^I click on \"([^\"]*)\" and above price range$")
    public void iClickOnAndAbovePriceRange(String selectedPrice) {

        int storedNumberOfPriceRangeType = electronicsBody.getNumberOfElementsInThatRange(driver, selectedPrice);
        getStepVariables().put("storedNumberOfPriceRangeType" ,storedNumberOfPriceRangeType);

        electronicsBody.clickElectronicsSelectedPriceButton(driver, selectedPrice);
    }

    @And("^I click on \"([^\"]*)\" color filter$")
    public void iClickOnBlackColorFilterElectronicsTypeFilter(String selectedColor) {
        int storedNumberBlackColor = electronicsBody.getNumberOfElementsInBlackColor(driver);
        getStepVariables().put("storedNumberOfProductsInBlackColor" ,storedNumberBlackColor);
        electronicsBody.clickOnSelectedColor(driver, selectedColor);
    }
    @And("^I click on color \"([^\"]*)\" filter$")
    public void iClickOnCharcoalColorFilterElectronicsTypeFilter(String selectedColor) {
        int storedNumberCharcoalColor = electronicsBody.getNumberOfElementsInCharcoalColor(driver);
        getStepVariables().put("storedNumberOfProductsInCharcoalColor", storedNumberCharcoalColor);
        electronicsBody.clickOnSelectedColor(driver, selectedColor);
    }

    @And("^I delete one filter$")
    public void iDeleteOneFilter() {
electronicsBody.clickOnDeleteOneFilter(driver);
    }

    @And("^I click on Click for price and take the actual price$")
    public void iClickOnClickForPriceAndTakeTheActualPrice() {

        mouseHover.clickMouseHoverClickForPrice(driver);

        String specialPrice = electronicsBody.getTextOnSpecialPricePopUpFromThere(driver);
        specialPrice = specialPrice.replaceAll("\\D+",".");
        specialPrice =specialPrice.replaceFirst(".$","");
        double doubleSpecialPrice = Double.parseDouble(specialPrice);
        getStepVariables().put("storedDoubleSpecialPrice" ,doubleSpecialPrice);
       // mouseHover.clickMouseHoverCloseClickForPrice(driver);

    }
}