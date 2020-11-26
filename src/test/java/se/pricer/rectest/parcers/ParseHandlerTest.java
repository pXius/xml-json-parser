package se.pricer.rectest.parcers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import se.pricer.rectest.parcers.jsonparser.FoodJsonParser;
import se.pricer.rectest.parcers.models.Food;
import se.pricer.rectest.parcers.xmlparser.FoodXMLParser;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Sorting Tests")
class ParseHandlerTest {
    // Test Data
    String xmlMenu = "src/test/testData/menu.xml";
    String jsonMenu = "src/test/testData/menu.json";
    // Parsed Data
    List<Food> foodListXML = FoodXMLParser.parse(xmlMenu);
    List<Food> foodListJSON = FoodJsonParser.parse(jsonMenu);

    // Unsorted XML - No Arguments
    @Test
    @DisplayName("Parse XML File - Unsorted")
    void parseXmlFileUnsorted() {
        assertEquals("Belgian Waffles", foodListXML.get(0).getName());
        assertEquals("Homestyle Breakfast", foodListXML.get(foodListXML.size() - 1).getName());
    }

    // Sorted XML - Ascending Argument
    @Test
    @DisplayName("Parse XML File - Sorted ASC")
    void parseXmlFileSortedAsc() {
        List<Food> sortedList = ParseHandler.sortMenuItemsByName(foodListXML, "asc");
        assertEquals("Strawberry Belgian Waffles", sortedList.get(0).getName());
        assertEquals("Belgian Waffles", sortedList.get(foodListXML.size() - 1).getName());
    }

    // Sorted XML - Descending Argument
    @Test
    @DisplayName("Parse XML File - Sorted DESC")
    void parseXmlFileSortedDesc() {
        List<Food> sortedList = ParseHandler.sortMenuItemsByName(foodListXML, "desc");
        assertEquals("Belgian Waffles", sortedList.get(0).getName());
        assertEquals("Strawberry Belgian Waffles", sortedList.get(foodListXML.size() - 1).getName());
    }

    // Sorted XML - Incorrect Argument
    @Test
    @DisplayName("Parse XML File - Incorrect Argument")
    void parseXmlFileIncorrectArgument() {
        List<Food> sortedList = ParseHandler.sortMenuItemsByName(foodListXML, "NOTanArg");
        assertEquals("Belgian Waffles", sortedList.get(0).getName());
        assertEquals("Homestyle Breakfast", sortedList.get(foodListXML.size() - 1).getName());
    }

    // Unsorted - No Arguments
    @Test
    @DisplayName("Parse JSON File - Unsorted")
    void parseJsonFileUnsorted() {
        assertEquals("Belgian Waffles", foodListJSON.get(0).getName());
        assertEquals("Homestyle Breakfast", foodListJSON.get(foodListJSON.size() - 1).getName());
    }

    // Sorted JSON - Ascending Argument
    @Test
    @DisplayName("Parse JSON File - Sorted ASC")
    void parseJsonFileSortedAsc() {
        List<Food> sortedList = ParseHandler.sortMenuItemsByName(foodListJSON, "asc");
        assertEquals("Strawberry Belgian Waffles", sortedList.get(0).getName());
        assertEquals("Belgian Waffles", sortedList.get(foodListJSON.size() - 1).getName());
    }

    // Sorted JSON - Descending Argument
    @Test
    @DisplayName("Parse JSON File - Sorted DESC")
    void parseJsonFileSortedDesc() {
        List<Food> sortedList = ParseHandler.sortMenuItemsByName(foodListJSON, "desc");
        assertEquals("Belgian Waffles", sortedList.get(0).getName());
        assertEquals("Strawberry Belgian Waffles", sortedList.get(foodListJSON.size() - 1).getName());
    }

    // Sorted JSON - Incorrect Argument
    @Test
    @DisplayName("Parse JSON File - Incorrect Argument")
    void parseJsonFileIncorrectArgument() {
        List<Food> sortedList = ParseHandler.sortMenuItemsByName(foodListJSON, "NOTanArg");
        assertEquals("Belgian Waffles", sortedList.get(0).getName());
        assertEquals("Homestyle Breakfast", sortedList.get(foodListJSON.size() - 1).getName());
    }
}