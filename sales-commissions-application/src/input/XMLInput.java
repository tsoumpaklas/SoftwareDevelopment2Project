package input;

import java.io.File;

import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import data.ReceiptManager;




public class XMLInput extends AbstractInput {            


    public void readFile() {
        try {
            Document document = createDocument();
            NodeList nodeList = document.getElementsByTagName("Agent");

            processAgent(nodeList);
            processReceipts(nodeList);
			
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error message");
        }
    }

    private Document createDocument() throws Exception {
        DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
        Document doc = docBuilder.parse(inputFile);
        doc.getDocumentElement().normalize();
        return doc;
    }

    private void processAgent(NodeList nodeList) {
        Element agentElement = (Element) nodeList.item(0);
        name = getTextContent(agentElement, "Name");
        afm = getTextContent(agentElement, "AFM");
        addAgent();
    }

    private void processReceipts(NodeList nodeList) {
        Element agentElement = (Element) nodeList.item(0);
        NodeList receiptsNodeList = agentElement.getElementsByTagName("Receipt");

        int size = receiptsNodeList.getLength();
        for (int i = 0; i < size; i++) {
            Element receiptElement = (Element) receiptsNodeList.item(i);
            processReceipt(receiptElement);
        }
    }

    private void processReceipt(Element receiptElement) {
        receiptID = Integer.parseInt(getTextContent(receiptElement, "ReceiptID"));
        date = getTextContent(receiptElement, "Date");
        kind = getTextContent(receiptElement, "Kind");
        sales = Double.parseDouble(getTextContent(receiptElement, "Sales"));
        items = Integer.parseInt(getTextContent(receiptElement, "Items"));
        companyName = getTextContent(receiptElement, "Company");
        companyCountry = getTextContent(receiptElement, "Country");
        companyCity = getTextContent(receiptElement, "City");
        companyStreet = getTextContent(receiptElement, "Street");
        companyStreetNumber = Integer.parseInt(getTextContent(receiptElement, "Number"));
        addReceipt();
    }

    private String getTextContent(Element element, String tagName) {
        return element.getElementsByTagName(tagName).item(0).getTextContent().trim();
    }

	public ReceiptManager getReceiptManager(){
		return receiptManager;
	}
}




