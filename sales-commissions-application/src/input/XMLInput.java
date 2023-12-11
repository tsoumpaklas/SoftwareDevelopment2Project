package input;

import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;



public class XMLInput extends AbstractInput {            
	public void readFile() {
		try{
        	DocumentBuilderFactory docBuilderFactory 
			= DocumentBuilderFactory.newInstance();
        	DocumentBuilder docBuilder
			= docBuilderFactory.newDocumentBuilder();
        	Document doc = docBuilder.parse(inputFile);
        	 
        	doc.getDocumentElement().normalize();
			NodeList agentNodeList = doc.getElementsByTagName("Agent");			
		

			processAgent(agentNodeList);

			NodeList receiptsNodeList = ((Element) agentNodeList.item(0)).getElementsByTagName("Receipt");
			int size = receiptsNodeList.getLength();
			System.out.println("I AM GOOD");
			for (int i = 0; i < size; i++) {
				processReceiptData(receiptsNodeList, i);
				processCompanyData(receiptsNodeList, i);
				addReceipt();
				System.out.println("What is happening?");
				}
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error reading XML file", "Error", JOptionPane.ERROR_MESSAGE);
			}
	}

	private void processAgent(NodeList agentNodeList) {
		name = ((Element) agentNodeList.item(0)).getElementsByTagName("Name").
		item(0).getChildNodes().item(0).getNodeValue().trim();

		afm = ((Element) agentNodeList.item(0)).getElementsByTagName("AFM").
		item(0).getChildNodes().item(0).getNodeValue().trim();

		addAgent();
	}

	private void processReceiptData(NodeList receiptsNodeList, int i) {
		receiptID = Integer.parseInt(((Element) receiptsNodeList.item(i)).getElementsByTagName("ReceiptID").
		item(0).getChildNodes().item(0).getNodeValue().trim());

		date = ((Element) receiptsNodeList.item(i)).getElementsByTagName("Date").
		item(0).getChildNodes().item(0).getNodeValue().trim();

		kind = ((Element) receiptsNodeList.item(i)).getElementsByTagName("Kind").
		item(0).getChildNodes().item(0).getNodeValue().trim();

		sales = Double.parseDouble(((Element) receiptsNodeList.item(i)).getElementsByTagName("Sales").
		item(0).getChildNodes().item(0).getNodeValue().trim());

		items = Integer.parseInt(((Element) receiptsNodeList.item(i)).getElementsByTagName("Items").
		item(0).getChildNodes().item(0).getNodeValue().trim());

		addReceipt();
	}
	
	private void processCompanyData(NodeList receiptsNodeList, int i){
		companyName = ((Element) receiptsNodeList.item(i)).getElementsByTagName("Company").
		item(0).getChildNodes().item(0).getNodeValue().trim();

		companyCountry = ((Element) receiptsNodeList.item(i)).getElementsByTagName("Country").
		item(0).getChildNodes().item(0).getNodeValue().trim();

		companyCity = ((Element) receiptsNodeList.item(i)).getElementsByTagName("City").
		item(0).getChildNodes().item(0).getNodeValue().trim();

		companyStreet = ((Element) receiptsNodeList.item(i)).getElementsByTagName("Street").
		item(0).getChildNodes().item(0).getNodeValue().trim();


	}
	/*private void processReceipt(NodeList receiptsNodeList, int i) {
		receiptID = Integer.parseInt(getElementText(receiptsNodeList, i, "ReceiptID"));
		date = getElementText(receiptsNodeList, i, "Date");
		kind = getElementText(receiptsNodeList, i, "Kind");
		sales = Double.parseDouble(getElementText(receiptsNodeList, i, "Sales"));
		items = Integer.parseInt(getElementText(receiptsNodeList, i, "Items"));
		companyName = getElementText(receiptsNodeList, i, "Company");
		companyCountry = getElementText(receiptsNodeList, i, "Country");
		companyCity = getElementText(receiptsNodeList, i, "City");
		companyStreet = getElementText(receiptsNodeList, i, "Street");
		addReceipt();
	}
	private String getElementText(NodeList nodeList, int index, String tagName) {
		return ((Element) nodeList.item(index))
			.getElementsByTagName(tagName)
			.item(0)
			.getChildNodes()
			.item(0)
			.getNodeValue()
			.trim();
	}*/
}  	


