package project;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FilmLoader {
    
    public static void loadFilm(String fileName, ArrayList<HranyFilm> hranyFilmList) {
        File file = new File(fileName);
        Scanner scanner;
        try {
            scanner = new Scanner(file);
            String title = scanner.nextLine();
            String director = scanner.nextLine();
            int year = scanner.nextInt();
            scanner.nextLine();
            String actorsString = scanner.nextLine();
            String[] actors = actorsString.split(",");
            int rating = scanner.nextInt();
            scanner.nextLine();
            String ratingText = scanner.nextLine();
            HranyFilm newMovie = new HranyFilm(title, director, year, actors, rating, ratingText);
            hranyFilmList.add(newMovie);
            scanner.close();
            System.out.println("Film byl uspesne nacten a ulozen do databaze.");
        } 
        catch (FileNotFoundException e) {
            System.out.println("Soubor s nazvem " + fileName + " nebyl nalezen.");
        }
    }
}