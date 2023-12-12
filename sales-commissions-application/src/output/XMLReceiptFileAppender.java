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





public class XMLReceiptFileAppender  extends AbstractReceiptFileAppender{


	private Document document;
	 
	protected void createDocument() {
        try {
			DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
     		DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
    	    document = documentBuilder.parse(fileToAppend);

			addContent();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

	public void addContent(){
			Node root = document.getFirstChild();
            

            Element rootElement = document.createElement("Receipt");
            root.appendChild(rootElement);

            createElementAndAppend(document, rootElement, "ReceiptID", String.valueOf(receipt.getReceiptID()));
            createElementAndAppend(document, rootElement, "Date", receipt.getDate());
			createElementAndAppend(document, rootElement, "Kind", String.valueOf(receipt.getKind()));
			createElementAndAppend(document, rootElement, "Sales", String.valueOf(receipt.getSales()));
			createElementAndAppend(document, rootElement, "Items", String.valueOf(receipt.getItems()));
			createElementAndAppend(document, rootElement, "Company", String.valueOf(receipt.getCompany()));
			createElementAndAppend(document, rootElement, "Country", String.valueOf(receipt.getCompany().getAddress().getCountry()));
			createElementAndAppend(document, rootElement, "City", String.valueOf(receipt.getCompany().getAddress().getCity()));
			createElementAndAppend(document, rootElement, "Street", String.valueOf(receipt.getCompany().getAddress().getStreet()));
			createElementAndAppend(document, rootElement, "Number", String.valueOf(receipt.getCompany().getAddress().getStreetNumber()));
	}
	

    private void createElementAndAppend(Document doc, Element parent, String name, String content) {
      Element element = doc.createElement(name);
	  element.appendChild(doc.createTextNode(content));
	  parent.appendChild(element);

	
}

	@Override
	protected void appendToFile() {
		try{
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT,"yes");
			transformer.setOutputProperty(OutputKeys.METHOD, "xml");
			DOMSource source = new DOMSource(document);
			
			StreamResult result = new StreamResult(fileToAppend);
			transformer.transform(source, result);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

}
