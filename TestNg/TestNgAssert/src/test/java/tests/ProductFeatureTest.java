package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class ProductFeatureTest extends BaseTest{

    @Test(groups = {"smoke"})
    public void testProductList(){
        System.out.println("Driver di ProductFeatureTest: " + driver);
        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("standard_user", "secret_sauce");

        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("inventory.html"));

    }

    @Test(groups = {"regression"})
    public void testAddtoCart(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        WebElement cart = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        cart.click();

        WebElement badge = driver.findElement(By.cssSelector("[data-test=\"shopping-cart-badge\"]"));


        // Assert that the logo is displayed
        Assert.assertTrue(badge.isDisplayed(), "The badge element is not displayed on the page.");

    }


    @Test(groups = {"smoke","regression"})
    public void testOpenProductDetail() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");
        WebElement detailProductLink = driver.findElement(By.id("item_4_title_link"));
        detailProductLink.click();
        WebElement detailProduct = driver.findElement(By.id("back-to-products"));
        Assert.assertTrue(detailProduct.isDisplayed(), "The badge element is not displayed on the page.");
    }
}
