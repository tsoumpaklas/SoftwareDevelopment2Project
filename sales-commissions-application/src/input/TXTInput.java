 package input;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;



public class TXTInput extends Input{
	@Override
	public void fileInput(File inputFile) {
		super.fileInput(inputFile);
	}
	
	@Override
	public void readFile() {
		BufferedReader bufferedReader = null;

		try {
			bufferedReader  = new BufferedReader(new FileReader(inputFile));
		} catch (FileNotFoundException firstException) {
			firstException.printStackTrace();
			}

			String line;
			try	{
				while ((line = bufferedReader.readLine()) != null) {
					String[] parts = line.split(" ");
					if (parts[0].equals("Agent:")) {
						name = parts[1];
						afm = parts[2];
					}
					else if (parts[0].equals("Receipt:")) {
						receiptID = Integer.parseInt(parts[1]);
						date = parts[2];
						sales = Integer.parseInt(parts[3]);
						items = Integer.parseInt(parts[4]);
						companyName = parts[5];
						companyCountry = parts[6];
						companyCity = parts[7];
						companyStreet = parts[8];
						companyStreetNumber = Integer.parseInt(parts[9]);
					}
					else if (parts[0].equals("Kind:")) {
						kind = parts[1];
					}
				}
			} catch (IOException secondException) {
				secondException.printStackTrace();
			}
				
			try{
				bufferedReader.close();
			} catch (IOException thirdException) {
				thirdException.printStackTrace();
			}

	}	

}