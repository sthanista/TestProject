package com.php.pageObject;

import com.php.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.IOException;

public class LoginPage extends BaseClass {

    @FindBy(xpath = "//input[@type = 'email']")
    public WebElement enterEmail;

    @FindBy(xpath = "//input[@type = 'password']")
    public WebElement enterPassword;

    @FindBy(xpath = "//span[contains(text(),'Login')]")
    public WebElement clickLogin;

    public LoginPage() throws IOException {
        PageFactory.initElements(driver,this);
    }

    public void loginCredential(String userEmail, String userPassword){
        String expectedTitle = "Login - PHPTRAVELS";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);
        enterEmail.sendKeys(userEmail);
        enterPassword.sendKeys(userPassword);
        clickLogin.click();
    }
}
