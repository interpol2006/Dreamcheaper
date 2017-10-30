package dreamcheaper.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("http://stage2.dreamcheaper.review/tower/login")

public class UserPage extends PageObject{
	
	@FindBy(xpath="//div/input[@placeholder='Username']")
	WebElement usernameField ;
	
	@FindBy(xpath="//div/input[@placeholder='Password']")
	WebElement passwordField ;
	
	@FindBy(xpath="//div/button[@type='submit']")
	WebElement loginBtn ;
	
	@FindBy(xpath="//div[@class='btn-group btn-group-sm']/a[@class='btn green-meadow']")
	WebElement btnCreateTrip;
	
	@FindBy(xpath="//div/button[@type='submit']")
	WebElement emailField ;
	
	public String getMsg() {
		
		return null;
	}
	
	public void login() {
		usernameField.sendKeys("admin@dreamcheaper.com");
		passwordField.sendKeys("n9HpMbTe1K4i");
		loginBtn.click();
	}

	

	public void click_btn_CreateTrip() {
		btnCreateTrip.click();
		
	}

	public static void sendKey(String string) {
		
		
	}

	
	

}
