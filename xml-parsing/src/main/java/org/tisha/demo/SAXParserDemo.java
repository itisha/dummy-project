package org.tisha.demo;

import org.tisha.sax.handler.SAXHandler;
import org.tisha.xml.model.DriversLicense;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

/**
 * @author Tsikhan Kuprevich
 * @since 8/7/2017
 */
public class SAXParserDemo {

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser();

        SAXHandler saxHandler = new SAXHandler();
        saxParser.parse(ClassLoader.getSystemResourceAsStream("drivers-license.xml"), saxHandler);

        DriversLicense driversLicense = saxHandler.getDriversLicense();
        System.out.println(driversLicense);
    }
}
