package input;

import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import data.ReceiptManager;



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
			processReceiptData(receiptsNodeList, size);

		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error reading XML file", "Error", JOptionPane.ERROR_MESSAGE);
			}
	}

	private void processAgent(NodeList agentNodeList) {
		name = ((Element) agentNodeList.item(0)).getElementsByTagName("Name").
		item(0).getChildNodes().item(0).getNodeValue().trim();

		afm = ((Element) agentNodeList.item(0)).getElementsByTagName("AFM").
		item(0).getChildNodes().item(0).getNodeValue().trim();
		System.out.println("Name: " + name + " AFM: " + afm + "\n");
		addAgent();
	}

	private void processReceiptData(NodeList receiptsNodeList, int size) {
		for (int i = 0; i < size; i++) {
			
				
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
				System.out.println("receiptId: " + receiptID + " date: " + date + " kind: " + kind + " sales: " + sales + " items: " + items);

				companyName = ((Element) receiptsNodeList.item(i)).getElementsByTagName("Company").
				item(0).getChildNodes().item(0).getNodeValue().trim();

				companyCountry = ((Element) receiptsNodeList.item(i)).getElementsByTagName("Country").
				item(0).getChildNodes().item(0).getNodeValue().trim();

				companyCity = ((Element) receiptsNodeList.item(i)).getElementsByTagName("City").
				item(0).getChildNodes().item(0).getNodeValue().trim();

				companyStreet = ((Element) receiptsNodeList.item(i)).getElementsByTagName("Street").
				item(0).getChildNodes().item(0).getNodeValue().trim();
				
				companyStreetNumber = Integer.parseInt(((Element) receiptsNodeList.item(i)).getElementsByTagName("StreetNumber").
				item(0).getChildNodes().item(0).getNodeValue().trim());
			
				System.out.println("companyName: " + companyName + " companyCountry: " + companyCountry + " companyCity: " + companyCity + " companyStreet: " + companyStreet + " companyStreetNumber: " + companyStreetNumber);

				addReceipt();
				}
				for(int i= 0 ; i<receiptManager.getReceipts().size(); i++) {
				//i want to print all the receipt contents of each 
				System.out.println("ADKKSDKSDK");
				System.out.println(receiptManager.getReceipts().get(i));
				System.out.println(receiptManager.getReceipts().get(i));
			}
		
		}

		


		public ReceiptManager getReceiptManager() {
		return receiptManager;
		}
	}



