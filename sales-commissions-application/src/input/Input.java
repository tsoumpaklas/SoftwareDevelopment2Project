package input;


import java.io.File;

import data.Receipt;
import data.ReceiptManager;

public abstract class Input {
	
	protected File inputFile;
	protected String inputFilePath;
	protected String name;
	protected String afm;
	//ReceiptManagerObject
	protected ReceiptManager receiptManager;

	public abstract void readFile();

	public Input() {
		receiptManager = new ReceiptManager();
		kind  = new String("");
	}
	

	
	public void addAgent() {
		receiptManager.setName(name);
		receiptManager.setAfm(afm);
	}
	
	public void addReceipt( ){
		Receipt receipt;			
			if(kind.equals("Shirts")) {
				receipt= new Shirt();

			}
			else if (kind.equals("Skirts")) {
				receipt = new Skirt();

			}
			else if (kind.equals("Trousers")) {
				receipt = new Trouser();

			}
			else {
				receipt = new Coat();
			}
			
			receipt.setReceiptID(receiptID);			
			receipt.setDate(date);
			receipt.setSales(sales);
			receipt.setItems(items);
			receipt.getCompany().setName(companyName);
			receipt.getCompany().getCompanyAddress().setCountry(companyCountry);
			receipt.getCompany().getCompanyAddress().setCity(companyCity);
			receipt.getCompany().getCompanyAddress().setStreet(companyStreet);
			receipt.getCompany().getCompanyAddress().setStreetNumber(companyStreetNumber);
			agent.getReceipts().add(receipt);
	}
	public Agent getAgent() {
		return agent;
	}

	
}
