package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;

public class TC_002_LoginTest extends BaseClass {

    @Test(groups= {"Sanity","Master"})
    public void verify_Login(){
      logger.info("Starting test case execution");
      logger.debug("capturing debug logs");
    try{
        HomePage hp=new HomePage(driver);
        hp.clickMyAccount();
        logger.info("clicked on my account link");
        hp.clickLogin();
        logger.info("Clicking on login under my accunts");

        //Login Page
        LoginPage lp=new LoginPage(driver);
        logger.info("Entering valid email and password");
        lp.SetEmail(p.getProperty("email"));
        logger.info("Entered email id");
        lp.setPassword(p.getProperty("password"));
        logger.info("Entered Password");
        lp.clickLogin();
        logger.info("Clicked on the login button");

        //My Account Page
        MyAccountPage map=new MyAccountPage(driver);

        boolean targetPage= map.isMyAccountPageDisplayed();
        //Assert.assertEquals(actualValue, expectedValue, failureMessage);
        Assert.assertTrue(targetPage, "Login failed");

        } catch (Exception e) {
        Assert.fail();
    }
        logger.info("Test case execution is completed");
    }
}
