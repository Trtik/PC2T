package project;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FilmLoader2 {
    
    public static void loadFilm2(String fileName2, ArrayList<AnimovanyFilm> animovanyFilmList) {
        File file = new File(fileName2);
        Scanner scanner;
        try {
            scanner = new Scanner(file);
            String title = scanner.nextLine();
            String director = scanner.nextLine();
            int year = scanner.nextInt();
            scanner.nextLine();
            String animatorString = scanner.nextLine();
            String[] animators = animatorString.split(",");
            int ageRating = scanner.nextInt();
            int rating = scanner.nextInt();
            scanner.nextLine();
            String ratingText = scanner.nextLine();
            AnimovanyFilm newMovie = new AnimovanyFilm(title, director, year, animators, rating, ratingText, ageRating);
            animovanyFilmList.add(newMovie);
            scanner.close();
            System.out.println("Film byl uspesne nacten a ulozen do databaze.");
        } 
        catch (FileNotFoundException e) {
            System.out.println("Soubor s nazvem " + fileName2 + " nebyl nalezen.");
        }
    }
}
