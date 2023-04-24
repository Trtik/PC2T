package project;

import java.util.Arrays;

class HranyFilm extends Film {
    private String[] actors;

    public HranyFilm(String title, String director, int year, String[] actors, int rating, String ratingText) {
        super(title, director, year, rating, ratingText);
        this.actors = actors;
    }

    public String[] getActors() {
        return actors;
    }

    public void setActors(String[] actors) {
        this.actors = actors;
    }

    @Override
    public String toString() {
        return "HranyFilm [title=" + title + ", director=" + director + ", year=" + year + ", actors="
                + Arrays.toString(actors) + ", rating=" + rating + " , ratingText=" + ratingText + "]";
    }
}
