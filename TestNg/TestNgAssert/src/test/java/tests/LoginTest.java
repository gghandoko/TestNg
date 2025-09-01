package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.time.Duration;

public class

LoginTest extends BaseTest{

    @DataProvider(name = "loginCredentials")
    public Object[][] loginCredentials(){
        return new Object[][]{
                {"standard_user", "secret_sauce","success"},   // valid
                {"locked_out_user", "secret_sauce", "failure"},
                {"problem_user", "secret_sauce", "success"},
                {"invalid_user", "bad_password", "failure"}


        };
    }

    @Test(dataProvider = "loginCredentials")
    public void testLogin(String username, String password, String expected){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username,password);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlContains("inventory.html"));
        System.out.println(expected);
        if(expected.equals("success")){
            String getUrl = driver.getCurrentUrl();
            Assert.assertTrue(getUrl.contains("inventory.html"), "user not logged in");
        }else if(expected.equals("failure")){
            WebElement errorText = driver.findElement(By.cssSelector("[data-test=\"error-button\"]"));
            Assert.assertTrue(errorText.isDisplayed(), "errot text not displayed, user logged in");
            String message = errorText.getText();
            System.out.println(message);

        }


    }
}
