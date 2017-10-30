package dreamcheaper;

import org.junit.Assert;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dreamcheaper.steps.serenity.EditTripSteps;
import net.thucydides.core.annotations.Steps;

public class EditTripScenarioSteps {
	
	@Steps
	EditTripSteps editTripStep ;
	
	@Given("^Admin is on edit trip page$")
	public void user_is_on_edit_trip_page() throws Throwable {
	    editTripStep.open_edit_trip_page();
	}
	
	
	@Given("^I have a trip \"([^\"]*)\"$")
	public void i_have_a_booking_to_cancel(String tripID) throws Throwable {
	    editTripStep.find_a_booking(tripID);
	}
	
	@Given("^I click on tab 'Booking No'$")
	public void i_click_on_tab_Booking_No() throws Throwable {
	    editTripStep.click_on_tab_booking_no();
	}
	
	
	@When("^I choose option 'I cancelled'$")
	public void i_choose_option_I_cancelled() throws Throwable {
	    editTripStep.choose_option_I_cancel();
	}

	@When("^I click button 'Save'$")
	public void i_click_button_Save() throws Throwable {
	    editTripStep.click_on_button_Save();
	}
	
	@When("^I open Trip History$")
	public void i_open_Trip_History() throws Throwable {
	    editTripStep.open_Trip_History();
	}
	
	@Then("^I should see a history entry \"([^\"]*)\"$")
	public void i_should_see_a_history_entry(String message) throws Throwable {
		Assert.assertEquals(editTripStep.getAlertMsg(), message);
	}
	
	@When("^I check the value of trip$")
	public void i_check_the_value_of_trip() throws Throwable {
	    editTripStep.check_value_of_trip();
	}

	@Then("^I should see a correct Affiliate earnings$")
	public void i_should_see_a_correct_Affiliate_earnings() throws Throwable {
	    editTripStep.see_a_correct_Affiliate_earnings();
	}

	@Then("^correct MarkUp in Eur$")
	public void markup_in_Eur() throws Throwable {
	    editTripStep.check_markup_in_Eur();
	}

	@Then("^I should see correct Profit after all$")
	public void i_should_see_correct_Profit_after_all() throws Throwable {
	    editTripStep.check_profit_after_all();
	}

	@Then("^correct Real Profit Margin$")
	public void real_Profit_Margin() throws Throwable {
	    editTripStep.check_profit_margin();
	    
	}
	
	@Given("^Admin send offer to customer$")
	public void admin_send_offer_to_customer() throws Throwable {
	    editTripStep.send_offer_to_customer();
	}
}
