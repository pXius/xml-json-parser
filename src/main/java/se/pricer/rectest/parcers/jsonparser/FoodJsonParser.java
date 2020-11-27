package se.pricer.rectest.parcers.jsonparser;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import se.pricer.rectest.parcers.models.Food;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class FoodJsonParser {

    /**
     * Creates an instance of the Gson class to which the class matching the JSON property structure
     * is passed, along with the path to the JSON file.
     * @param filename path to the file being parsed in String format.
     * @return returns a List of Food objects.
     */
    public static List<Food> parse(String filename) {
        Gson gson = new Gson();
        List<Food> unsortedMenu = null;
        try {
            FoodJsonSchema parsedMenu = gson.fromJson(new FileReader(filename), FoodJsonSchema.class);
            unsortedMenu = parsedMenu.getBreakfastMenu().getFood();
        } catch (FileNotFoundException e) {
            System.out.println("FILE NOT FOUND!");
        } catch (JsonSyntaxException e) {
            System.out.println("JSON FORMATTING NOT ACCEPTABLE!");
        }
        return unsortedMenu;
    }
}
