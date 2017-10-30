package dreamcheaper.pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import org.junit.Assert;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class OfferPage extends PageObject{

	@FindBy(xpath="(//button[text()='Continue'])[last()]") 
	public WebElementFacade button_continue_offer_page;
	
	@FindBy(xpath="//button[text()='Proceed to checkout']")
	public WebElementFacade btn_ProceedToCheckout;
	
}
