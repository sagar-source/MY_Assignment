package com.example.myassignment.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class phrases {

    @SerializedName("name")
    public String name;

    @SerializedName("imageUrl")
    public String imageUrl;

    public phrases(List<phrases> phrases) {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
