package org.fasttrackit.steps;
import cucumber.api.java.en.Then;
import org.fasttrackit.TestBase;
import org.fasttrackit.pageobjects.Header;
import org.openqa.selenium.support.PageFactory;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class HeaderCheckSteps extends TestBase {
    private Header header = PageFactory.initElements(driver, Header.class);

@Then("^The electronics page is open$")
public void theElectronicsPageIsOpen() {
    String actualStep = "Electronics";
    String correctStep = header.getHeaderTitle().getText();
    assertThat("The " +header.getHeaderTitle().getText()+ " page is not open",correctStep.toUpperCase(),is(actualStep.toUpperCase()));
}
        }