package data;

public class Receipt {
	private int receiptId;
	private String date;
	private double sales;
	private int items;
	private String kind;
	private Company company;
		
	public Receipt(String kind){
		this.kind = kind;
		company  = new Company();
	}
	
	public int getReceiptID() {
		return receiptId;
	}

	public String getDate() {
		return date;			
	}

	public double getSales() {
		return sales;
	}

	public int getItems() {
		return this.items;
	}
	
	public String getKind() {
		return kind;
	}

	public Company getCompany(){	
		return company;
	}



	public void setReceiptID(int id) {
		this.receiptId = id;		
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setSales(double sales) {
	this.sales = sales;
	}

	public void setItems(int items) {
		this.items = items;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}


	
	
}
