package org.tisha.demo;

import org.tisha.xml.model.DriversLicense;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

/**
 * @author Tsikhan Kuprevich
 * @since 8/7/2017
 */
public class STAXParserDemo {

    public static void main(String[] args) throws XMLStreamException {
        XMLInputFactory factory = XMLInputFactory.newInstance();

        XMLStreamReader xmlStreamReader = factory.createXMLStreamReader(
                ClassLoader.getSystemResourceAsStream("drivers-license.xml"));

        DriversLicense driversLicense = null;
        String content = null;

        while (xmlStreamReader.hasNext()) {
            int event = xmlStreamReader.next();
            switch (event) {
                case XMLStreamConstants.START_ELEMENT:
                    if ("DriversLicense".equals(xmlStreamReader.getLocalName())) {
                        driversLicense = new DriversLicense();
                        driversLicense.setStatus(xmlStreamReader.getAttributeValue(0));
                    }
                    break;

                case XMLStreamConstants.CHARACTERS:
                    content = xmlStreamReader.getText().trim();
                    break;

                case XMLStreamConstants.END_ELEMENT:
                    switch (xmlStreamReader.getLocalName()) {
                        case "number":
                            driversLicense.setNumber(Long.parseLong(content));
                            break;
                        case "firstName":
                            driversLicense.setFirstName(content);
                            break;
                        case "lastName":
                            driversLicense.setLastName(content);
                            break;
                    }
            }
        }

        System.out.println(driversLicense);
    }
}
