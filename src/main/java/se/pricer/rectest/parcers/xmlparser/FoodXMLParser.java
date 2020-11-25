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

    public static List<Food> parse(String fileName) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        List<Food> unsortedMenu = null;
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();
            FoodHandler handler = new FoodHandler();
            saxParser.parse(new File(fileName), handler);
            unsortedMenu = handler.getMenu();
        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }
        return unsortedMenu;
    }

}
