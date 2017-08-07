package org.tisha.demo;

import org.tisha.xml.model.Address;
import org.tisha.xml.model.DriversLicense;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

/**
 * @author Tsikhan Kuprevich
 * @since 8/7/2017
 */
public class DOMParserDemo {

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = factory.newDocumentBuilder();
        Document document = documentBuilder.parse(ClassLoader.getSystemResourceAsStream("drivers-license.xml"));


        DriversLicense driversLicense = new DriversLicense();

        NodeList numberList = document.getElementsByTagName("number");
        Node number = numberList.item(0);
        driversLicense.setNumber(Long.parseLong(number.getTextContent()));

        NodeList firstNameList = document.getElementsByTagName("firstName");
        Node firstName = firstNameList.item(0);
        driversLicense.setFirstName(firstName.getTextContent());

        NodeList lastNameList = document.getElementsByTagName("lastName");
        Node lastName = lastNameList.item(0);
        driversLicense.setLastName(lastName.getTextContent());

        Element rootElement = document.getDocumentElement();
        String status = rootElement.getAttribute("status");
        driversLicense.setStatus(status);

        NodeList addressList = document.getElementsByTagName("address");
        Node addressNode = addressList.item(0);
        NodeList addressChildNodes = addressNode.getChildNodes();
        Address address = new Address();
        for (int i = 0; i < addressChildNodes.getLength(); i++) {
            Node item = addressChildNodes.item(i);
            if (item instanceof Element) {
                switch (item.getNodeName()) {
                    case "street":
                        address.setStreet(item.getTextContent());
                    case "city":
                        address.setCity(item.getTextContent());
                    case "state":
                        address.setState(item.getTextContent());
                    case "country":
                        address.setCountry(item.getTextContent());
                    case "zipcode":
                        address.setZip(item.getTextContent());
                }
            }
        }

        driversLicense.setAddress(address);


        System.out.println(driversLicense);
    }
}
