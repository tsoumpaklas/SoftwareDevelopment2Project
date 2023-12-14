package output;

import data.ReceiptManager;

public abstract class AbstractRepresentativeStatsReport {

	protected ReceiptManager receiptManager;
	protected String fullPathName;

	public void setReceiptManager(ReceiptManager receiptManager) {
		this.receiptManager = receiptManager;
	}

	public void setFullPathName(String fullPathName) {
		this.fullPathName = fullPathName;
	}
	
	public final void RepresentativeTemplateMethod(ReceiptManager receiptManager){
		setReceiptManager(receiptManager);
		createFile();
		addContent();
	}

	protected abstract void createFile();
	protected abstract void addContent();
}
