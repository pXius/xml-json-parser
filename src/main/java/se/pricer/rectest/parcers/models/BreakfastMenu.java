package se.pricer.rectest.parcers.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class BreakfastMenu {

    @Expose
    @Getter
    @Setter
    @SerializedName("food")
    private List<Food> food;

}