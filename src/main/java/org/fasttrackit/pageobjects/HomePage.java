package org.fasttrackit.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HomePage {

    public  WebElement getMouseHover(WebDriver driver) {
        WebElement move = driver.findElement(By.linkText("Home&Decor"));
        Actions builder =  new Actions(driver);
        builder.moveToElement(move).build().perform();
        return  move;
    }
    public void mouseHover(WebDriver driver){
        getMouseHover(driver).click();
    }

}
