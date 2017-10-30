package dreamcheaper.models;

public class Accounting {
	private  final String accountingPageField ;//accountingPageField
	
	// tai sao co su khac nhau gia A va 
	private  final String editPageField ;
	
	public Accounting(String accountingPageField ,String editPageField )
	{
		this.accountingPageField = accountingPageField ;
		this.editPageField = editPageField ;
	}

	public String getAccountingPageField() {
		return this.accountingPageField;
	}

	public String getEditPageField() {
		return this.editPageField;
	}
}
