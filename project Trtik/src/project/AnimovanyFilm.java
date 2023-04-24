package project;

import java.util.Arrays;

class AnimovanyFilm extends Film {
    private String[] animators;
    private int ageRating;

    public AnimovanyFilm(String title, String director, int year, String[] animators, int rating, String ratingText, int ageRating) {
        super(title, director, year, rating, ratingText);
        this.animators = animators;
        this.ageRating = ageRating;
    }

    public String[] getAnimators() {
        return animators;
    }

    public void setAnimators(String[] animators) {
        this.animators = animators;
    }

    public int getAgeRating() {
        return ageRating;
    }

    public void setAgeRating(int ageRating) {
        this.ageRating = ageRating;
    }

    @Override
    public String toString() {
        return "AnimovanyFilm [title=" + title + ", director=" + director + ", year=" + year + ", animators="
                + Arrays.toString(animators) + ", rating=" + rating + ", ratingText=" + ratingText + ", ageRating=" + ageRating + "]";
    }
}