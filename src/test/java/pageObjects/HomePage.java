package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
  //creating constructor
    public HomePage(WebDriver driver){
        super(driver);
    }

  //creating elements
@FindBy(xpath="//a[@title='My Account']")
    WebElement lnkmyaccount;

 @FindBy(xpath="//a[normalize-space()='Register']")
    WebElement lnkRegister;

@FindBy(linkText = "Login")
WebElement loginbutton;

 public void clickMyAccount(){
     lnkmyaccount.click();
 }

 public void clickRegister(){
     lnkRegister.click();
 }

 public void clickLogin(){
     loginbutton.click();
 }

}
