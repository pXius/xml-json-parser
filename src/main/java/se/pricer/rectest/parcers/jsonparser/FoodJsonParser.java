package se.pricer.rectest.parcers.jsonparser;

import com.google.gson.Gson;
import se.pricer.rectest.parcers.models.Food;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class FoodJsonParser {

    public static List<Food> parse(String filename) {
        Gson gson = new Gson();
        List<Food> unsortedMenu = null;
        try {
            FoodJsonSchema parsedMenu = gson.fromJson(new FileReader(filename), FoodJsonSchema.class);
            unsortedMenu = parsedMenu.getBreakfastMenu().getFood();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return unsortedMenu;
    }
}
