package output;

import java.io.File;
import data.Receipt;
import data.ReceiptManager;


public abstract class AbstractReceiptFileAppender {
	
	public void setFileToAppend(File fileToAppend) {
		this.fileToAppend = fileToAppend;
	}
	protected File fileToAppend;

	/*Receipt contains: receiptID, date, sales,
	  items, company, kind */
	protected Receipt receipt;
	protected ReceiptManager receiptManager;  // Remove the semicolon here.


	//This is the template method 
	public final void receiptTemplate(File fileToAppend, ReceiptManager receiptManager){
			receipt = receiptManager.getLastReceipt();
			//System.out.println(receipt.getReceiptID());
			appendToFile();
		
	}
	protected abstract void appendToFile();
	
}

