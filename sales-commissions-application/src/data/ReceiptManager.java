package data;


import java.util.ArrayList;
import java.util.List;

import output.AbstractReceiptFileWriter;
import output.TXTReceiptFileWriter;
import output.XMLReceiptFileWriter;

public class  ReceiptManager{
	private String name;
	private String afm;
    private List <Receipt> allReceipts;
	private AbstractReceiptFileWriter ReceiptFileWriter;
	
	
	public ReceiptManager(){
		allReceipts = new ArrayList<>();
	}
	
	public void setFileType(String fileType) {
		if(fileType.equals("TXT")) {
			ReceiptFileWriter = new TXTReceiptFileWriter();
		}	
		else {
			ReceiptFileWriter = new XMLReceiptFileWriter();
		}	
	}

	public float calculateSalesForEachItem(String kind) {
		float sumOfSpecificKind = 0;
		for(int i = 0; i< allReceipts.size(); i++){
			if(allReceipts.get(i).getKind().equals(kind)){
				sumOfSpecificKind += allReceipts.get(i).getItems();
			}
		}

		return sumOfSpecificKind;
	}
	

	public double calculateTotalSales(){
		double sumSales = 0;
		for(int i = 0; i< allReceipts.size(); i++){
			sumSales += allReceipts.get(i).getSales();
		}

		return sumSales;
	}
	

	public int calculateTotalItems(){
		int sumItems = 0;
		for(int i = 0; i< allReceipts.size(); i++){
			sumItems += allReceipts.get(i).getItems();
		}

		return sumItems;
	}

	public double calculateCommission(int totalSales) {
		if (totalSales > 6000 && totalSales <= 10000) {
			return 0.1 * (totalSales - 6000);
		}
	    else if (totalSales > 10000 && totalSales <= 40000) {
			return ((totalSales - 10000) * 0.15) + (10000 * 0.1);
		} 	
		else if (totalSales > 40000) {
			return 10000 * 0.1 + 30000 * 0.15 + (totalSales - 40000) * 0.2;
		}

		return 0;
	}


	public List<Receipt> getReceipts() {
		return allReceipts;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAfm() {
		return afm;
	}

	public void setAfm(String afm) {
		this.afm = afm;
	}

	public AbstractReceiptFileWriter getFileAppender() {
		return ReceiptFileWriter;
	}

}
