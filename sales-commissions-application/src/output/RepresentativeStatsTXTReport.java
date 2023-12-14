package output;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;




public class RepresentativeStatsTXTReport extends AbstractRepresentativeStatsReport {
	
    private BufferedWriter bufferedWriter;
    @Override
    protected void createFile() {
        try{
            bufferedWriter  = new BufferedWriter(new FileWriter(new File(fullPathName)));
        }catch(IOException e){
            JOptionPane.showMessageDialog(null, "Error creating file", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    protected void addContent() {
        try{
             bufferedWriter.write("Name:" + receiptManager.getName());
            writeEmptyLines(bufferedWriter, 1);

            bufferedWriter.write("AFM:" + receiptManager.getAfm());
            writeEmptyLines(bufferedWriter, 3);

            bufferedWriter.write("Total Sales:" + receiptManager.calculateTotalSales());
            writeEmptyLines(bufferedWriter, 1);

            String[] items = {"Trousers", "Skirts", "Shirts", "Coats"};
            for(String item: items){
                writeLine(bufferedWriter, item + "Sales: ", receiptManager.calculateSalesForEachItem(item));
            }

            bufferedWriter.write("Commision " +receiptManager.calculateCommission(receiptManager.calculateTotalSales()));
            bufferedWriter.close();

        }catch(IOException e){
            JOptionPane.showMessageDialog(null, "Error writing file", "Error", JOptionPane.ERROR_MESSAGE);
         }

    }

    private void writeEmptyLines(BufferedWriter bufferedWriter, int lines) throws IOException {
        for (int i = 0; i < lines; i++) {
            bufferedWriter.newLine();
        }
    }

    private void writeLine(BufferedWriter writer, String label, Object value) throws IOException {
        writer.write(label + value);
        writer.newLine();
    }




 }


