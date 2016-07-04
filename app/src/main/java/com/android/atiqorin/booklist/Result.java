package com.android.atiqorin.booklist;

/**
 * Created by atiqorin on 7/4/16.
 */
public class Result {
    String authors;
    String Title;

    public Result(String authors, String title) {
        this.authors = authors;
        Title = title;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }
}
