package dreamcheaper.steps.serenity;

import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.assertThat;

import dreamcheaper.pages.AcceptOfferPage;
import dreamcheaper.pages.EditTripPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class AcceptOfferSteps extends ScenarioSteps {
	private static final long serialVersionUID = 1L;
	AcceptOfferPage acceptOfferPage ;
	@Step
	public void user_accept_offer() {
		acceptOfferPage.user_accept_offer();
	}
	
	
	
	@Step
	public void user_check_saving() {
		acceptOfferPage.user_check_saving();
		
	}
	
	@Step
	public void user_check_total_amount(String payment_method) {
		acceptOfferPage.user_check_total_amount(payment_method);
		
		
	}

	@Step
	public void i_need_print_out_pay_now_fee_to_report(){
	    float s = acceptOfferPage.calculate_pay_now_fee();
	    my_system_print_out(s);
		
	}
	@Step
	public void i_need_print_out_pay_later_fee_to_report(){
	    float s = acceptOfferPage.calculate_pay_later_fee();
	    my_system_print_out(s);
	}
	@Step
	public void my_system_print_out(float value){
	    System.out.println("total amount la:"+value);
	}
	
	@Step
	public void user_choose_option_pay_later() {
		acceptOfferPage.user_choose_option_pay_later();
	}
	
	@Step
	public void user_see_total_amount_of_pay_later() {
		acceptOfferPage.user_check_amount_pay_later();
		
	}
	
	@Step
	public void user_choose_option_pay_now() {
		acceptOfferPage.user_choose_option_pay_now();
		
	}
	
	@Step
	public void user_change_currency(String str_currency) {
		acceptOfferPage.change_user_currency(str_currency) ;
		
	}


	@Step
	public void user_choose_option_pay_now_with_credits() {
		acceptOfferPage.user_choose_option_pay_now_with_credits();
		
	}


	@Step
	public void user_accept_subsequent_offer() {
		acceptOfferPage.user_accept_subsequent_offer();
		
	}


	@Step
	public void user_check_sub_total_amount_to_pay_now() {
		acceptOfferPage.user_check_total_amount_to_pay_now();
		
	}


	@Step
	public void user_check_sub_total_amount_to_pay_later() {
		acceptOfferPage.user_check_total_amount_to_pay_later();
		
		
	}
	
	@Step
	public void i_need_print_out_saving_to_report(){
	    float s = acceptOfferPage.calculate_saving();
	    my_system_print_out(s);
	}
	
	
	

}
