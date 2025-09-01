package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.LoginPage;

public class HomePageValidationTest extends BaseTest {
    @Test
    public void hardAssert(){
        System.out.println("apakah ini di run ?");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        // Step 2: Ambil judul halaman
        WebElement pageTitle = driver.findElement(By.cssSelector("[class=\"app_logo\"]"));
        String actualTitle = pageTitle.getText();

        System.out.println("Judul halaman ditemukan: " + actualTitle);


        String expected = "Swag Labs";
        Assert.assertEquals(actualTitle, expected, "title match");
        // Step 3: Assert dengan nilai yang salah bukan Swag Labs
        String expectedTitle = "Dashboard";
        Assert.assertEquals(actualTitle, expectedTitle,
                "title not match (Hard Assert).");
    }
    @Test
    public void softAssert(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        SoftAssert softAssert = new SoftAssert();
        WebElement product = driver.findElement(By.cssSelector("[data-test=\"title\"]"));
        softAssert.assertTrue(product.isDisplayed(),"product not listed");

        WebElement addtoCart = driver.findElement(By.cssSelector("[id=\"add-to-cart-sauce-labs-backpack\"]"));
        String actualText = addtoCart.getText();
        softAssert.assertEquals(actualText,"Buy", "text not equals");

        System.out.println("check if price assert is executed");
        WebElement footers = driver.findElement(By.cssSelector("[data-test=\"inventory-item-price\"]"));
        softAssert.assertTrue(footers.isDisplayed(),"price not found");
        System.out.println("yeah its executed");

        softAssert.assertAll();


    }
}
