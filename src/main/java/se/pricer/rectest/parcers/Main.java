package se.pricer.rectest.parcers;


import org.apache.commons.io.FilenameUtils;
import se.pricer.rectest.parcers.xmlparser.FoodXMLParser;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        if (getFileExtension("menu.xml").equalsIgnoreCase("xml")) {
            FoodXMLParser.parse("menu.xml");
        }

//        Gson gson = new Gson();
//        FoodJsonSchema menu = gson.fromJson(new FileReader("menu.json"), FoodJsonSchema.class);
//        menu.getBreakfastMenu().getFood().forEach(System.out::println);

    }

    public static String getFileExtension(String fileName) {
        return FilenameUtils.getExtension(fileName);
    }
}
