package output;

import java.io.FileWriter;
import java.io.IOException;

public class TXTReceiptFileWriter extends AbstractReceiptFileWriter{

	private FileWriter fileWriter;
	
	@Override
	protected void createFile() {
		try {
			fileWriter = new FileWriter(fileToWrite);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void writeFile() {
		try {
			fileWriter.write("\n" + "Receipt ID: " + receipt.getReceiptID() + "\n");
			fileWriter.write("Date: " + receipt.getDate() + "\n");
			fileWriter.write("Kind: " + receipt.getKind() + "\n");
			fileWriter.write("Sales: " + receipt.getSales() + "\n");
			fileWriter.write("Items: " + receipt.getItems() + "\n");
			fileWriter.write("Company: " + receipt.getCompany().getName() + "\n");
			fileWriter.write("Country: " + address.getCountry() + "\n");
			fileWriter.write("City: " + address.getCity() + "\n");
			fileWriter.write("Street: " + address.getStreet() + "\n");
			fileWriter.write("Street Number: " + address.getStreetNumber() + "\n");
			fileWriter.write("Phone Number: " + address.getPhoneNumber()+ "\n");
			fileWriter.write("\n");
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	


}
