package se.pricer.rectest.parcers.jsonparser;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import se.pricer.rectest.parcers.model.Food;

import java.util.List;

public class BreakfastMenu {

    @SerializedName("food")
    @Expose
    private List<Food> food = null;

    public List<Food> getFood() {
        return food;
    }

    public void setFood(List<Food> food) {
        this.food = food;
    }

}