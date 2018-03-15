package testng;
import driver.Driver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.GmailPage;
public class GmailTest extends Driver {
    @BeforeMethod(alwaysRun = true)
    public void beforeMethod(){
        getDriver();
    }
    @Test
    public void test(){
        GmailPage gmailPage = new GmailPage();
        gmailPage.
                enterEmail("testbilokura@gmail.com").
                enterPassword("Kids12345a").
                gotoMailPage().
                writeMessage("bilokura@gmail.com","subject","content").
                goToSentMessages().
                deleteMessage();
        Assert.assertTrue(gmailPage.verifyIfMessageIsDeleted(),"Message is not deleted.");
    }
    @AfterMethod()
    public void afterMethod() {
        quitDriver();
    }
}
