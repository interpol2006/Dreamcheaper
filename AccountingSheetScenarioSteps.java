package dreamcheaper;

import java.util.ArrayList;
import java.util.List;

import org.apache.tools.ant.taskdefs.Sleep;
import org.apache.tools.ant.taskdefs.WaitFor;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.typesafe.config.ConfigException.Parse;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dreamcheaper.models.Accounting;
import dreamcheaper.pages.AcceptOfferPage;
import dreamcheaper.pages.AccountingSheetPage;
import dreamcheaper.pages.EditTripPage;
import dreamcheaper.pages.OfferPage;
import dreamcheaper.pages.PaymentPage;
import dreamcheaper.steps.serenity.AcceptOfferSteps;
import dreamcheaper.steps.serenity.AccountingSheetSteps;
import dreamcheaper.steps.serenity.EditTripSteps;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Steps;

public class AccountingSheetScenarioSteps {
	
	@Steps
	AccountingSheetSteps accountingSheetSteps ;
	AcceptOfferPage acceptOfferPage ;
	AccountingSheetPage accountSheetpage ;
	EditTripPage editTripPage ;
	OfferPage offerPage ;
	PaymentPage paymentPage;
	
	
	@Given("^User click on button 'Pay\\.Save\\.Enjoy'$")
	public void user_click_on_button_Pay_Save_Enjoy() throws Throwable {
	   acceptOfferPage.btn_ProceedToCheckout.click();
		acceptOfferPage.user_click_on_btn_Pay_Save_enjoy();
	   acceptOfferPage.waitForAnyTextToAppear("Savings being secured…");
	}
	@Given("^User \"([^\"]*)\" log in to customer page$")
	public void user_log_in_to_customer_page(String email) throws Throwable {
	    
		acceptOfferPage.open();
		acceptOfferPage.user_login_page_with_email(email);
	}
	
	@Given("^Admin rebook trip \"([^\"]*)\"$")
	public void admin_rebook_trip(String tripID) throws Throwable {
	
		editTripPage.open();
		editTripPage.find_a_booking(tripID);
		editTripPage.rebook_trip(tripID);
	    editTripPage.waitForState("Options search done");
		
	}
	

	@When("^Admin search trip \"([^\"]*)\" on accounting sheet$")
	public void admin_search_trip_on_accounting_sheet(String tripID) throws Throwable {
	    
		accountingSheetSteps.admin_search_trip(tripID) ;
	}
	
	@Given("^User accept offer of trip \"([^\"]*)\"$")
	public void user_accept_offer_of_trip(String tripID) throws Throwable {
		acceptOfferPage.open();   
		acceptOfferPage.user_accept_offer_of_trip(tripID);
		offerPage.btn_ProceedToCheckout.click();
	    paymentPage.btn_Pay_Save_Enjoy.click();
	} 
	
		@Given("^User accept sub-sequent offer of trip \"([^\"]*)\"$")
		 public void user_accept_sub_sequent_offer_of_trip(String tripID) throws Throwable {
			 acceptOfferPage.user_accept_offer_of_trip(tripID);
			 offerPage.button_continue_offer_page.click();
		 }
	
	@Then("^Admin should see correct values on \"([^\"]*)\" row$")
    public void admin_should_see_correct_values_on_something_row(String strRow) throws Throwable {
        accountingSheetSteps.admin_see_value_on_row(strRow);
        double profit_db = accountSheetpage.calculate_total_profit(strRow);
		accountingSheetSteps.my_system_print_out(profit_db);
    }
	
	
	List<Accounting> accounting= new ArrayList<Accounting>();
	

	@Then("^Admin see data on Accounting sheet matched with Edit Trip on trip \"([^\"]*)\"$")
	public void admin_see_data_on_Accounting_sheet_matched_with_Edit_Trip_on_trip(String tripID, DataTable accountingSheet) throws Throwable {
//		accountSheetpage.open();
//		accountSheetpage.search_trip(tripID);
		
		accounting = accountingSheet.asList(Accounting.class) ;
		for (Accounting a:accounting )
		{
			 
			double total1 = 0;
			String edit_total_price = null;
			editTripPage.open();
			editTripPage.find_a_booking(tripID);
			
			 edit_total_price = editTripPage.get_data_from_text_field( a.getEditPageField()) ;
			 total1 = Double.parseDouble(edit_total_price);
			
			
			accountSheetpage.open();
			accountSheetpage.search_trip(tripID);
			
			
			String acc_total_price = accountSheetpage.get_data_from_row_and_column("final", a.getAccountingPageField()).replace(".","").replace(",", ".") ;
			double total  = Double.parseDouble(acc_total_price);
			
			accountingSheetSteps.print_value(a.getAccountingPageField(),acc_total_price );
			//Assert.assertEquals(acc_total_price, edit_total_price);
			Assert.assertEquals(total, total1, 0.01d);
		}
		
		
	}



}
