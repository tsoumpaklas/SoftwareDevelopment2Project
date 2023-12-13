package output;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import java.io.File;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;


public class RepresentativeStatsXMLReport extends AbstractRepresentativeStatsReport	{
	
	public void saveFile() {
		String fullPathName =  "C:\\Users\\User\\Desktop\\" + receiptManager.getAfm() + "_SALES1.xml";
        try {
        	 DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
        	 DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
        	 Document document = documentBuilder.newDocument();

        	 Element agentElement = document.createElement("Agent");
        	 document.appendChild(agentElement);

			 addContent(document);
			 writeToFile(document, fullPathName);

        } catch (Exception ex) {
            ex.printStackTrace();
       		 }
	}

	public void createElements(Document document, Element parent, String name, String content) {
		Element element = document.createElement(name);
		element.appendChild(document.createTextNode(content));
		parent.appendChild(element);
	}

	public void addContent(Document document)  {
		Element root = (Element) document.getFirstChild();
		createElements(document, root, "Name", String.valueOf(receiptManager.getName()));
		createElements(document, root, "AFM", String.valueOf(receiptManager.getAfm()));
		createElements(document, root, "TotalSales", String.valueOf(receiptManager.calculateTotalSales()));
		createElements(document, root, "TrouserSales", String.valueOf(receiptManager.calculateSalesForEachItem("Trousers")));
		createElements(document, root, "ShirtSales", String.valueOf(receiptManager.calculateSalesForEachItem("Shirts")));
		createElements(document, root, "CoatsSales", String.valueOf(receiptManager.calculateSalesForEachItem("Coats")));
		createElements(document, root, "SkirtsSales", String.valueOf(receiptManager.calculateSalesForEachItem("Skirts")));
		createElements(document, root, "Commision", String.valueOf(receiptManager.calculateCommission(receiptManager.calculateTotalSales())));
	}

	public void writeToFile(Document document, String fullPathName)	{
		try{
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty(OutputKeys.METHOD, "xml");
			DOMSource domSource = new DOMSource(document);
			StreamResult streamResult = new StreamResult(new File(fullPathName));
			transformer.transform(domSource, streamResult);
			}catch(Exception e)	{
				e.printStackTrace();
				}	
	}

}

