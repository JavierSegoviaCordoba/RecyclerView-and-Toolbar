package com.example.javier.recyclerviewandtoolbar;

public class MyItemClass {

    String title;
    String content;
    //String image;

    public MyItemClass(String title, String content) {
        this.title = title;
        this.content = content;
        //this.image = image;
    }
    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    /*public String getImage() {
        return image;
    }*/
}