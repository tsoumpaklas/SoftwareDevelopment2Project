package output;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;



public class XMLReceiptFileWriter  extends AbstractReceiptFileWriter{
	private Document document;
	 
	protected void createFile() {
        try {
			DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
     		DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
    	    document = documentBuilder.parse(fileToWrite);

			Node root = document.getFirstChild();
            

            Element rootElement = document.createElement("Receipt");
            root.appendChild(rootElement);

            createElementAndAppend(document, rootElement, "ReceiptID", String.valueOf(receipt.getReceiptID()));
            createElementAndAppend(document, rootElement, "Date", receipt.getDate());
			createElementAndAppend(document, rootElement, "Kind", String.valueOf(receipt.getKind()));
			createElementAndAppend(document, rootElement, "Sales", String.valueOf(receipt.getSales()));
			createElementAndAppend(document, rootElement, "Items", String.valueOf(receipt.getItems()));
			createElementAndAppend(document, rootElement, "Company", String.valueOf(receipt.getCompany()));
			createElementAndAppend(document, rootElement, "Country", String.valueOf(address.getCountry()));
			createElementAndAppend(document, rootElement, "City", String.valueOf(address.getCity()));
			createElementAndAppend(document, rootElement, "Street", String.valueOf(address.getStreet()));
			createElementAndAppend(document, rootElement, "Number", String.valueOf(address.getStreetNumber()));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void createElementAndAppend(Document doc, Element parent, String name, String content) {
      Element element = doc.createElement(name);
	  element.appendChild(doc.createTextNode(content));
	  parent.appendChild(element);

	
}

	@Override
	protected void writeFile() {
		try{
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT,"yes");
			transformer.setOutputProperty(OutputKeys.METHOD, "xml");
			DOMSource source = new DOMSource(document);
			
			StreamResult result = new StreamResult(fileToWrite);
			transformer.transform(source, result);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
}
