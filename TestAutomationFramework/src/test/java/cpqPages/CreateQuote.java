package cpqPages;

public abstract class CreateQuote {
	
	abstract void enterQuoteName(String quoteName);
	abstract void selectSPAType(String spaType);
	abstract void selectDealType(String dealType);
	abstract void selectPurchasingChannel(String purchasingChannel);
	
	abstract void enterSoldToAccountNumber(String accountNumber);
    abstract void enterQuoteToAccountNumber(String accountNumber);
    abstract void clickOnSearchButton();
    abstract void selectAccount();
    
    abstract void selectContactNameFromAccount(String accountName);
    
    abstract void createContactFromContacts(String... contactDetails);
    
    abstract void addAttachments(String... attachments);
    abstract void addNotes(String...notes);
    
}
