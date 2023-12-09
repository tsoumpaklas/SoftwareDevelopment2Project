package output;

import data.ReceiptManager;

public abstract class AbstractRepresentativeStatsReport {

	protected ReceiptManager receiptManager;
	
	public abstract void saveFile();
}
