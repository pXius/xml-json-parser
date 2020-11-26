package se.pricer.rectest.parcers.jsonparser;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import se.pricer.rectest.parcers.models.Food;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
@DisplayName("JSON Food Parsing Tests")
class FoodJsonParserTest {
    // Test Data
    String normalJSONFile = "src/test/testData/menu.json";
    String brokenJSONFile = "src/test/testData/brokenPropertiesMenu.json";

    String berryWaffleDescription = "Light Belgian waffles covered with an assortment of fresh berries and whipped cream";

    // Behaviour with EXPECTED formatting.
    @Test
    @DisplayName("JSON Food parse - Normal File")
    void parseNormal() {
        List<Food> foodList = FoodJsonParser.parse(normalJSONFile);
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
    @DisplayName("JSON Food parse - Broken File")
    void parseMissingProperties() {
        List<Food> foodList = FoodJsonParser.parse(brokenJSONFile);
        // Expected array size
        assertEquals(5, foodList.size());
        // Expected name at index position 0.
        assertEquals("Belgian Waffles", foodList.get(0).getName());
        // Expected null on missing property
        assertNull(foodList.get(1).getCalories());
        // Expected Description at index position 2.
        assertEquals(berryWaffleDescription, foodList.get(2).getDescription());
        // Expected null at property name mismatch.
        assertNull(foodList.get(3).getCalories());
    }
}
