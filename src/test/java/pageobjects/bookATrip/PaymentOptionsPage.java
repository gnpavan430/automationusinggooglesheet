package pageobjects.bookATrip;

import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PaymentOptionsPage {
    IOSDriver driver;
    public PaymentOptionsPage(IOSDriver driver){
        this.driver=driver;

    }
     By payWith = By.xpath("//*[@accessibilityLabel='Pay with']");
     By checkbox = By.xpath("//*[@accessibilityLabel='checkboxUnchecked' and @visible='true']");
     By continueToPaymentButtonEnabled = By.xpath("//*[@class='CoreAppRedesign.KLMAppButton' and @enabled='true']");
    By continueToPaymentButtonDisabled = By.xpath("//*[@class='CoreAppRedesign.KLMAppButton' and @enabled='false']");
     By totalPrice = By.xpath("//*[@accessibilityIdentifier='total_currency_label']");
     By changePaymentMethod = By.xpath("//*[@text='Change payment method']");
     By creditCard = By.xpath("//*[@text='Credit card']");
    // By creditCardPaymentMethodCard = By.xpath("//*[contains(text(),'paymentCard']");
     By americanExpressCreditCard = By.xpath("//*[@text='Air France KLM American Express card + EUR 4.78']");
     public By payWith(){
         return payWith;
     }
     public By checkBox(){
         return checkbox;
     }
     public By getContinueToPaymentButtonDisabledBy(){
         return continueToPaymentButtonDisabled;
     }
    public By getContinueToPaymentButtonEnabledBy(){
        return continueToPaymentButtonDisabled;
    }
     public WebElement continueToPaymentButtonDisabled(){
         return driver.findElement(continueToPaymentButtonDisabled);
     }
    public WebElement continueToPaymentButtonEnabled(){
        return driver.findElement(continueToPaymentButtonEnabled);
    }
     public WebElement checkbox(){
         return driver.findElement(checkbox);
     }
     public WebElement totalPrice(){
         return driver.findElement(totalPrice);
     }
     public By changePaymentMethodBy(){
         return changePaymentMethod;
     }
     public WebElement changePaymentMethod(){
         return driver.findElement(changePaymentMethod);
     }
    public By creditCardPaymentMethodElementBy(String paymentMethodCard){
        String oldPaymentCard = "//*[contains(text(),'paymentCard')and @visible='true'and @top='true']";
        String newPaymentMethod = oldPaymentCard.replace("paymentCard",paymentMethodCard);
        By paymentMethod = By.xpath(newPaymentMethod);
        return paymentMethod;

    }

     public WebElement creditCardPaymentMethodElement(String paymentMethodCard){
         String oldPaymentCard = "//*[contains(text(),'paymentCard')and @visible='true'and @top='true']";
         String newPaymentMethod = oldPaymentCard.replace("paymentCard",paymentMethodCard);
         By paymentMethod = By.xpath(newPaymentMethod);
         return driver.findElement(paymentMethod);

     }
     public By creditCard(){
         return creditCard;
     }
     public WebElement creditCardElement(){
         return driver.findElement(creditCard);
     }
    /* public By paymentcardBy(){
         return creditCardPaymentMethodCard;
     }
     public WebElement paymentCardElement(){
         return driver.findElement(creditCardPaymentMethodCard);
     }
*/
}
