package project;


import java.io.FileWriter;
import java.io.IOException;

public abstract class FilmSaver2 {
    
    public abstract String getFileName2(String title);
       
    public void saveFilm2(AnimovanyFilm movie) {
        String fileName2 = getFileName2(movie.getTitle());
        try (FileWriter writer = new FileWriter(fileName2)) {
            writer.write(movie.getTitle() + "\n");
            writer.write(movie.getDirector() + "\n");
            writer.write(movie.getYear() + "\n");
            writer.write(String.join(",", movie.getAnimators()) + "\n");
            writer.write(movie.getAgeRating() + "\n");
            writer.write(movie.getRating() + "\n");
            writer.write(movie.getRatingText() + "\n");
        } 
        catch (IOException e) {
            System.out.println("Chyba pri ukladani souboru " + fileName2 + ": " + e.getMessage());
        }
    }
}