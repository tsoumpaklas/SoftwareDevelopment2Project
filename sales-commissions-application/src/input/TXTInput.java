 package input;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import data.ReceiptManager;


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
			System.out.println("Name: " + name + " AFM: " + afm + "\n");
		} catch (IOException e) {
		JOptionPane.showMessageDialog(null, "Error in readAgentDetails", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

    private BufferedReader initializeBufferedReader() {
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(inputFile));
        } catch (FileNotFoundException e) {
		JOptionPane.showMessageDialog(null, "Error in bufferedReader", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return bufferedReader;
    }

	private List<String> values = new ArrayList<>();

	private void processReceiptLine(BufferedReader bufferedReader) {
    	try {
			String line = bufferedReader.readLine(); // Read the next line
			while (line != null) {
				// Skip empty lines or lines without ":"
				if (line.trim().isEmpty() || !line.contains(":")) {
					line = bufferedReader.readLine();
					continue;
				}
				String[] parts = line.split(": ");
				if (parts.length > 1) {
					String value = parts[1]; // Get the second element
					values.add(value);
				}
				line = bufferedReader.readLine();
			}

		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error in processReceiptLine", "Error", JOptionPane.ERROR_MESSAGE);
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

		System.out.println(receiptID + " " + date + " " + kind + " " + sales + " " + items + " " + companyName + " " + companyCountry + " " + companyCity + " " + companyStreet + " " + companyStreetNumber);

	}
	public ReceiptManager getReceiptManager() {
		return receiptManager;
	}
}	
