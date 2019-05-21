package org.fasttrackit.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Header {


    @FindBy(id = "search")
    private WebElement searchField;

@FindBy(className = "search-button")
    private WebElement searchButton;



    @FindBy(css = "h1")
    private WebElement headerTitle;

    public void search(String keyword){
searchField.clear();
        searchField.sendKeys(keyword);
        searchButton.click();
    }

    public WebElement getHeaderTitle() {
        return headerTitle;
    }
    public WebElement getSearchField() {

        return searchField;
    }
    public WebElement getSearchButton() {
        return searchButton;
    }
}
