package project;

import java.io.FileWriter;
import java.io.IOException;

public abstract class FilmSaver {
    
    public abstract String getFileName(String title);
     
    public void saveFilm(HranyFilm movie) {
        String fileName = getFileName(movie.getTitle());
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(movie.getTitle() + "\n");
            writer.write(movie.getDirector() + "\n");
            writer.write(movie.getYear() + "\n");
            writer.write(String.join(",", movie.getActors()) + "\n");
            writer.write(movie.getRating() + "\n");
            writer.write(movie.getRatingText() + "\n");
        } 
        catch (IOException e) {
            System.out.println("Chyba pri ukladani souboru " + fileName + ": " + e.getMessage());
        }
    }
}
