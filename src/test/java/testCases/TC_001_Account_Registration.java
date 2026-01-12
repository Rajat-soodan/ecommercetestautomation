package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.Account_Registration_Page;

public class TC_001_Account_Registration extends BaseClass {

    @Test(groups= {"Regression","Master"}) 
    public void verify_Account_Regsitration(){
        logger.info("Starting testcase execution");
        logger.debug("This is a debig message");
        try {
            HomePage hp = new HomePage(driver);
            hp.clickMyAccount();
            logger.info("clicking on my account");

            hp.clickRegister();
            logger.debug("this is a debugger message");

            Account_Registration_Page rp = new Account_Registration_Page(driver);
            logger.info("Providing customers details");

            rp.setFirstname(randomString().toUpperCase());
            rp.setLastname(randomString().toUpperCase());
            rp.setEmailid(randomString() + "@" + "gmail.com");
            rp.setContactNumber(randomContact());

            String password = randomalphaNumeric();

            rp.setPassword(password);
            rp.setConfirmPassword(password);


            logger.info("Validating expected emssages...");
            rp.setButtonnewsletter();
            rp.setChkboxprivacy();
            logger.info("clicking on submit button");
            rp.setButton_submit();


            logger.info("collecting the confirmation message");
            String confmsg = rp.setmessageconfirmation();
            Assert.assertEquals(confmsg, "Your Account Has Been Created!");
        } catch (Exception e) {
            logger.error("Test failed: ", e.getMessage());
            Assert.fail("Test failed: " + e.getMessage());
        }
        finally {
            logger.info("***** Finished TC001_AccountRegistrationTest *****");
        }
    }




}
