package output;

import java.io.FileWriter;
import java.io.IOException;

public class TXTReceiptFileWriter extends AbstractReceiptFileWriter{

	private FileWriter fileWriter;
	


	@Override
	protected void writeToFile() {
		try {
			fileWriter = new FileWriter(fileToWrite);
			fileWriter.write("\n" + "Receipt ID: " + receipt.getReceiptID() + "\n");
			fileWriter.write("Date: " + receipt.getDate() + "\n");
			fileWriter.write("Kind: " + receipt.getKind() + "\n");
			fileWriter.write("Sales: " + receipt.getSales() + "\n");
			fileWriter.write("Items: " + receipt.getItems() + "\n");
			fileWriter.write("Company: " + receipt.getCompany().getName() + "\n");
			fileWriter.write("Country: " + receipt.getCompany().getAddress().getCountry() + "\n");
			fileWriter.write("City: " + receipt.getCompany().getAddress().getCity() + "\n");
			fileWriter.write("Street: " + receipt.getCompany().getAddress().getStreet() + "\n");
			fileWriter.write("Number: " + receipt.getCompany().getAddress().getStreetNumber() + "\n");
			fileWriter.write("\n");
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	


}
