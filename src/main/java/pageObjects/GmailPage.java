package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GmailPage extends AbstractPage {
    @FindBy(id = "identifierId")
    private WebElement loginInput;
    @FindBy(id = "identifierNext")
    private WebElement nextLoginButton;
    @FindBy(xpath = ".//*[@id='password']//descendant::input")
    private WebElement passwordInput;
    @FindBy(id = "passwordNext")
    private WebElement nextPasswordButton;

    @FindBy(xpath = "//a[@href='https://www.google.com.ua/intl/uk/options/']")
    private WebElement options;
    @FindBy(xpath = "//a[@href='https://mail.google.com/mail/']")
    private WebElement mailIcon;
    @FindBy(xpath = "//div[@class='M j T b hc Zm  Ke']")
    private WebElement messageWriteButton;
    @FindBy(xpath = "//input[@class='on Cv']")
    private WebElement receiver;
    @FindBy(xpath = "//input[@class='tn']")
    private WebElement subject;
    @FindBy(xpath = "//div[@role='textbox']")
    private WebElement content;
    @FindBy(xpath = "//div[@class='M j T b hc en Ee']")
    private WebElement okButton;
    @FindBy(xpath = "//div[@class='V j zd']")
    private WebElement menu;
    @FindBy(xpath = "//div[@class='dl ql ec']//span")
    private WebElement sentMessages;
    @FindBy(xpath = "//div[@class='V j cb cm']")
    private WebElement checkbox;
    @FindBy(xpath = "//div[@class='V j Vd']")
    private WebElement deleteButton;
    @FindBy(xpath = "//span[@class='FB']")
    private WebElement movedToCash;


    public GmailPage() {
        getPage("https://accounts.google.com/signin");
    }
    public GmailPage enterEmail(String email) {
        sendKeysClickable(loginInput, email);
        click(nextLoginButton);
        return this;
    }

    public GmailPage enterPassword(String password) {
        sendKeysClickable(passwordInput, password);
        click(nextPasswordButton);
        return this;
    }
    public GmailPage gotoMailPage(){
        click(options);
        click(mailIcon);
        return  this;
    }
    public GmailPage writeMessage(String email ,String subjectOfMessage, String body){
        click(messageWriteButton);
        sendKeysVisible(receiver,email);
        sendKeysVisible(subject,subjectOfMessage);
        sendKeysVisible(content,body);
        click(okButton);
        return  this;
    }
    public GmailPage goToSentMessages(){
        click(menu);
        click(sentMessages);
        return this;
    }
    public GmailPage deleteMessage(){
        click(checkbox);
        click(deleteButton);
        return this;
    }
    public Boolean verifyIfMessageIsDeleted(){
        return isElementDisplayed(movedToCash);

    }

}
