package com.example.myassignment.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class response {

    @SerializedName("topics")
    public List<topics> topics = null;

    public List<topics> getTopics() {
        return topics;
    }

    public void setTopics(List<topics> topics) {
        this.topics = topics;
    }
}
