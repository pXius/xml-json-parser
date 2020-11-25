package se.pricer.rectest.parcers.xmlparser;

import org.xml.sax.SAXException;
import se.pricer.rectest.parcers.model.Food;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FoodXMLParser {

    public static void parse(String fileName) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();
            FoodHandler handler = new FoodHandler();
            saxParser.parse(new File(fileName), handler);
            List<Food> sortedMenu = sortMenuItemsByName(handler.getMenu(), true);

            printToConsole(sortedMenu);
        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }
    }

    public static List<Food> sortMenuItemsByName(List<Food> menu, Boolean ascOrDes) {
        if (ascOrDes) {
            return menu.stream().sorted(Comparator.comparing(Food::getNameLower)).collect(Collectors.toList());
        } else {
            return menu.stream().sorted(Comparator.comparing(Food::getNameLower).reversed()).collect(Collectors.toList());
        }
    }

    public static void printToConsole(List<Food> menu) {
        menu.forEach(System.out::println);
    }
}
