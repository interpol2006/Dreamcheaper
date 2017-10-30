package dreamcheaper.steps.serenity;

import org.junit.Assert;

import dreamcheaper.pages.AccountingSheetPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class AccountingSheetSteps extends ScenarioSteps {
	private static final long serialVersionUID = 1L;
	AccountingSheetPage accountingSheetpage ;
	AcceptOfferSteps acceptOfferSteps;
	
	@Step
	public void admin_search_trip(String tripID) {
		accountingSheetpage.open();
		waitABit(2000);
		accountingSheetpage.search_trip(tripID);
		waitABit(3000);
		
	}
	@Step
	public void admin_open_accounting_sheet()
	{
		accountingSheetpage.admin_open_accounting_sheet();
	}
	
	@Step
	public void admin_see_value_on_row(String strRow) {
		
		accountingSheetpage.check_calculator(strRow);

	}
	
	@Step
	public void my_system_print_out(double value){
	    System.out.println(value);
	}
	
	
	@Step
	public void print_value(String accountingPageField, String acc_total_price) {
		System.out.println("Value of: "+accountingPageField + "is" +acc_total_price );
		
	}
	
//	
}
