package se.pricer.rectest.parcers.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

public class Food {

    @Expose
    @Getter
    @Setter
    @SerializedName("name")
    private String name;

    @Expose
    @Getter
    @Setter
    @SerializedName("price")
    private String price;

    @Expose
    @Getter
    @Setter
    @SerializedName("description")
    private String description;

    @Expose
    @Getter
    @Setter
    @SerializedName("calories")
    private String calories;

    public String getNameLower() {
        return name.toLowerCase();
    }

    @Override
    public String toString() {
        return name +
                "\n\tPrice: " + price +
                "\n\tDescription: " + description +
                "\n\tCalories: " + calories + "\n";
    }
}
