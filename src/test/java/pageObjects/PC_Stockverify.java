package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PC_Stockverify extends BasePage {

    public PC_Stockverify(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath="//a[normalize-space()='Desktops']")
    WebElement btn_desktop;

    @FindBy(xpath="//a[normalize-space()='PC (0)']")
    WebElement btn_pc;

    @FindBy(xpath="//p[normalize-space()='There are no products to list in this category.']")
    WebElement msg_nostock;

    public void click_Ondesktop(){
        btn_desktop.click();
    }

    public void click_onPc(){
        btn_pc.click();
    }
    //we cant  write valdiations here in page object class
    //so here we are trying to just check whether message is displayed or not and return boolean values and put validations on it in the test case;.


    public boolean isNoStockDisplayed(){
        try{
            return msg_nostock.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
