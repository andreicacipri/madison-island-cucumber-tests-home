package org.fasttrackit.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class ElectronicsBody {

    public  WebElement getElectronicsTypeButton(WebDriver driver,String viewType) {
        return driver.findElement(By.xpath("//dd[@class='last odd']//li/a[contains(. ,'" + viewType + "')]"));
    }
    public void clickAccessoriesButton(WebDriver driver,String viewType) {
        getElectronicsTypeButton(driver,viewType).click();
    }

    public  int getElectronicsTypeNumberOfElements(WebDriver driver,String viewType) {
        String numberOfElementsString = driver.findElement(By.xpath("//dd[@class='last odd']//li/a[contains(. ,'" + viewType + "')]/span[@class='count']")).getText();
        numberOfElementsString = numberOfElementsString.replaceAll("\\D+","");
        int numberOfElementsInteger = Integer.parseInt(numberOfElementsString);
        return numberOfElementsInteger;
    }

    public  int getNumberOfElementsInThatRange(WebDriver driver,String viewType) {
        String numberOfElementsString = driver.findElement(By.xpath("//dd[@class='odd']//li/a[contains(. ,'" + viewType + "')]/span[@class='count']")).getText();
        numberOfElementsString = numberOfElementsString.replaceAll("\\D+","");
        int numberOfElementsInteger = Integer.parseInt(numberOfElementsString);
        return numberOfElementsInteger;
    }

    public  int getNumberOfElementsInBlackColor(WebDriver driver) {
        String numberOfElementsString = driver.findElement(By.xpath("//dd[@class='even']//ol[@class='configurable-swatch-list']//span[.='(2)']")).getText();
        numberOfElementsString = numberOfElementsString.replaceAll("\\D+","");
        int numberOfElementsInteger = Integer.parseInt(numberOfElementsString);
        return numberOfElementsInteger;
    }

    @FindBy(css = "h2.product-name >a")
    private List<WebElement> productNameContainers;

    public List<WebElement> getProductNameContainers() {
        return productNameContainers;
    }

    public List<String> getProductNames() {

        List<String> names = new ArrayList<>();
        for (WebElement nameContainers : productNameContainers) {
            String name = nameContainers.getText();
            names.add(name);
        }
        return names;
    }

        @FindBy(xpath = "//div[@class='price-box']//span[@class='price']")
        private List<WebElement> productPriceContainers;

        public List<WebElement> getProductPriceContainers() {
            return productPriceContainers;
        }

        public List<Double> getProductPrice() {

            List<Double> names = new ArrayList<>();
            for (WebElement priceContainers : productPriceContainers) {
                String name = priceContainers.getText();
                name = name.replaceAll("\\D+",".");
                name =name.replaceFirst(".$","");
                double numberName = Double.parseDouble(name);
                names.add(numberName);
            }
            return names;


    }
    public  WebElement getElectronicsSelectedPriceButton(WebDriver driver,String selectedPrice) {
        return driver.findElement(By.xpath("//dd[@class='odd']//li/a[contains(. ,'" + selectedPrice + "')]"));
    }
    public void clickElectronicsSelectedPriceButton(WebDriver driver,String selectedPrice) {
        getElectronicsSelectedPriceButton(driver,selectedPrice).click();
    }
    public  WebElement getSelectedColor(WebDriver driver,String selectedColor) {
        return driver.findElement(By.xpath("//dd[@class='even']//li/a//img[@title='"+selectedColor+"']"));
    }
    public void clickOnSelectedColor(WebDriver driver,String selectedColor) {
        getSelectedColor(driver,selectedColor).click();
    }
    public  WebElement getDeleteOneFilter(WebDriver driver) {
        return driver.findElement(By.xpath("//div[@class='currently']//ol//li//a[contains(@href,'electronic_type')]"));
    }
    public void clickOnDeleteOneFilter(WebDriver driver) {
        getDeleteOneFilter(driver).click();
    }

}
