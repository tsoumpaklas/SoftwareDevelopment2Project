package output;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

import data.ReceiptManager;



public class TXTReport extends Report{
    ReceiptManager manager = null;
	
	public TXTReport(ReceiptManager receiptManagerObj){
        manager = receiptManagerObj;
        manager = new ReceiptManager();
	}
	
	
	public void saveFile() {
        BufferedWriter bufferedWriter = null;
        try{
        	String fullPathName =  "/users/Nick/Desktop/Reports/" + manager.getAfm() + "_SALES.txt";
        	bufferedWriter = new BufferedWriter(new FileWriter(new File(fullPathName)));
            
        	bufferedWriter.write("Name: " + manager.getName()); 
            bufferedWriter.newLine();

            bufferedWriter.write("AFM: " + manager.getAfm());
            bufferedWriter.newLine();
            bufferedWriter.newLine();
            bufferedWriter.newLine();

            
            bufferedWriter.write("Total Sales: " + manager.calculateTotalSales());
            bufferedWriter.newLine();
 
            bufferedWriter.write("Trousers Sales: " + manager.calculateSalesForEachItem("Trousers"));
            bufferedWriter.newLine();

            bufferedWriter.write("Skirts Sales: " + manager.calculateSalesForEachItem("Skirts"));
            bufferedWriter.newLine();

            bufferedWriter.write("Shirts Sales: " + manager.calculateSalesForEachItem("Shirts"));
            bufferedWriter.newLine();
            
            bufferedWriter.write("Coats Sales: " + manager.calculateSalesForEachItem("Coats"));
            bufferedWriter.newLine();

            bufferedWriter.write("Commission: " + manager.calculateCommission(manager.calculateTotalSales()));
            
        	bufferedWriter.close();


        }catch (IOException ex){
			JOptionPane.showMessageDialog(null,"������ ������ �������� ���� ��� ���������� ��� �������");

        }
		
	}

}
