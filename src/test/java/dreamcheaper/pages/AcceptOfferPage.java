package dreamcheaper.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.junit.Assert;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.List;

@DefaultUrl("http://stage2.dreamcheaper.review")
public class AcceptOfferPage extends PageObject {
	
	EditTripPage editPage;
	
	@FindBy(xpath="//div//a[@href='/login']")
	WebElement btn_Login;
	
	@FindBy(xpath="//div/input[@type='email']")
	WebElement field_customername;
	
	@FindBy(xpath="//div/input[@type='password']")
	WebElement field_customerpassword;
	
	@FindBy(xpath="//div/button[@type='submit']")
	WebElement btn_clicktologin;
	@FindBy(xpath="//span[text()='Confirm your saving']")
	WebElement btn_ConfirmYourSaving;
	
	@FindBy(xpath="//span[text()='Proceed to checkout']")
	WebElement btn_ProceedToCheckout;
	
	@FindBy(xpath="//span[text()='Pay now']")
	WebElement option_PayNow ;
	
	@FindBy(xpath="//div[@class='RadioCards_cardItem_29ybl']/div/input[@type='radio']")
	WebElementFacade option_PayLater ;
	
	@FindBy(xpath="//button[text()='Pay. Save. Enjoy.']")
	WebElement btn_Pay_Save_Enjoy;
	
	@FindBy(xpath="//div[@class='TripPriceListing_highlightedRow_1s7PU']/span[@class='TripPriceListing_figureAmount_39ggd']")
	WebElement field_Savings ;
	
	@FindBy(xpath="//div[@class='Payment_offerPriceListingContainer_39CzT']/div[2]/div[2]/span[2]")
	WebElement field_saving_accept_page ;
	
	@FindBy(xpath="//div[@class='Payment_offerPriceListingContainer_39CzT']/div[3]/div[1]/span[2]")
	WebElement field_hotel_price_accept_page ;
	
	@FindBy(xpath="//div[@class='Payment_offerPriceListingContainer_39CzT']/div[3]/div[2]/span[2]")
	WebElement field_service_fee_accept_page ;
	
	@FindBy(xpath="//div[@class='Payment_highlightedPriceListingRow_2ExYP']/span[2]")
	public WebElement field_total_pay_now_accept_page ;
	
	@FindBy(xpath="//div[@class='Payment_priceListingSection_2h2k9']/div[3]/span[2]")
	WebElement field_pay_later_fee ;
	
	@FindBy(xpath="//div[@class='Payment_highlightedPriceListingRow_2ExYP']/span[2]")
	WebElement field_total_pay_later_fee_accept_page ;
	
	@FindBy(xpath="//div[@class='Grid_col-align-top_63YvX Grid_col-xs-6_1wwsn Grid_col-md-3_d6XMV Grid_col-lg-2_Ao39H']/div[@class='Select_select_3IMrR Select_select--dark_3E5_Q']/input[@class='Select_selectInput_-41Fz']")
	WebElementFacade option_currency ;
	
	@FindBy(xpath="//div[@class='Payment_priceListingSection_2h2k9']/div[3]/span[2]/span")
	WebElementFacade field_credits_offer_page_pay_now;
	
	@FindBy(xpath="//div[@class='Payment_priceListingSection_2h2k9']/div[4]/span[2]")
	WebElementFacade field_credits_offer_page_pay_later;
	
	@FindBy(xpath="//div[@class='Offer_offerPreviewBox_161pa']/button[@class='Button_Button_2hBfs Button_button--layout-call-to-action_pCVlz']")
	WebElementFacade button_continue_offer_page;
	
	@FindBy(xpath="//div[@class='Offer_offerPreviewBox_161pa']/div[@class='TripPriceListing_TripPriceListing_15PeM']/div[4]/span[2]/span")
	WebElementFacade field_current_price;
	
	@FindBy(xpath="//div[@class='Offer_offerPreviewBox_161pa']/div[@class='TripPriceListing_TripPriceListing_15PeM']/div[3]/span[2]/del/span")
	WebElementFacade field_new_price;
	
	@FindBy(xpath="//div[@class='Offer_offerPreviewBox_161pa']/div[@class='TripPriceListing_TripPriceListing_15PeM']/div[1]/span[2]/span")
	WebElementFacade field_saving_price;
	
	public void user_login_page()
	{
		getDriver().navigate().to("http://stage2.dreamcheaper.review/");
		btn_Login.click();
		field_customername.sendKeys("tri50@yahoo.com");
		field_customerpassword.sendKeys("1234");
		btn_clicktologin.click();
		
	}
	
	public void user_accept_offer() {
		user_login_page();
		btn_ConfirmYourSaving.click();
		btn_ProceedToCheckout.click();
	}

	

