package com.example.selflearning.Model;

public class RoadmapModel {
    private String title, duration;

    public RoadmapModel(String title, String duration) {
        this.title = title;
        this.duration = duration;
    }
    public String getTitle() {
        return title;
    }
    public String getDuration() {
        return duration;
    }
}
