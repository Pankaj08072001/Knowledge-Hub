package com.example.selflearning.Model;

public class DeveloperModel {
    private String name ;
    private int bgImage;

    public DeveloperModel(String name, int bgImage) {
        this.bgImage = bgImage;
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public int getBgImage() {
        return bgImage;
    }

}
