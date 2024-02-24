package com.example.arthurrecyclelview;

public class DataModel {

    private String name;
    private String description;
    private int image;
    private String moreDescription;


    public DataModel(String name, String description, int image, String moreDescription) {
        this.name = name;
        this.description = description;
        this.image = image;
        this.moreDescription = moreDescription;
    }


    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getImage() {
        return image;
    }

    public String getMoreDescription() {
        return moreDescription;
    }
}
