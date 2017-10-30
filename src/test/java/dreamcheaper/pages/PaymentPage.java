package dreamcheaper.pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import org.junit.Assert;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class PaymentPage extends PageObject{
	
	@FindBy(xpath="//button[text()='Pay. Save. Enjoy.']")
	public WebElementFacade btn_Pay_Save_Enjoy;
	
}
