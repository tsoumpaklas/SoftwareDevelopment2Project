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
	
	//This is the template method 
	public void appendFile(){
		setFileToAppend(fileToWrite);
		openFile();
		writeData();
		closeFile();
	}
	public abstract void openFile();
	public abstract void writeData();
	public abstract void closeFile();
	public abstract void setFileToAppend(File fileToAppend); 
	public abstract void setReceipt(Receipt receipt);
	public abstract void setAddress(Address address);
}

