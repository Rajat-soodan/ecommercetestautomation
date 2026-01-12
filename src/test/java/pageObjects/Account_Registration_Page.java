package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Account_Registration_Page extends BasePage{

    public Account_Registration_Page(WebDriver driver){
        super(driver);
    }
    //firstname
    @FindBy(xpath="//input[@id='input-firstname']")
    WebElement firstname;
    //lastname
    @FindBy(xpath="//input[@id='input-lastname']")
    WebElement lastname;
    //E-mail
    @FindBy(xpath="//input[@id='input-email']")
    WebElement emailid;
    //phone number
    @FindBy(xpath="//input[@id='input-telephone']")
    WebElement contactNumber;
    //password
    @FindBy(xpath="//input[@id='input-password']")
    WebElement password;
    //confirm password
    @FindBy(xpath="//input[@id='input-confirm']")
    WebElement confirmPassword;
    //newsletter checkbox
    @FindBy(xpath="//input[@value='0']")
    WebElement buttonnewsletter;
    //terms of service checkbox
    @FindBy(xpath="//input[@name='agree']")
    WebElement chkboxprivacy;
    //submit button
    @FindBy(xpath="//input[@value='Continue']")
    WebElement button_submit;
    @FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
    WebElement messageconfirmation;

    public void setFirstname(String fname){
        firstname.sendKeys(fname);
    }
    public void setLastname(String lname){
        lastname.sendKeys(lname);
    }
    public void setEmailid(String email){
        emailid.sendKeys(email);
    }
    public void setContactNumber(String number){
        contactNumber.sendKeys(number);
    }
    public void setPassword(String pwd){
        password.sendKeys(pwd);
    }
    public void setConfirmPassword(String cnfpwd){
        confirmPassword.sendKeys(cnfpwd);
    }
    public void setButtonnewsletter(){
        buttonnewsletter.click();
    }
    public void setChkboxprivacy()
    {
        chkboxprivacy.click();
    }
    public void setButton_submit(){
        button_submit.click();
    }
    public String setmessageconfirmation()
    {
        try{
            return(messageconfirmation.getText());
        } catch (Exception e) {
            return(e.getMessage());
        }
    }




}
