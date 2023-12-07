package output;

import java.io.File;
import java.io.IOException;

import javax.swing.text.InternationalFormatter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import data.Address;
import data.Receipt;

public class XMLReceiptFileWriter  extends AbstractReceiptFileWriter{

	protected void createFile() {
		//creating a document doc
		try{
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			Document doc = docBuilder.newDocument();	
			
			//creating the root element
			Element rootElement = doc.createElement("Receipt");
			doc.appendChild(rootElement);
			
			//creating the receiptID element
			Element receiptID = doc.createElement("ReceiptID");
			receiptID.appendChild(doc.createTextNode(String.valueOf(receipt.getReceiptID())));
			rootElement.appendChild(receiptID);
			
			//creating the date element
			Element date = doc.createElement("Date");
			date.appendChild(doc.createTextNode(receipt.getDate()));
			rootElement.appendChild(date);
			
			//creating the sales element
			Element sales = doc.createElement("Sales");
			sales.appendChild(doc.createTextNode(String.valueOf(receipt.getSales())));
			rootElement.appendChild(sales);
			
			//creating the items element
			Element items = doc.createElement("Items");
			items.appendChild(doc.createTextNode(String.valueOf(receipt.getItems())));
			rootElement.appendChild(items);
			
			//creating the company element
			Element company = doc.createElement("Company");
			rootElement.appendChild(company);
			
			//creating the name element
			Element name = doc.createElement("Name");
			name.appendChild(doc.createTextNode(receipt.getCompany().getName()));
			company.appendChild(name);
			
			//creating the address element
			Element address = doc.createElement("Cddress");
			company.appendChild(address);
			
			//creating the country element
			Element country = doc.createElement("Country");
			country.appendChild(doc.createTextNode(receipt.getCompany().getAddress().getCountry()));
			address.appendChild(country);
			
			//creating the city element
			Element city = doc.createElement("City");
			city.appendChild(doc.createTextNode(receipt.getCompany().getAddress().getCity()));
			address.appendChild(city);
			
			//creating the street element
			Element street = doc.createElement("street");
			street.appendChild(doc.createTextNode(receipt.getCompany().getAddress().getStreet()));
			address.appendChild(street);
			
			//creating the streetNumber element
			Element streetNumber = doc.createElement("streetNumber");
			streetNumber.appendChild(doc.createTextNode(String.valueOf(receipt.getCompany().getAddress().getStreetNumber())));
			address.appendChild(streetNumber);
			
			//creating the phoneNumber element
			Element phoneNumber = doc.createElement("phoneNumber");
			phoneNumber.appendChild(doc.createTextNode(String.valueOf(receipt.getCompany().getAddress().getPhoneNumber())));

		}catch(Exception e){
			e.printStackTrace();
		}
		
	}



	

}
