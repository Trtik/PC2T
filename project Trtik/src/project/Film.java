package project;

class Film {
    protected String title;
    protected String director;
    protected int year;
    protected int rating;
    protected String ratingText;
    
    public Film(String title, String director, int year, int rating, String ratingText) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
        this.ratingText = ratingText;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }
    
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
    
    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
}
    public String getRatingText() {
        return ratingText;
    }
    
    public void setRatingText(String ratingText) {
        this.ratingText = ratingText;
    }

}
