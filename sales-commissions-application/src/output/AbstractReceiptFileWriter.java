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
		
	public abstract void appendFile();
	public abstract void setFileToAppend(File fileToAppend); 
	public abstract void setReceipt(Receipt receipt);
	public abstract void setA  vddress(Address address);
}

