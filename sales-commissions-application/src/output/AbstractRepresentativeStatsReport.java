package output;

import data.ReceiptManager;

public abstract class AbstractRepresentativeStatsReport {

	protected ReceiptManager receiptManager;

	public void setReceiptManager(ReceiptManager receiptManager) {
		this.receiptManager = receiptManager;
	}
	public final void RepresentativeTemplateMethod(ReceiptManager receiptManager){
		setReceiptManager(receiptManager);
		saveFile();
	}
	public abstract void saveFile();
}
