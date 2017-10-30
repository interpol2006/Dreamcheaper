package dreamcheaper.pages;

import java.text.DecimalFormat;
import java.util.List;

import javax.validation.constraints.AssertFalse;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.server.handler.interactions.MouseMoveToLocation;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("http://stage2.dreamcheaper.review/tower/login")
public class EditTripPage extends PageObject {

	@FindBy(xpath="//div/input[@placeholder='Username']")
	public
	WebElementFacade usernameField ;
	
	@FindBy(xpath="//div/input[@placeholder='Password']")
	WebElementFacade passwordField ;
	
	@FindBy(xpath="//div/button[@type='submit']")
	WebElementFacade loginBtn ;
	
	@FindBy(id="trip_id")
	WebElementFacade tripidField ;
	
	@FindBy(xpath="//div[@class='form-group form-group-sm']/button[@type='submit']")
	WebElementFacade searchBtn ;
	
	@FindBy(id="edit_trip_offer_price_currency")
	WebElementFacade dc_purchase_price_currency_field ;
	
	@FindBy(xpath="//div/table[@id='trips-grid']/tbody/tr[1]")
	WebElementFacade tripField ;
	
	@FindBy(xpath="//div/ul[@role='tablist']/li/a/span[text()='Booking No. 1']")
	WebElementFacade bookingNoField ;
	
	@FindBy(xpath="//div[@id='uniform-cKfKFfaO0']/span[1]")
	WebElementFacade radionbtnIcancel;
	
	@FindBy(xpath="//div[@class='tab-content']/div/span/button[@type='submit']")
	WebElementFacade btnSave ;
	
	@FindBy(id="preview-toggle")
	WebElementFacade btnHistory ;
	
	@FindBy(xpath="//div[@id='preview']/div[@class='mt-comments']/div[@class='mt-comment border-bottom-grey padding-bottom-20 margin-0'][last()]")
	WebElementFacade historyField ;
	
	@FindBy(id="edit_trip_offer_customer_payment_cost")
	WebElementFacade customer_payment_cost_field ;
	
	@FindBy(xpath="//input[@id='edit_trip_offer_cashback_amount']")
	WebElementFacade affiliateField ;
	
	@FindBy(id="edit_trip_offer_cashback_type")
	WebElementFacade cashbacktypeField;
	
	@FindBy(id="edit_trip_offer_free_nights_percent")
	WebElementFacade freenightField;
	
	@FindBy(id="edit_trip_offer_price_amount")
	WebElementFacade grossField ;
	
	@FindBy(id="edit_trip_offer_price_tax_amount")
	WebElementFacade includedtaxField ;
	
	@FindBy(id="edit_trip_offer_free_nights_used")
	WebElementFacade freenightusedField ;
	
	@FindBy(id="edit_trip_offer_customer_payment_price_in_eur")
	WebElementFacade gross_payment_field ;
	
	@FindBy(id="edit_trip_offer_dc_profit")
	public WebElementFacade dc_profit_field ;
	
	@FindBy(id="edit_trip_offer_dc_margin")
	public WebElementFacade dc_margin_field ;
	
	@FindBy(id="edit_trip_offer_original_customer_price_in_eur")
	public WebElementFacade initial_price_field ;
	
	@FindBy(id="edit_trip_offer_cashback_currency")
	WebElementFacade cashback_option ;
	
	@FindBy(id="edit_trip_offer_price_in_eur")
	WebElementFacade offer_price_in_eur ;
	
	@FindBy(id="edit_trip_offer_price_tax_currency")
	WebElementFacade included_tax_option ;
	
	@FindBy(xpath="//div/a[@class='btn btn-default']/i[@class='fa fa-plus']")
	WebElementFacade btn_create_offer ;
	
	@FindBy(xpath="//div/div[@class='btn-group']/button[@class='btn btn-primary']")
	WebElementFacade btn_SendOffer;
	
	@FindBy(id="edit_trip_offer_saving")
	WebElementFacade field_saving;
	
	@FindBy(xpath="//a[@class='btn btn-default']/i[@class='icon-paper-plane']")
	public WebElementFacade btn_rebook;
	
