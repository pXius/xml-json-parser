package se.pricer.rectest.parcers.xmlparser;

import org.xml.sax.SAXException;
import se.pricer.rectest.parcers.models.Food;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class FoodXMLParser {

    /**
     * Creates a SAX parser instance to which a 'SAX handler' matching the XML schema and the XML
     * file are passed.
     * @param fileName path to the file being parsed in String format.
     * @return returns a List of Food objects.
     */
    public static List<Food> parse(String fileName) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        List<Food> unsortedMenu = null;
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();
            FoodHandler handler = new FoodHandler();
            saxParser.parse(new File(fileName), handler);
            unsortedMenu = handler.getMenu();
        } catch (SAXException e) {
            System.out.println(" XML FORMATTING NOT ACCEPTABLE!");
        } catch (IOException e) {
            System.out.println("FILE NOT FOUND!");
        } catch (ParserConfigurationException e) {
            System.out.println("PARSER CONFIGURATION ERROR!");
        }
        return unsortedMenu;
    }

}
