package dreamcheaper.pages;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;


@DefaultUrl("http://stage2.dreamcheaper.review/tower/balance-sheets")

	

public class AccountingSheetPage extends PageObject {
	
	AcceptOfferPage acceptOfferPage ;
	EditTripPage editTripPage ;
	@FindBy(id="trip_id")
	WebElementFacade tripidField;
	
	@FindBy(xpath="//button[@class='btn btn-primary btn-sm']")
	WebElementFacade searchBtn;
	
	@FindBy(xpath="//div//a[@href='/login']")
	WebElementFacade tripField;
	
	@FindBy(id="balance-sheet-grid")
	WebElementFacade tableAccounting;
	
	public void search_trip(String tripID) {
		
			tripidField.type(tripID);
			searchBtn.click();
			
		
		
	}

	public int get_row(String strRow) {
		int row = 0;
		List<WebElement> rows_table=tableAccounting.findElements(By.tagName("tr"));
		int rows_count = rows_table.size();
		for (row=0;row<rows_count;row++){
			String sValue = null;
			int a = row+ 1;
			sValue = getDriver().findElement(By.xpath("//table[@id='balance-sheet-grid']/tbody/tr[" + a + "]/td")).getText();
				if(sValue.equalsIgnoreCase(strRow))
				{
					return a;
				}
				
	}
		return -1 ;
	}
	
	public String get_data_from_row_and_column(String strRow , String strColumn)
	{
		int row ;
		List<WebElement> rows_table=tableAccounting.findElements(By.tagName("tr"));
		int rows_count = rows_table.size();
		for (row=1;row<rows_count;row++){
			String sValue = null;
			//int a = row + 1 ;
			sValue = getDriver().findElement(By.xpath("//table[@id='balance-sheet-grid']/tbody/tr[" + row  + "]/td")).getText();
				if(sValue.equalsIgnoreCase(strRow))
				{
					waitABit(2000);
					String value = null;
					switch (strColumn)
					{
					case "acc_profit": value =  getDriver().findElement(By.xpath("//table[@id='balance-sheet-grid']/tbody/tr[" + row + "]/td[37]")).getText();
					return value;
					case "acc_margin": value = getDriver().findElement(By.xpath("//table[@id='balance-sheet-grid']/tbody/tr[" + row + "]/td[38]")).getText();
					return value;
					case "acc_initialPriceinEur": value = getDriver().findElement(By.xpath("//table[@id='balance-sheet-grid']/tbody/tr[" + row + "]/td[11]")).getText();
					return value;
					
					case "acc_savinginEUR": value = getDriver().findElement(By.xpath("//table[@id='balance-sheet-grid']/tbody/tr[" + row + "]/td[13]")).getText();
					return value;
					case "acc_amountCharged": value = getDriver().findElement(By.xpath("//table[@id='balance-sheet-grid']/tbody/tr[" + row + "]/td[16]")).getText();
					return value;
					case "acc_grossPaymentinEur": value = getDriver().findElement(By.xpath("//table[@id='balance-sheet-grid']/tbody/tr[" + row + "]/td[18]")).getText();
					return value;
					case "acc_grossCostDC": value = getDriver().findElement(By.xpath("//table[@id='balance-sheet-grid']/tbody/tr[" + row + "]/td[24]")).getText();
					return value;
					case "acc_paymentCostinEur": value = getDriver().findElement(By.xpath("//table[@id='balance-sheet-grid']/tbody/tr[" + row + "]/td[19]")).getText();
					return value;   
					case "acc_dcFeeinEur": value = getDriver().findElement(By.xpath("//table[@id='balance-sheet-grid']/tbody/tr[" + row + "]/td[29]")).getText();
					return value;
					case "acc_payLaterFeeinEur": value = getDriver().findElement(By.xpath("//table[@id='balance-sheet-grid']/tbody/tr[" + row + "]/td[30]")).getText();
					return value;
					
					}
				}
				
	}
		return "-" ;
	}
	
	public String get_value_from_column(int strRow, String strcolumn) {
		String value = null;
		switch (strcolumn)
		{
		case "profit": value =  getDriver().findElement(By.xpath("//table[@id='balance-sheet-grid']/tbody/tr[" + strRow + "]/td[37]")).getText();
		return value;
		case "margin": value = getDriver().findElement(By.xpath("//table[@id='balance-sheet-grid']/tbody/tr[" + strRow + "]/td[38]")).getText();
		return value;
		case "initial_price": value = getDriver().findElement(By.xpath("//table[@id='balance-sheet-grid']/tbody/tr[" + strRow + "]/td[11]")).getText();
		return value;
		}
		return "-";
	}

	public void admin_open_accounting_sheet() {
		// TODO Auto-generated method stub
		
	}

	public double calculate_total_profit(String strRow) {
		int row = get_row(strRow);
		double customer_price =  Double.parseDouble(getDriver().findElement(By.xpath("//table[@id='balance-sheet-grid']/tbody/tr[" + row + "]/td[18]")).getText().replace(".","").replace(",", "."));
		double affiliate_earnings = Double.parseDouble(getDriver().findElement(By.xpath("//table[@id='balance-sheet-grid']/tbody/tr[" + row + "]/td[35]")).getText().replace(".","").replace(",", "."));
		double gross_cost = Double.parseDouble(getDriver().findElement(By.xpath("//table[@id='balance-sheet-grid']/tbody/tr[" + row + "]/td[24]")).getText().replace(".","").replace(",", "."));
		double payment_cost = Double.parseDouble(getDriver().findElement(By.xpath("//table[@id='balance-sheet-grid']/tbody/tr[" + row + "]/td[19]")).getText().replace(".","").replace(",", "."));
		
		double profit_after_all = customer_price + affiliate_earnings - gross_cost - payment_cost ;
		double y = (double) (Math.round(profit_after_all*100.00)/100.00) ;
		return y;
	}

	public double calculate_profit_margin(String strRow) {
		int row = get_row(strRow);
		double profit_after_all =  Double.parseDouble( get_value_from_column(row, "profit").replace(".","").replace(",", "."));
		double initial_price =  Double.parseDouble(get_value_from_column(row, "initial_price").replace(".","").replace(",", "."));
		double margin = (profit_after_all/initial_price)*100;
		double y = (double) (Math.round(margin*100.00)/100.00) ;
		return y;
	}

	public void check_calculator(String strRow) {
		String profit = get_data_from_row_and_column(strRow, "acc_profit");
		double profit_db = calculate_total_profit(strRow);
		double total_profit = Double.parseDouble(profit.replace(".","").replace(",", "."));
		Assert.assertEquals(total_profit, profit_db, 0.01d);
		
		String profit_margin = get_data_from_row_and_column(strRow, "acc_margin");
		double margin = calculate_profit_margin(strRow);
		double margin_profit = Double.parseDouble(profit_margin.replace(".","").replace(",", "."));
		Assert.assertEquals(margin, margin_profit, 0.01d);
		
		
		
	}

	


}