	@FindBy(id="edit_trip_offer_payment_date")
	public WebElementFacade field_DC_payment_date;
	
	@FindBy(id="edit_trip_offer_payment_method")
	public WebElementFacade field_DC_payment_method;
	
	@FindBy(id="edit_trip_trip_id")
	public WebElementFacade field_tripID;
	
	@FindBy(id="edit_trip_offer_original_customer_price_in_eur")
	public WebElementFacade ed_initialPriceinEur_field;
	
	@FindBy(id="edit_trip_offer_customer_payment_cost")
	public WebElementFacade ed_paymentCostinEur_field;
	
	@FindBy(id="edit_trip_state")
	public WebElementFacade field_trip_state;
	
	@FindBy(id="edit_trip_offer_saving_in_eur")
	public WebElementFacade ed_savinginEur_field;
	
	@FindBy(id="edit_trip_offer_customer_payment_price_amount")
	public WebElementFacade ed_ammountCharged_field;
	
	@FindBy(id="edit_trip_offer_customer_payment_price_in_eur")
	public WebElementFacade ed_grossPaymentinEur_field;
	
	@FindBy(id="edit_trip_offer_price_in_eur")
	public WebElementFacade ed_grossCostDC_field;
	
	
	
	
	
	public void open_edit_trip_page() {
		
		usernameField.sendKeys("admin@dreamcheaper.com");
		passwordField.sendKeys("n9HpMbTe1K4i");
		loginBtn.click();
	}

	public void find_a_booking(String tripID) {
		tripidField.sendKeys(tripID);
		searchBtn.click();
		tripField.click();
	}
	
	public void click_on_tab_booking_no() {
		bookingNoField.click();
		
	}
	
	public void choose_option_I_cancel() {
		radionbtnIcancel.click();
	}
	
	public void click_on_button_Save() {
		btnSave.click();
		
	}
	
	public void open_Trip_History() {
		btnHistory.click();
	}
	
	public String get_cancel_msg() {
		String msg = historyField.getText();
		return msg;
	}
	
	
	public String check_value_of_trip() {
		String str_affiliate = affiliateField.getAttribute("value") ;
		String str_freenight = freenightField.getAttribute("value");
		String str_gross_cost = grossField.getAttribute("value");
		String str_included_tax = includedtaxField.getAttribute("value");
		String str_freenight_used = freenightusedField.getAttribute("value");
		return str_affiliate;
	}
	public float get_dc_purchase_price_in_eur()
	{
		float dc_purchase_price_in_eur = 0.0f  ;
		if (dc_purchase_price_currency_field.getAttribute("value") == "EUR")
		{
			dc_purchase_price_in_eur = Float.parseFloat(grossField.getAttribute("value"));
		}
		else
		{
			dc_purchase_price_in_eur = Float.parseFloat(offer_price_in_eur.getAttribute("value"));
		}
		return dc_purchase_price_in_eur;
	}
	
	public float get_included_tax()
	{
		float included_tax_in_eur = 0.0f  ;
		float gross = get_dc_purchase_price_in_eur();
		
		if (included_tax_option.getAttribute("value") == "#")
		{
			included_tax_in_eur = Float.parseFloat(includedtaxField.getAttribute("value"));
		}
		else
		{
			included_tax_in_eur = gross*Float.parseFloat(includedtaxField.getAttribute("value"));
		}
		return included_tax_in_eur;
	}
	public float see_a_correct_Affiliate_earnings() {
		
		 float Affiliate =Float.parseFloat(affiliateField.getAttribute("value")) ;
		 float freenight = Float.parseFloat(freenightField.getAttribute("value")) ;
		 float gross_cost = get_dc_purchase_price_in_eur() ;
		 float included_tax = get_included_tax() ;
		 float freenight_used = Float.parseFloat(freenightusedField.getAttribute("value")) ;
		 float Affiliate_earnings = 0.0f ;
		
		if (cashback_option.getAttribute("value").equals("#"))
			{
				Affiliate_earnings = Affiliate;
			}
		else
		{
			if (cashbacktypeField.getAttribute("value").equals("pre-tax"))
			{
				Affiliate_earnings = (Affiliate + freenight)/100*(gross_cost - included_tax - freenight_used) ;
			}
			else
			{
				Affiliate_earnings = (Affiliate + freenight)/100*(gross_cost -  freenight_used) ;
			}
		}
		return Affiliate_earnings;
	
	}
	
