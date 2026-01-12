package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AddingToCart;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MAC_stockverify;

public class TC_006_AddingToCart extends BaseClass{

    @Test(groups={"Master","regression"})
    public void addtocart(){

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

            AddingToCart ac=new AddingToCart(driver);
            if(target==true){
                mac.addingToCart();
                boolean targetvalue=ac.verifyaddedtocart();
                Assert.assertTrue(targetvalue,"failed adding to cart");
            }
            else{
                Assert.fail();
            }



        }
        catch(Exception e){
            Assert.fail();
        }
        logger.info("Testcase execution is completed");


    }
}
