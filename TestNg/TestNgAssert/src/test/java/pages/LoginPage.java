package pages;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class LoginPage{
    WebDriver driver;

//    private By usernameField = By.id("user-name");
//    private By passwordField = By.id("password");
//    private By loginButton = By.id("login-button");

    public LoginPage(WebDriver driver){
        this.driver = driver;
        System.out.println(driver);
        System.out.println("Driver di LoginPage: " + driver);
    }
    
    public void setUsername(String username){
        WebElement usernameField = driver.findElement(By.id("user-name"));
        usernameField.clear();
        usernameField.sendKeys(username);
//        driver.findElement(By.id("user-name")).clear();


        
    }

    public void setPassword(String password){
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.clear();
        passwordField.sendKeys(password);

    }

    public void clickLogin(){
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();


    }

    public void login(String username, String password) {
        setUsername(username);
        setPassword(password);
        clickLogin();
    }
}