	public float check_markup_in_Eur() {
		float  mark_up_in_Eur =Float.parseFloat(initial_price_field.getAttribute("value")) - Float.parseFloat(grossField.getAttribute("value")) ;
		return mark_up_in_Eur;
	}

	public float calculate_profit_after_all() {
		float gross = get_dc_purchase_price_in_eur();
		float gross_payment = Float.parseFloat(gross_payment_field.getAttribute("value")) ;
		float affiliate_earnings = see_a_correct_Affiliate_earnings();
		float payment_cost = Float.parseFloat(customer_payment_cost_field.getAttribute("value"));
		float profit_after_all = gross_payment + affiliate_earnings - gross - payment_cost ;
		float dc_profit = Float.parseFloat(dc_profit_field.getAttribute("value")) ;
		float y = (float) (Math.round(profit_after_all*100.00)/100.00) ;
		Assert.assertEquals(y, dc_profit, 0.01f);
		return y ;
	}
	
	public void check_profit_margin() {
		float profit_margin = calculate_profit_after_all()/Float.parseFloat(initial_price_field.getAttribute("value"))*100 ;
		float y = (float) (Math.round(profit_margin*100.00)/100.00) ;
		float dc_margin = Float.parseFloat(dc_margin_field.getAttribute("value"));
		Assert.assertEquals(y, dc_margin, 0.01f);
	}

	public void send_offer_to_customer() {
		waitForState("Options search done");
		btn_create_offer.click();
		waitABit(2000);
		btn_SendOffer.click();
		waitABit(2000);
	}

	public  List<EditTripPage> getPayments() {
		// TODO Auto-generated method stub
		return null;
	}
	public String get_data_from_text_field(String fieldName)
	{
		waitABit(5000);
		String value = null ;
					switch (fieldName)
					{
					case "ed_dcProfit": value =  dc_profit_field.getValue(); 
					return value;
					case "ed_dcMargin": value = dc_margin_field.getValue() ;
					return value;
					case "ed_initialPriceinEur": value = ed_initialPriceinEur_field.getValue();
					return value;
					
					case "ed_savinginEur": value =  ed_savinginEur_field.getValue(); 
					return value;
					case "ed_ammountCharged": value =  ed_ammountCharged_field.getValue(); 
					return value;
					case "ed_grossPaymentinEur": value =  ed_grossPaymentinEur_field.getValue(); 
					return value;
					case "ed_grossCostDC": value =  ed_grossCostDC_field.getValue(); 
					return value;
					case "ed_paymentCostinEur": value =  ed_paymentCostinEur_field.getValue(); 
					return value;
					
					}
		return "-" ;
	}
	
	public void scrollToElement(WebElement element ) {
		  evaluateJavascript("arguments[0].scrollIntoView(true);", element);
		}
	
	public void scrollTo(int x, int y) {
		  evaluateJavascript("window.scrollTo("+x+", "+y+");");
		}
	
	public void rebook_trip(String tripID) {
		if (field_tripID.getText().equalsIgnoreCase(tripID))
		{
		if (btn_rebook.isDisplayed())
		{
			field_DC_payment_date.type("2017/Dec/25");
			waitABit(2000);
			field_DC_payment_method.selectByIndex(1);
			waitABit(2000);
			scrollTo(70, 7);
			//scrollToElement(btn_rebook);
			
			btn_rebook.click();
			waitABit(5000);
		}
		else
		{
			System.out.println("Trip cannot be rebooked.");
		}
		}
		
	}

	public void waitForState(String tripState) {
		WebDriverWait wait = new WebDriverWait(getDriver(),300);
		wait.until(ExpectedConditions.textToBePresentInElement(field_trip_state, tripState));
	}

	

	

	

	

}
