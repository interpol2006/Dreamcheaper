package dreamcheaper;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dreamcheaper.steps.serenity.UserSteps;
import net.thucydides.core.annotations.Steps;

public class CreateTripScenarioSteps {
	
	@Steps
	UserSteps userStep ;
	
	@Given("^I am on Home page$")
	public void i_am_on_Home_page() throws Throwable {
		userStep.open_homepage();
	}

	@Then("^I click on Create Trip$")
	public void i_click_on_Create_Trip() throws Throwable {
	    userStep.click_on_btnCreateTrip();
	}

	

	@When("^I enter valid data on the page$")
	public void i_enter_valid_data_on_the_page(DataTable table) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
	    // E,K,V must be a scalar (String, Integer, Date, enum etc)
		List<List<String>> data = table.raw() ;
		UserSteps.sendKeys(data.get(1).get(1));
		
		
	}

	@Then("^trip is created successfully$")
	public void trip_is_created_successfully(String msgMrg) throws Throwable {
	   Assert.assertEquals(userStep.getAlertMsg(), msgMrg);
	}
}
