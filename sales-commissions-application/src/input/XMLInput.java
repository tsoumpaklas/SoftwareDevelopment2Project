package input;

import java.io.File;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;



public class XMLInput extends Input {

    public void readFile() {
        try {
        DocumentBuilderFactory documentBuilderFactory 
		= DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder
		= documentBuilderFactory.newDocumentBuilder();
		Document document = documentBuilder.parse(inputFile);
        document.getDocumentElement().normalize();

		NodeList nodeList = document.getElementsByTagName("Receipt");
			for (int i = 0; i < nodeList.getLength(); i++) {
				Element element = (Element) nodeList.item(i);
				name = element.getElementsByTagName("Name").item(0).getTextContent();
				afm = element.getElementsByTagName("Afm").item(0).getTextContent();
				addAgent();
				NodeList nodeList2 = element.getElementsByTagName("ReceiptID");
				for (int j = 0; j < nodeList2.getLength(); j++) {
					Element element2 = (Element) nodeList2.item(j);
					receiptID = Integer.parseInt(element2.getTextContent());
					date = element.getElementsByTagName("Date").item(j).getTextContent();
					kind = element.getElementsByTagName("Kind").item(j).getTextContent();
					sales = Integer.parseInt(element.getElementsByTagName("Sales").item(j).getTextContent());
					items = Integer.parseInt(element.getElementsByTagName("Items").item(j).getTextContent());
					companyName = element.getElementsByTagName("Company").item(j).getTextContent();
					companyCountry = element.getElementsByTagName("Country").item(j).getTextContent();
					companyCity = element.getElementsByTagName("City").item(j).getTextContent();
					companyStreet = element.getElementsByTagName("Street").item(j).getTextContent();
					companyStreetNumber = Integer.parseInt(element.getElementsByTagName("Number").item(j).getTextContent());
					addReceipt();
				}
			}
            
        } catch (Exception e) {
        	JOptionPane.showMessageDialog
			(null,"�������� ������ �������� ���� �� �������� ��� �������");
		} 
    }   
}


