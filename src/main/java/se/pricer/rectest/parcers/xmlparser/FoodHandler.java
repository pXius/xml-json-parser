package se.pricer.rectest.parcers.xmlparser;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import se.pricer.rectest.parcers.models.Food;

import java.util.ArrayList;
import java.util.List;

public class FoodHandler extends DefaultHandler {
    private List<Food> menu = null;
    private Food menuItem = null;
    private StringBuilder data = null;
    private boolean bName = false;
    private boolean bPrice = false;
    private boolean bDescription = false;
    private boolean bCalories = false;

    public List<Food> getMenu() {
        return menu;
    }

    /**
     * If a "food" tag is found, create a food object and Array if one does not yet exist.
     * If any of the specified tags are found, mark them true to be processed for inner data.
     * Initialise a string builder to which data will be concatenated.
     */
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        switch (qName.toLowerCase()) {
            case "food":
                menuItem = new Food();
                if (menu == null) menu = new ArrayList<>();
            case "name":
                bName = true;
                break;
            case "price":
                bPrice = true;
                break;
            case "description":
                bDescription = true;
                break;
            case "calories":
                bCalories = true;
                break;
        }
        data = new StringBuilder();
    }

    /**
     * Concat the data inside the tags (see characters method), set to true in the startElement method.
     * When the closing "food" tag is reached, add the food item to the previously created array list.
     */
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (bName) {
            menuItem.setName(data.toString());
            bName = false;
        } else if (bPrice) {
            menuItem.setPrice(data.toString());
            bPrice = false;
        } else if (bDescription) {
            menuItem.setDescription(data.toString());
            bDescription = false;
        } else if (bCalories) {
            menuItem.setCalories(data.toString());
            bCalories = false;
        }
        if (qName.equalsIgnoreCase("food")) menu.add(menuItem);
    }

    /**
     * The handler parses data between tags in chunks. A string builder is used to stitch the data together.
     */
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        data.append(new String(ch, start, length));
    }
}

