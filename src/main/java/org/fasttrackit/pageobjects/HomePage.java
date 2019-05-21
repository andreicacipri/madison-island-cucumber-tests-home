package org.fasttrackit.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomePage {
    @FindBy(linkText ="Electronics")
    private WebElement electronicsPage ;

    public  WebElement getMouseHover(WebDriver driver) {
        WebElement move = driver.findElement(By.linkText("HOME & DECOR"));
        Actions builder =  new Actions(driver);
        builder.moveToElement(move).build().perform();
        builder.moveToElement(electronicsPage).build().perform();
        return  move;
    }

    public  WebElement getMouseHoverElectronics(WebDriver driver) {
        WebElement move = driver.findElement(By.linkText("Electronics"));
        Actions builder = new Actions(driver);
        builder.moveToElement(move).build().perform();
        return move;
    }
    public void clickMouseHoverElectronics(WebDriver driver){
        getMouseHoverElectronics(driver).click();
    }
}
