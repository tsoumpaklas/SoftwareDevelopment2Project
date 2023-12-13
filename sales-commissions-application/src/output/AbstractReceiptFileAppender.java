package output;

import java.io.File;
import data.Receipt;
import data.ReceiptManager;


public abstract class AbstractReceiptFileAppender {
	
	public void setFileToAppend(File fileToAppend) {
		this.fileToAppend = fileToAppend;
	}
	protected File fileToAppend;
	protected Receipt receipt;
	protected ReceiptManager receiptManager;  
 
	public final void receiptTemplate(File fileToAppend, ReceiptManager receiptManager){
			receipt = receiptManager.getLastReceipt();
			initializeAppender();
			appendToFile();
		
	}
	
	protected abstract void initializeAppender();
	protected abstract void appendToFile();
	
}

