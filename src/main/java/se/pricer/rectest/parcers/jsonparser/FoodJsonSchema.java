package se.pricer.rectest.parcers.jsonparser;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FoodJsonSchema {

    @SerializedName("breakfast_menu")
    @Expose
    private BreakfastMenu breakfastMenu;

    public BreakfastMenu getBreakfastMenu() {
        return breakfastMenu;
    }

    public void setBreakfastMenu(BreakfastMenu breakfastMenu) {
        this.breakfastMenu = breakfastMenu;
    }

}