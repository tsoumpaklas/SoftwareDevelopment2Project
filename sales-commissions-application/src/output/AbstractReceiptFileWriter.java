package output;

import java.io.File;
import data.Receipt;


public abstract class AbstractReceiptFileWriter {

	protected File fileToWrite;

	/*Receipt contains: receiptID, date, sales,
	  items, company, kind */
	protected Receipt receipt;

	protected void setFileToAppend(File fileToAppend) {
		this.fileToWrite = fileToAppend;
}


	//This is the template method 
	public final void receiptTemplate(){
		setFileToAppend(fileToWrite);
		createFile();
		writeToFile();
		
	}

	protected abstract void createFile();
	protected abstract void writeToFile();
	
}

