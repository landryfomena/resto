package com.example.resto.models;


public class NicePlace {

    private String title;
    private Integer imageUrl;

    public NicePlace(Integer imageUrl, String title) {
        this.title = title;
        this.imageUrl = imageUrl;
    }

    public NicePlace() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(Integer imageUrl) {
        this.imageUrl = imageUrl;
    }

}

