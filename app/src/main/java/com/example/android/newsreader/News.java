package com.example.android.newsreader;

import android.graphics.Bitmap;

/**
 * Created by Francislainy on 06/02/2017.
 */

public class News {
    private String title;
    private String description;
    private Bitmap image;

    public News(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public News(String title, String description, Bitmap image) {
        this.title = title;
        this.description = description;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Bitmap getImage() {
        return image;
    }
}