	public void user_check_saving()
	{
		float saving = Float.parseFloat(field_Savings.getText().replaceAll("[-CA$€SGD]","")) ;
		//editPage.l
//		String admin_saving = editPage.field_saving.getAttribute("value");
//		Assert.assertEquals(customer_saving, admin_saving, 0.01f);
//		assertThat(customer_saving, equalTo("€"+admin_saving));
	}
	
	public void user_check_payment() {
		
	}
	
	public float calculate_pay_now_fee()
	{
		
		float new_hotel_price = get_price_from_text(field_hotel_price_accept_page);		
		float service_fee = get_price_from_text(field_service_fee_accept_page);	
			
		WebElement credit_field = getDriver().findElement(By.xpath("//div[@class='Payment_priceListingSection_2h2k9']/div[3]/span[1]"));
		String s = credit_field.getText();
		if (s.contains("Credits"))
		{
			float credits = get_price_from_text(field_credits_offer_page_pay_now);	
			float y = (float) (Math.round((new_hotel_price+service_fee-credits)*100.00)/100.00) ;
			return y ;
		}
		else
		{
		 float y = (float) (Math.round((new_hotel_price+service_fee)*100.00)/100.00) ;
		 return y ;
		}
		
	}
	
	public void user_check_total_amount(String payment_method) {
		float y = calculate_pay_now_fee();
		float total_pay_now = get_price_from_text(field_total_pay_now_accept_page);	
		Assert.assertEquals(y, total_pay_now, 0.00f);
		//btn_Pay_Save_Enjoy.click();
		}

	
	
	
	
	public float get_price_from_text(WebElement e)
	{
		float price = Float.parseFloat(e.getText().replaceAll("[-CA$€SGD]","")) ;
		return price ;
	}
	

	

	public void print_total_amount(String msg) {
		
		System.out.println("gia tri can in ra la"+msg);
	}

	public void user_choose_option_pay_later() {
		option_PayLater.click();
		
	}
	
	public float calculate_pay_later_fee()
	{
		float new_hotel_price = get_price_from_text(field_hotel_price_accept_page);		
		float service_fee = get_price_from_text(field_service_fee_accept_page);	
		float pay_later_fee = get_price_from_text(field_pay_later_fee);
		WebElement credit_field = getDriver().findElement(By.xpath("//div[@class='Payment_priceListingSection_2h2k9']/div[4]/span[1]"));
		String s = credit_field.getText();
		if (s.contains("Credits"))
		{
			float credits = get_price_from_text(field_credits_offer_page_pay_later);	
			float y = (float) (Math.round((new_hotel_price+service_fee+pay_later_fee-credits)*100.00)/100.00);
			return y;
		}
		else
		{
			float y = (float) (Math.round((new_hotel_price+service_fee+pay_later_fee)*100.00)/100.00);
			return y;
		}
	}
	
	public void user_check_amount_pay_later() {
		
		float y = calculate_pay_later_fee();
		float total_pay_later = get_price_from_text(field_total_pay_later_fee_accept_page);
			 
			Assert.assertEquals(y, total_pay_later, 0.00f);
			
		
		
	}

	public void user_choose_option_pay_now() {
		option_PayNow.click();
		
	}

	public void change_user_currency(String str_currency) {
		option_currency.click();
//		 List<WebElement> options = getDriver().findElements(By.xpath("//div[@class='Grid_col-align-top_63YvX Grid_col-xs-6_1wwsn Grid_col-md-3_d6XMV Grid_col-lg-2_Ao39H']/div[@class='Select_select_3IMrR Select_select--dark_3E5_Q']/div[@class='Select_selectList_3xPCP']/ul/li"));
//	        // Loop through the options and select the one that matches
//	        for (WebElement opt : options) {
//	            if (opt.getAttribute("data-value").equals(str_currency)) {
//	                opt.click();
//	                return;
//	            }
//	}
		WebElement currency = getDriver().findElement(By.xpath("//div[@class='Select_selectList_3xPCP']/ul/li[@data-value='"+str_currency+"']"));
        currency.click();

	}

	public void user_choose_option_pay_now_with_credits() {
		
		
	}

	public void user_accept_subsequent_offer() {
		user_login_page();
		btn_ConfirmYourSaving.click();
	}
	
	public float calculate_saving()
	{
		float current_price = get_price_from_text(field_current_price);
		float new_price = get_price_from_text(field_new_price);
		float saving = current_price - new_price ;
		return saving ;
	}
	
	public void user_check_total_amount_to_pay_now() {
		float y = calculate_saving();
		float saving = get_price_from_text(field_saving_price);
		if (y > 0)
		{
			Assert.assertEquals(y, saving, 0.00f);
		}
		
		
	}

	public void user_check_total_amount_to_pay_later() {
		float y = calculate_saving();
		float saving = get_price_from_text(field_saving_price);
		
		
			Assert.assertEquals(y, saving, 0.00f);
		
		
		
	}
}

	
	

