package dreamcheaper.steps.serenity;

import org.junit.Test;

import dreamcheaper.pages.EditTripPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class EditTripSteps extends ScenarioSteps {
	private static final long serialVersionUID = 1L;
	EditTripPage editTripPage ;
	
	
	@Step
	public void open_edit_trip_page() {
		editTripPage.open();
		editTripPage.open_edit_trip_page();
	}
	
	
	@Step
	public void find_a_booking(String tripID) {
		editTripPage.find_a_booking(tripID);
	}
	
	
	
	
	
	

	@Step
	public void click_on_tab_booking_no() {
		editTripPage.click_on_tab_booking_no();
		
	}

	@Step
	public void click_on_button_Save() {
		editTripPage.click_on_button_Save();
	}

	@Step
	public void choose_option_I_cancel() {
		editTripPage.choose_option_I_cancel();
		
	}

	@Step
	public void open_Trip_History() {
		editTripPage.open_Trip_History();
		
	}
	@Step
	public String getAlertMsg() {
		return editTripPage.get_cancel_msg();
		
	}

	@Step
	public void check_value_of_trip() {
		editTripPage.check_value_of_trip();
	}

	@Step
	public void see_a_correct_Affiliate_earnings() {
		editTripPage.see_a_correct_Affiliate_earnings();
		
	}
	
	
	@Step
	public void check_markup_in_Eur() {
		editTripPage.check_markup_in_Eur();
		
	}

	@Step
	public void check_profit_after_all() {
		editTripPage.check_profit_after_all();
	}

	@Step
	public void check_profit_margin() {
		editTripPage.check_profit_margin();
		
	}

	@Step
	public void send_offer_to_customer() {
		editTripPage.send_offer_to_customer();
	}
}
