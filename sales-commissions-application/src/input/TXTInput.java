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

private List<String> values = new ArrayList<>();
private BufferedReader bufferedReader = null;

	@Override
	protected void initializeFileReader() {
        try {
            bufferedReader = new BufferedReader(new FileReader(inputFile));
        } catch (FileNotFoundException e) {
		JOptionPane.showMessageDialog(null, "Error in bufferedReader", "Error", JOptionPane.ERROR_MESSAGE);
        }
	}


	@Override
	protected void readAgent() {
		try {
			String Name[] = bufferedReader.readLine().trim().split(":");
			name = Name[1];
			String Afm[] = bufferedReader.readLine().trim().split(":");
			afm = Afm[1];

			addAgent();
		} catch (Exception e) {
		JOptionPane.showMessageDialog(null, "Format is not correct", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
    @Override
    public void readFile() {
		try{		
			while(true) {
				
				processReceiptLine(bufferedReader);
				
				System.out.println(values.toString());
				if (values.isEmpty()) {
					break;
				}
				
				fromListToVariables();
				addReceipt();
				
				values.clear();
			}
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "The file you have chosen is not a TXT file or it is empty", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void processReceiptLine(BufferedReader bufferedReader) {
    	try {
			String line = bufferedReader.readLine(); 
			while(line != null) {
				line = line.trim();
				if (!line.contains(":")) {
					line = bufferedReader.readLine();
					continue;
				}

				String[] parts = line.split(":");
				if (parts.length > 1) {
					String value = parts[1].trim(); 
					values.add(value);
				}

				if(parts[0].equals( "Number")) break;

				line = bufferedReader.readLine();
			}

		} catch (IOException e) {
			System.out.println(e.getMessage());
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


	public ReceiptManager getReceiptManager() {
		return receiptManager;
	}
	
}	
