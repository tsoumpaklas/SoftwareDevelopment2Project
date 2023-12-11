package data;

public class Receipt {
	protected int receiptId;
	protected String date;
	protected double sales;
	protected int items;
	protected Company company;
	protected String kind;
		
	
	public Receipt(String kind){
		this.kind = kind;
		company  = new Company();
	}
	
	
	public int getReceiptID() {
		return receiptId;
	}

	public void setReceiptID(int id) {
		this.receiptId = id;		
	}

	public String getDate() {
		return date;			
	}

	public void setDate(String date) {
		this.date = date;
	}

	public double getSales() {
		return sales;
	}

	
	public void setSales(double sales) {
		this.sales = sales;
	}
	
	public int getItems() {
		return this.items;
	}

	public void setItems(int items) {
		this.items = items;
	}
	
	public Company getCompany(){	
		return company;
	}

	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	
}
