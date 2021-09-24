package com.php.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseClass {
    public static WebDriver driver;
    public static Properties p;
    public static EventFiringWebDriver e_driver;
    public static long IMPLICIT_WAIT = 20;
    public static long PAGE_LOAD_TIMEOUT =20;


    public BaseClass() throws IOException {
        try {
             p = new Properties();
            FileInputStream ip = new FileInputStream("C:\\Users\\466682\\IdeaProjects\\PHPPracticeProject\\TestData\\config.properties");
            p.load(ip);
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    public void initialization(){
        String browserName = p.getProperty("browser.name");
        if (browserName.equals("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        e_driver = new EventFiringWebDriver(driver);
        driver = e_driver;

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT,TimeUnit.SECONDS);
        driver.get(p.getProperty("browser.url"));


    }

    @BeforeClass
    public void setup(){
        initialization();
    }

    @AfterClass
    public void afterClass(){
        //driver.close();
    }

}
