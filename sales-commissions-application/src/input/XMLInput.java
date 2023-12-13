package input;


import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import data.ReceiptManager;




public class XMLInput extends AbstractInput {            

    private Document document = null;
    private NodeList nodeList = null;
    private Element agentElement = null;

    @Override
    protected void initializeFileReader() {
        try{
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            document = documentBuilder.parse(inputFile);
            document.getDocumentElement().normalize();

            nodeList = document.getElementsByTagName("Agent");

        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error in bufferedReader", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


    @Override
    protected void readAgent() {
         try{
             agentElement = (Element) nodeList.item(0);
             name = getTextContent(agentElement, "Name");
             afm = getTextContent(agentElement, "AFM");
             addAgent();
             
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Format is not correct", "Error", JOptionPane.ERROR_MESSAGE);
        }       
    }
    public void readFile() {
        try {
            processReceipts(nodeList);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "The file you have chosen is not a XML file or it is empty", "Error", JOptionPane.ERROR_MESSAGE);
        }
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




