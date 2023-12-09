package input;


import java.io.File;
import java.io.Reader;

import data.Receipt;
import data.ReceiptManager;

public abstract class AbstractInput {
	
	protected File inputFile;
	protected Reader inputFilePath;

	protected String name;
	protected String afm;
    protected String kind;
    protected String date;
    protected String companyName;
    protected String companyCountry;
    protected String companyCity;
	protected String companyStreet;	

	protected Integer receiptID;
    protected Integer items;
	protected Integer companyStreetNumber;

	protected Double sales;

	protected ReceiptManager receiptManager;

	public AbstractInput() {
		receiptManager = new ReceiptManager();
		kind = "";
	}
	
	
	public final void inputTemplate(File inputFile){
		fileInput(inputFile);
		readFile();
	}

	public void fileInput(File inputFile) {
		this.inputFile = inputFile;
		inputFile = inputFile.getAbsoluteFile();
	}
	public void addAgent() {
		receiptManager.setName(name);
		receiptManager.setAfm(afm);
	}
	
	public void addReceipt( ){
		Receipt receipt = new Receipt(kind);
		receipt.setReceiptID(receiptID);
		receipt.setDate(date);
		receipt.setSales(sales);
		receipt.setItems(items);
		receipt.getCompany().setName(companyName);
		receipt.getCompany().getAddress().setCountry(companyCountry);
		receipt.getCompany().getAddress().setCity(companyCity);
		receipt.getCompany().getAddress().setStreet(companyStreet);
		receipt.getCompany().getAddress().setStreetNumber(companyStreetNumber);
	}

	public abstract void readFile();

	public ReceiptManager getReceiptManager() {
		return receiptManager;
	}

	
}