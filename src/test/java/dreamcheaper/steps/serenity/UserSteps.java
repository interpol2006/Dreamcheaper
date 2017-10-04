package dreamcheaper.steps.serenity;

import org.openqa.selenium.WebElement;

import dreamcheaper.pages.UserPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class UserSteps extends ScenarioSteps{
	private static final long serialVersionUID = 1L;
	UserPage userPage ;
	
	@Step
	public String getAlertMsg() {
		return userPage.getMsg();
	}
	
	@Step
	public void open_homepage() {
		
		userPage.open();
		userPage.login();
	}
	
	
	@Step
	public void click_on_btnCreateTrip() {
		userPage.click_btn_CreateTrip();
		
	}
	
	@Step
	public static void sendKeys(String string) {
		UserPage.sendKey(string) ;
		
	}

	
	
	
}
