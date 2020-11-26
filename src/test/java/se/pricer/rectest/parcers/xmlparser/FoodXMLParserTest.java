package se.pricer.rectest.parcers.xmlparser;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import se.pricer.rectest.parcers.models.Food;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@DisplayName("XML Food Parsing Tests")
class FoodXMLParserTest {
    // Test Data
    String normalXMLFile = "src/test/testData/menu.xml";
    String brokenXMLFile = "src/test/testData/brokenPropertiesMenu.xml";

    String berryWaffleDescription = "Light Belgian waffles covered with an assortment of fresh berries and whipped cream";

    // Behaviour with EXPECTED formatting.
    @Test
    @DisplayName("XML Food parse - Normal File")
    void parse() {
        List<Food> foodList = FoodXMLParser.parse(normalXMLFile);
        // Expected array size
        assertEquals(5, foodList.size());
        // Expected name at index position 0.
        assertEquals("Belgian Waffles", foodList.get(0).getName());
        // Expected price at index position 1.
        assertEquals("$7.95", foodList.get(1).getPrice());
        // Expected Description at index position 2.
        assertEquals(berryWaffleDescription, foodList.get(2).getDescription());
        // Expected calories at index positions 3.
        assertEquals("600", foodList.get(3).getCalories());
    }

    // Behaviour with BROKEN formatting.
    @Test
    @DisplayName("XML Food parse - Broken File")
    void parseMissingProperties() {
        List<Food> foodList = FoodXMLParser.parse(brokenXMLFile);
        // Expected array size (Change parent tag 2 name)
        assertEquals(4, foodList.size());
        // Expected name at index position 0.
        assertEquals("Belgian Waffles", foodList.get(0).getName());
        // Expected Description at index position 1.
        assertEquals(berryWaffleDescription, foodList.get(1).getDescription());
        // Expected calories NotFood tag name skips object creation.
        assertEquals("600", foodList.get(2).getCalories());
        // Expected null at property name mismatch. "zzZZzz"
        assertNull(foodList.get(3).getCalories());
    }
}