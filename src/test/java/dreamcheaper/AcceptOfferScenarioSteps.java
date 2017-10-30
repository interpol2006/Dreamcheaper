package dreamcheaper;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dreamcheaper.pages.AcceptOfferPage;
import dreamcheaper.pages.OfferPage;
import dreamcheaper.pages.PaymentPage;
import dreamcheaper.steps.serenity.AcceptOfferSteps;
import dreamcheaper.steps.serenity.EditTripSteps;
import net.thucydides.core.annotations.Steps;

public class AcceptOfferScenarioSteps {

	@Steps
	AcceptOfferSteps acceptOfferSteps ;
	AcceptOfferPage acceptOfferpage ;
	OfferPage offerPage ;
	PaymentPage paymentPage ;
	@Given("^User accept offer$")
	public void user_accept_offer() throws Throwable {
		
		acceptOfferSteps.user_accept_offer();
	}
	
	
	
	@Then("^User should see total amount to \"([^\"]*)\"$")
    public void user_should_see_total_amount_to_something(String payment_method) throws Throwable {
        acceptOfferSteps.user_check_total_amount(payment_method);
        acceptOfferSteps.i_need_print_out_pay_now_fee_to_report();
        acceptOfferSteps.user_check_out();
    }
	
	 @When("^User choose option 'Pay Later'$")
	    public void user_choose_option_pay_later() throws Throwable {
	        acceptOfferSteps.user_choose_option_pay_later();
	    }
	 
	 @Then("^User should see total amount of 'Pay Later'$")
	    public void user_should_see_total_amount_of_Pay_later() throws Throwable {
	        acceptOfferSteps.user_see_total_amount_of_pay_later();
	        acceptOfferSteps.i_need_print_out_pay_later_fee_to_report();
	        acceptOfferSteps.user_check_out();
	    }
	 
	 @When("^User change currency to \"([^\"]*)\"$")
	 public void user_change_currency_to(String str_currency ) throws Throwable {
	     acceptOfferSteps.user_change_currency(str_currency);
	 }

	 @When("^User choose option 'Pay Now'$")
	 public void user_choose_option_Pay_Now() throws Throwable {
		 acceptOfferSteps.user_choose_option_pay_now();
		 
	 }
	 
	 @Then("^User should see total amount with credits to Pay Now$")
	 public void user_should_see_total_amount_with_credits_to_Pay_Now() throws Throwable {
	     acceptOfferSteps.user_choose_option_pay_now_with_credits();
	 }
	 
	 @Given("^User accept subsequent-offer$")
	 public void user_accept_subsequent_offer() throws Throwable {
	    acceptOfferSteps.user_accept_subsequent_offer();
	 }
	 
	 @Then("^User should see sub-total amount to 'Pay Now'$")
	 public void user_should_see_sub_total_amount_to_Pay_Now() throws Throwable {
	     acceptOfferSteps.user_check_sub_total_amount_to_pay_now();
	     acceptOfferSteps.i_need_print_out_saving_to_report();
	 }
	 
	 
	 
	 @Then("^User should see sub-total amount of 'Pay Later'$")
	 public void user_should_see_sub_total_amount_of_Pay_Later() throws Throwable {
		 acceptOfferSteps.user_check_sub_total_amount_to_pay_later();
		 acceptOfferSteps.i_need_print_out_saving_to_report();
	 }
}
