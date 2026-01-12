package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MAC_stockverify;

public class Tc_005_CheckMacStock extends BaseClass{

    @Test(groups = {"Master","regression"})
    public void verifyMacStock(){
     logger.info("Starting testcase execution");
     logger.info("Capturing debug logs");


       try {
           HomePage hp = new HomePage(driver);

           hp.clickMyAccount();
           hp.clickLogin();

           //login class
           LoginPage lp = new LoginPage(driver);
           lp.SetEmail(p.getProperty("email"));
           lp.setPassword(p.getProperty("password"));
           lp.clickLogin();

           //verifyng mac stock
           MAC_stockverify mac = new MAC_stockverify(driver);
           mac.click_btndesktop();
           mac.click_btnmac();
           boolean target = mac.isMacDisplayed();
           Assert.assertTrue(target, "stock is one but still not  reflecting");
       }
       catch(Exception e){
           Assert.fail();
       }
        logger.info("Testcase execution is completed");



    }
}
