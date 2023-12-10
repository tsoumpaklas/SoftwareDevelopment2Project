package output;

import java.io.File;
import data.Receipt;
import data.ReceiptManager;


public abstract class AbstractReceiptFileWriter {

	protected File fileToWrite;

	/*Receipt contains: receiptID, date, sales,
	  items, company, kind */
	protected Receipt receipt;
	protected ReceiptManager receiptManager;

	protected void setFileToAppend(File fileToAppend, ReceiptManager receiptManager) {
		this.fileToWrite = fileToAppend;
		this.receiptManager = receiptManager;
		this.receipt = receiptManager.getReceipts().get(receiptManager.getReceipts().size() -1);
	}

	//This is the template method 
	public final void receiptTemplate(File fileToWrite){
		setFileToAppend(fileToWrite, receiptManager);
		writeToFile();
		
	}

	protected abstract void writeToFile();
	
}

