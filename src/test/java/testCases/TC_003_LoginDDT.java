package testCases;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import utilities.DataProviders;


/*Data is valid  - login success - test pass  - logout
Data is valid -- login failed - test fail

Data is invalid - login success - test fail  - logout
Data is invalid -- login failed - test pass
*/

public class TC_003_LoginDDT  extends BaseClass {

    @Test(dataProvider="LoginData",dataProviderClass=DataProviders.class)
    public void loginDDT(String email, String password, String res) {
        try {
            logger.info("Starting testcase execution");
            HomePage hp = new HomePage(driver);
            hp.clickMyAccount();
            hp.clickLogin();//logged in

            //Login page
            LoginPage lp = new LoginPage(driver);
            lp.SetEmail(email);
            lp.setPassword(password);
            lp.clickLogin();

            //Myaccount page
            MyAccountPage mp = new MyAccountPage(driver);
            boolean targetpage = mp.isMyAccountPageDisplayed();

            if (res.equalsIgnoreCase("Valid")) {
                if (targetpage == true) {
                    mp.clickLogout();
                    Assert.assertTrue(true);
                } else {
                    Assert.assertTrue(false);
                }
            }
                if (res.equalsIgnoreCase("Invalid")) {
                    if (targetpage == true) {
                        mp.clickLogout();
                        Assert.assertTrue(false);
                    } else {
                        Assert.assertTrue(true);
                    }
                }


        } catch (Exception e) {
            Assert.fail("An exception occurred: " + e.getMessage());
        }

        logger.info("Test case execution completed");

    }
}
