package com.example.myassignment.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class topics {

    @SerializedName("name")
    public String name;

    @SerializedName("phrases")
    public List<phrases> phrases = null;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<phrases> getPhrases() {
        return phrases;
    }

    public void setPhrases(List<phrases> phrases) {
        this.phrases = phrases;
    }

}

