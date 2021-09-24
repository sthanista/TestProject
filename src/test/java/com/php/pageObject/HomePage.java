package com.php.pageObject;

import com.php.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.IOException;

public class HomePage extends BaseClass {

    @FindBy(xpath = "(//a[@href='https://www.phptravels.net/login'])[2]")
    public WebElement loginBtn;

    public HomePage() throws IOException {
        PageFactory.initElements(driver,this);
    }

    public void clickLogin(){
        String expectedTitle = "PHPTRAVELS - PHPTRAVELS";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);
        loginBtn.click();
    }

}
