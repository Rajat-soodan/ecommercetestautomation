package pageObjects;

import com.beust.ah.A;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddingToCart extends BasePage{
    public AddingToCart(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
    WebElement msg_nostock;

    public boolean verifyaddedtocart(){
        try{
            return msg_nostock.isDisplayed();
        }
        catch(Exception e){
            return false;
        }
    }


}
