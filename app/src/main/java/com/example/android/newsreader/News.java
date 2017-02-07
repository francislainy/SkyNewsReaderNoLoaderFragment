package com.example.android.newsreader;

/**
 * Created by Francislainy on 06/02/2017.
 */

public class News {
    private String title;
    private String description;

    public News(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

}
