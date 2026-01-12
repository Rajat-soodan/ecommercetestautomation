package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class MAC_stockverify extends BasePage{
    public MAC_stockverify(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//a[normalize-space()='Desktops']")
    WebElement btn_Desktop;

    @FindBy(xpath = "//a[normalize-space()='Mac (1)']")
    WebElement btn_mac;

    @FindBy(xpath="//div[@class='caption']//h4")
    WebElement text_macdisplayed;

    @FindBy(xpath="//span[normalize-space()='Add to Cart']")
    WebElement btn_Addtocart;

    @FindBy(xpath="//button[@class='btn btn-inverse btn-block btn-lg dropdown-toggle']")
    WebElement btn_cartoption;
    public  void click_btndesktop(){
        btn_Desktop.click();
    }
    public void click_btnmac(){
        btn_mac.click();
    }
    public boolean isMacDisplayed(){
        try{
             return text_macdisplayed.isDisplayed();
        }
        catch(Exception e){
            return false;
        }
    }
    public void addingToCart(){
        btn_Addtocart.click();
    }

    public void cartoption(){
        btn_cartoption.click();
    }


}
