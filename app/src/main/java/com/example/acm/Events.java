package com.example.acm;

public class Events {
    private String title,description,date,year,imageURL;

    public Events()
    {}

    public Events(String Title, String Description, String Date, String Year, String ImageURL)
    {
        title=Title;
        description=Description;
        date=Date;
        year=Year;
        imageURL=ImageURL;
    }

    public String getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public String getTitle() {
        return title;
    }

    public String getYear() {
        return year;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}
