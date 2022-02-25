package com.crazy_ataman.Sax_parser;

import com.crazy_ataman.University.Dean.Dean;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class Sax extends DefaultHandler {
    Dean dean = new Dean();
    String thisElement = "";

    @Override
    public void startElement(String namespaceURI, String localName, String qName, Attributes atts) throws SAXException {
        thisElement = qName;
    }

    public Dean getResult() {
        return dean;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (thisElement.equals("name")) {
            dean.setName(new String(ch, start, length));
        } else if (thisElement.equals("surname")) {
            dean.setSurname(new String(ch, start, length));
        }
    }

    @Override
    public void endElement(String namespaceURI, String localName, String qName) throws SAXException {
        thisElement = "";
    }
}
