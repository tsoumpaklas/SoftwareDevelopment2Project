package output;

import java.io.File;

import data.Address;
import data.Receipt;


public abstract class AbstractReceiptFileWriter {

	protected File fileToWrite;

	/*Receipt contains: receiptID, date, sales,
	  items, company, kind */
	protected Receipt receipt;
	/*Address contains: country, city, street, streetNumber
	  and phoneNumber */
	protected Address address;

	protected void setFileToAppend(File fileToAppend) {
		this.fileToWrite = fileToAppend;
}


	//This is the template method 
	public final void appendFile(){
		createFile();
		writeFile();
		
	}

	protected abstract void createFile();
	protected abstract void writeFile();
	
}

