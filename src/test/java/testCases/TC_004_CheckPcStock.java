package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.PC_Stockverify;

public class TC_004_CheckPcStock extends BaseClass{

    @Test(groups = {"Master","regression"})
    public void verifyPcStock(){
        logger.info("starting test case execution");
        logger.info("Capturing debug logs");
         try {
             HomePage hp = new HomePage(driver);
             hp.clickMyAccount();
             hp.clickLogin();

             //login page

             LoginPage lp = new LoginPage(driver);
             lp.SetEmail(p.getProperty("email"));
             lp.setPassword(p.getProperty("password"));
             lp.clickLogin();

             logger.info("checking pc stock");
             PC_Stockverify pc = new PC_Stockverify(driver);
             pc.click_Ondesktop();
             pc.click_onPc();

             boolean targetpage = pc.isNoStockDisplayed();
             Assert.assertTrue(targetpage, "stock is empty but still reflecting");
         }
         catch (Exception e){
             Assert.fail();
         }

   logger.info("Testcase execution is completed");

    }
}
