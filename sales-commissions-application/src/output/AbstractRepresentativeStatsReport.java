package output;

import data.ReceiptManager;

public abstract class AbstractRepresentativeStatsReport {

	protected ReceiptManager receiptManager;

	protected void setReceiptManager(ReceiptManager receiptManager) {
		this.receiptManager = receiptManager;
	}
	public final void RepresentativeTemplateMethod(){
		setReceiptManager(receiptManager);
		saveFile();
	}
	public abstract void saveFile();
}
