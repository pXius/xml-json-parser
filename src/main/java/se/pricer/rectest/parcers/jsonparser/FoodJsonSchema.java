package se.pricer.rectest.parcers.jsonparser;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import se.pricer.rectest.parcers.models.BreakfastMenu;

public class FoodJsonSchema {

    @Expose
    @Getter
    @Setter
    @SerializedName("breakfast_menu")
    private BreakfastMenu breakfastMenu;

}