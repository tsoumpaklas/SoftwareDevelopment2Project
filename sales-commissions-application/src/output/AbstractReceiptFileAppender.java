package output;

import java.io.File;
import data.Receipt;
import data.ReceiptManager;


public abstract class AbstractReceiptFileAppender {

	protected File fileToAppend;

	/*Receipt contains: receiptID, date, sales,
	  items, company, kind */
	protected Receipt receipt;
	protected ReceiptManager receiptManager;  // Remove the semicolon here.


	protected void setFileToAppend(File fileToAppend, ReceiptManager receipt) {
		this.fileToAppend = fileToAppend;
		this.receipt = receipt.getLastReceipt();
	}

	//This is the template method 
	public final void receiptTemplate(File fileToAppend, ReceiptManager receipt){
		setFileToAppend(fileToAppend, receipt);
		appendToFile();
		
	}

	protected abstract void appendToFile();
	
}

