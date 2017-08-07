package org.tisha.sax.handler;

import org.tisha.xml.model.DriversLicense;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * @author Tsikhan Kuprevich
 * @since 8/7/2017
 */
public class SAXHandler extends DefaultHandler {

    private DriversLicense driversLicense;
    private String content;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("DriversLicense"))
            driversLicense = new DriversLicense();
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        switch (qName) {
            case "number":
                driversLicense.setNumber(Long.parseLong(content));
            case "firstName":
                driversLicense.setFirstName(content);
            case "lastName":
                driversLicense.setLastName(content);
        }
    }

    public void characters(char ch[], int start, int length) throws SAXException {
        content = String.copyValueOf(ch, start, length).trim();
    }

    public DriversLicense getDriversLicense() {
        return driversLicense;
    }
}
