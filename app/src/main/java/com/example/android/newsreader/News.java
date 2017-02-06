package com.example.android.newsreader;

/**
 * Created by Francislainy on 06/02/2017.
 */

public class News {
    private String sectionName;
    private String webTitle;

    public News(String sectionName, String webTitle) {
        this.sectionName = sectionName;
        this.webTitle = webTitle;
    }

    public String getSectionName() {
        return sectionName;
    }

    public String getWebTitle() {
        return webTitle;
    }

}
