package se.pricer.rectest.parcers;

import org.apache.commons.io.FilenameUtils;
import se.pricer.rectest.parcers.jsonparser.FoodJsonParser;
import se.pricer.rectest.parcers.models.Food;
import se.pricer.rectest.parcers.xmlparser.FoodXMLParser;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ParseHandler {
    private static List<Food> unsortedMenu;

    public static void parseFile(String fileName) {
        switch (getFileExtension(fileName)) {
            case "json":
                unsortedMenu = FoodJsonParser.parse(fileName);
                printToConsole(unsortedMenu);
                break;
            case "xml":
                unsortedMenu = FoodXMLParser.parse(fileName);
                printToConsole(unsortedMenu);
                break;
            default:
                System.out.println(getFileExtension(fileName) + " is not a supported file format.");
        }
    }

    public static void parseFile(String fileName, String ascOrDesc) {
        List<Food> sortedMenu;
        switch (getFileExtension(fileName)) {
            case "json":
                unsortedMenu = FoodJsonParser.parse(fileName);
                sortedMenu = sortMenuItemsByName(unsortedMenu, ascOrDesc);
                printToConsole(sortedMenu);
                break;
            case "xml":
                unsortedMenu = FoodXMLParser.parse(fileName);
                sortedMenu = sortMenuItemsByName(unsortedMenu, ascOrDesc);
                printToConsole(sortedMenu);
                break;
            default:
                System.out.println(getFileExtension(fileName) + " is not a supported file format.");
        }
    }

    public static List<Food> sortMenuItemsByName(List<Food> menu, String ascOrDesc) {
        switch (ascOrDesc.toLowerCase()) {
            case "desc":
                return menu.stream().sorted(Comparator.comparing(Food::getNameLower)).collect(Collectors.toList());
            case "asc":
                return menu.stream().sorted(Comparator.comparing(Food::getNameLower).reversed()).collect(Collectors.toList());
            default:
                System.out.println("WARNING: Invalid sort argument! Use 'asc' or 'desc'\n");
                return menu;
        }
    }

    private static void printToConsole(List<Food> menu) {
        if (menu == null) return;
        System.out.println("\n<*><*> Breakfast Menu <*><*>\n");
        menu.forEach(System.out::println);
        System.out.println("<*><*><*> End <*><*><*>");
    }

    private static String getFileExtension(String fileName) {
        return FilenameUtils.getExtension(fileName);
    }
}
