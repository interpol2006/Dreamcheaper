package dreamcheaper.pages;

import java.text.DecimalFormat;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("http://stage1.dreamcheaper.review/tower/login")
public class EditTripPage extends PageObject {

	@FindBy(xpath="//div/input[@placeholder='Username']")
	WebElement usernameField ;
	
	@FindBy(xpath="//div/input[@placeholder='Password']")
	WebElement passwordField ;
	
	@FindBy(xpath="//div/button[@type='submit']")
	WebElement loginBtn ;
	
	@FindBy(id="trip_id")
	WebElement tripidField ;
	
	@FindBy(xpath="//div[@class='form-group form-group-sm']/button[@type='submit']")
	WebElement searchBtn ;
	
	@FindBy(id="edit_trip_offer_price_currency")
	WebElement dc_purchase_price_currency_field ;
	
	@FindBy(xpath="//div/table[@id='trips-grid']/tbody/tr[1]")
	WebElement tripField ;
	
	@FindBy(xpath="//div/ul[@role='tablist']/li/a/span[text()='Booking No. 1']")
	WebElement bookingNoField ;
	
	@FindBy(xpath="//div[@id='uniform-cKfKFfaO0']/span[1]")
	WebElement radionbtnIcancel;
	
	@FindBy(xpath="//div[@class='tab-content']/div/span/button[@type='submit']")
	WebElement btnSave ;
	
	@FindBy(id="preview-toggle")
	WebElement btnHistory ;
	
	@FindBy(xpath="//div[@id='preview']/div[@class='mt-comments']/div[@class='mt-comment border-bottom-grey padding-bottom-20 margin-0'][last()]")
	WebElement historyField ;
	
	@FindBy(id="edit_trip_offer_customer_payment_cost")
	WebElement customer_payment_cost_field ;
	
	@FindBy(xpath="//input[@id='edit_trip_offer_cashback_amount']")
	WebElement affiliateField ;
	
	@FindBy(id="edit_trip_offer_cashback_type")
	WebElement cashbacktypeField;
	
	@FindBy(id="edit_trip_offer_free_nights_percent")
	WebElement freenightField;
	
	@FindBy(id="edit_trip_offer_price_amount")
	WebElement grossField ;
	
	@FindBy(id="edit_trip_offer_price_tax_amount")
	WebElement includedtaxField ;
	
	@FindBy(id="edit_trip_offer_free_nights_used")
	WebElement freenightusedField ;
	
	@FindBy(id="edit_trip_offer_customer_payment_price_in_eur")
	WebElement gross_payment_field ;
	
	@FindBy(id="edit_trip_offer_dc_profit")
	WebElement dc_profit_field ;
	
	@FindBy(id="edit_trip_offer_dc_margin")
	WebElement dc_margin_field ;
	
	@FindBy(id="edit_trip_offer_original_customer_price_in_eur")
	WebElement initial_price_field ;
	
	@FindBy(id="edit_trip_offer_cashback_currency")
	WebElement cashback_option ;
	
	@FindBy(id="edit_trip_offer_price_in_eur")
	WebElement offer_price_in_eur ;
	
	@FindBy(id="edit_trip_offer_price_tax_currency")
	WebElement included_tax_option ;
	
	@FindBy(xpath="//div/a[@class='btn btn-default']/i[@class='fa fa-plus']")
	WebElement btn_create_offer ;
	
	@FindBy(xpath="//div/div[@class='btn-group']/button[@class='btn btn-primary']")
	WebElement btn_SendOffer;
	
	@FindBy(id="edit_trip_offer_saving")
	WebElement field_saving;
	
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
		float dc_purchase_price_in_eur = 0  ;
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
		float included_tax_in_eur = 0  ;
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
		 float Affiliate_earnings = 0 ;
		
		if (cashback_option.getAttribute("value") == "#")
			{
				Affiliate_earnings = Affiliate;
			}
		else
		{
			if (cashbacktypeField.getAttribute("value") == "pre-tax")
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

	public float check_profit_after_all() {
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
		float profit_margin = check_profit_after_all()/Float.parseFloat(initial_price_field.getAttribute("value"))*100 ;
		float y = (float) (Math.round(profit_margin*100.00)/100.00) ;
		float dc_margin = Float.parseFloat(dc_margin_field.getAttribute("value"));
		Assert.assertEquals(y, dc_margin, 0.01f);
	}

	public void send_offer_to_customer() {
		btn_create_offer.click();
		btn_SendOffer.click();
	}

	public  List<EditTripPage> getPayments() {
		// TODO Auto-generated method stub
		return null;
	}

	

	

	

	

}
