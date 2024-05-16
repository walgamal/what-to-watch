package com.example.whattowatch;

public class Movie {

    private String title;
    private String year;
    private String rated;
    private String plot;
    private String language;
    private String ratings;
    private String type;
    private String genre;
    private String posterUrl;
    private boolean response;

    public Movie(){
        response = true;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setRated(String rated) {
        this.rated = rated;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setRatings(String ratings) {
        this.ratings = ratings;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setResponse(boolean response) {
        this.response = response;
    }

    public void setPosterUrl(String posterUrl) {
        this.posterUrl = posterUrl;
    }

    public String getTitle() {
        return title;
    }

    public String getYear() {
        return year;
    }

    public String getRated() {
        return rated;
    }

    public String getGenre() {
        return genre;
    }

    public String getPlot() {
        return plot;
    }

    public String getLanguage() {
        return language;
    }

    public String getRatings() {
        return ratings;
    }

    public String getType() {
        return type;
    }

    public boolean isResponse() {
        return response;
    }

    public String getPosterUrl() {
        return posterUrl;
    }
}
