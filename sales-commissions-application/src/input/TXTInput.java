 package input;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class TXTInput extends AbstractInput {

    @Override
    public void readFile() {
        BufferedReader bufferedReader = initializeBufferedReader();
        readAgentDetails(bufferedReader);
		while(true) {
			processReceiptLine(bufferedReader);
			if (values.isEmpty()) {
				break;
    		}
			fromListToVariables();
			addReceipt();
			values.clear();
		}
	}

    private void readAgentDetails(BufferedReader bufferedReader) {
		try {
			name = bufferedReader.readLine();
			afm = bufferedReader.readLine();
			addAgent();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

    private BufferedReader initializeBufferedReader() {
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(inputFile));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return bufferedReader;
    }

	private List<String> values = new ArrayList<>();

	private void processReceiptLine(BufferedReader bufferedReader) {
    	try {
			String line = bufferedReader.readLine(); // Read the next line
			if (line != null) {
				String[] parts = line.split(": ");
				String value = parts[1]; // Get the second element
				values.add(value);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private void fromListToVariables() {
		receiptID = Integer.parseInt(values.get(0));
		date = values.get(1);
		kind = values.get(2);
		sales = Double.parseDouble(values.get(3));
		items = Integer.parseInt(values.get(4));
		companyName = values.get(5);
		companyCountry = values.get(6);
		companyCity = values.get(7);
		companyStreet = values.get(8);
		companyStreetNumber = Integer.parseInt(values.get(9));
	}

}	
