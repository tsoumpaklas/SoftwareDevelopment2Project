package output;

import data.ReceiptManager;

public abstract class AbstractRepresentativeStatsReport {

	protected ReceiptManager receiptManager;

	public void setReceiptManager(ReceiptManager receiptManager) {
		this.receiptManager = receiptManager;
	}
	public final void RepresentativeTemplateMethod(ReceiptManager receiptManager){
		setReceiptManager(receiptManager);
		createFile();
		addContent();
	}
	protected abstract void createFile();
	protected abstract void addContent();
}
