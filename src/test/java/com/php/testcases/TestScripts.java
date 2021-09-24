package com.php.testcases;

import com.php.base.BaseClass;
import com.php.base.HelperClass;
import com.php.pageObject.HomePage;
import com.php.pageObject.LoginPage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestScripts extends BaseClass {

    public HomePage homePage;
    public LoginPage loginPage;

    public TestScripts() throws IOException {
    }


    @Test
    public void testCase1() throws IOException {
        // Verify user is able to successfully login with valid credential
        homePage = new HomePage();
        homePage.clickLogin();
        loginPage = new LoginPage();
        String userName = HelperClass.readTestCredential("valid","UserEmail");
        String password = HelperClass.readTestCredential("valid","password");
        loginPage.loginCredential(userName,password);

    }

    public void testCase2() throws IOException {
        // Verify that error message is displayed when user login with invalid credential
        homePage = new HomePage();
        homePage.clickLogin();
        loginPage = new LoginPage();
        String userName = HelperClass.readTestCredential("invalid","UserEmail");
        String password = HelperClass.readTestCredential("invalid","password");
        loginPage.loginCredential(userName,password);

    }





}
