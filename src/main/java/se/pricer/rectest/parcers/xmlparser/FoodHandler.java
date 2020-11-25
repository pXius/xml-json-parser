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

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        data.append(new String(ch, start, length));
    }
}

