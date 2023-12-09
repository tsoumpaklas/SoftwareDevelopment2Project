package input;

import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;



public class XMLInput extends Input {            
	public void readFile() {
		Document document = initializeDocument();
		NodeList agentNodeList = document.getElementsByTagName("Agent");
	
		processAgent(agentNodeList);

		NodeList receiptsNodeList = ((Element) agentNodeList.item(0)).getElementsByTagName("Receipt");
		int size = receiptsNodeList.getLength();
		for (int i = 0; i < size; i++) {
			processReceipt(receiptsNodeList, i);
		}
		
	}

	private Document initializeDocument() {
		Document document = null;
		try {
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			document = documentBuilder.parse(inputFile);
			document.getDocumentElement().normalize();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error while reading XML file", "Error", JOptionPane.ERROR_MESSAGE);
		}
		return document;
	}

	private void processAgent(NodeList agentNodeList) {
		name = ((Element) agentNodeList.item(0)).getElementsByTagName("Name").
		item(0).getChildNodes().item(0).getNodeValue().trim();

		afm = ((Element) agentNodeList.item(0)).getElementsByTagName("AFM").
		item(0).getChildNodes().item(0).getNodeValue().trim();

		addAgent();
	}
	private void processReceipt(NodeList receiptsNodeList, int i) {
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
	}
}


