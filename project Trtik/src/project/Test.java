package project;
import java.util.ArrayList;
import java.sql.*;
import java.util.List;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import dbconnection.DbConnection;
import dbconnection.DbConnection2;

public class Test {
	
	public static int pouzeCelaCisla1(Scanner sc) 
	{
		int cislo1 = 0;
		try
		{
			cislo1 = sc.nextInt();
		}
		catch(Exception e)
		{
			System.out.println("Nastala vyjimka typu "+e.toString());
			System.out.println("Zadejte prosim cele cislo! ");
			sc.nextLine();
			cislo1 = pouzeCelaCisla1(sc);
		}
		return cislo1;
	}
	
	public static int pouzeCelaCisla2(Scanner sc) 
	{
		int cislo2 = 0;
		try
		{
			cislo2 = sc.nextInt();
		}
		catch(Exception e)
		{
			System.out.println("Nastala vyjimka typu "+e.toString());
			System.out.println("Zadejte prosim cele cislo! ");
			sc.nextLine();
			cislo2 = pouzeCelaCisla2(sc);
		}
		return cislo2;
	}
	
	public static int pouzeCelaCisla3(Scanner sc) 
	{
		int cislo3 = 0;
		try
		{
			cislo3 = sc.nextInt();
		}
		catch(Exception e)
		{
			System.out.println("Nastala vyjimka typu "+e.toString());
			System.out.println("Zadejte prosim cele cislo! ");
			sc.nextLine();
			cislo3 = pouzeCelaCisla3(sc);
		}
		return cislo3;
	}
	
	public static void main(String[] args) {
		
		 	Scanner scanner = new Scanner(System.in);
	     	ArrayList<AnimovanyFilm> animovanyFilmList = new ArrayList<AnimovanyFilm>();
	     	ArrayList<HranyFilm> hranyFilmList = new ArrayList<HranyFilm>();
	     
	     	DbConnection dbConnection = new DbConnection();
	     	Connection conn = dbConnection.getConn();
	        DbConnection2 dbConnection2 = new DbConnection2();
	        Connection conn2 = dbConnection2.getConn();

	        try {
	            Statement stmt = conn.createStatement();
	            ResultSet rs = stmt.executeQuery("SELECT * FROM hranyFilmy");

	            while (rs.next()) {
	                String title = rs.getString("title");
	                String director = rs.getString("director");
	                int year = rs.getInt("year");
	                String actorsString = rs.getString("actors");
	                String[] actors = actorsString.split(",");
	                int rating = rs.getInt("rating");
	                String ratingText = rs.getString("ratingText");

	                HranyFilm newMovie = new HranyFilm(title, director, year, actors, rating, ratingText);
	                hranyFilmList.add(newMovie);
	            }

	            rs.close();
	            stmt.close();  
	        } 
	        catch (SQLException e) {
	            e.printStackTrace();
	        }
	        
	        try {
	            Statement stmt2 = conn2.createStatement();
	            ResultSet rs2 = stmt2.executeQuery("SELECT * FROM animovanyFilmy");

		        while (rs2.next()) {
		            String title = rs2.getString("title");
		            String director = rs2.getString("director");
		            int year = rs2.getInt("year");
		            String animatorsString = rs2.getString("animators");
		            String[] animators = animatorsString.split(",");
		            int rating = rs2.getInt("rating");
		            String ratingText = rs2.getString("ratingText");
		            int ageRating = rs2.getInt("ageRating");
		               
	
		            AnimovanyFilm newMovie = new AnimovanyFilm(title, director, year, animators, rating, ratingText, ageRating);
		            animovanyFilmList.add(newMovie);
	        }

	        rs2.close();
	        stmt2.close();  
	    } 
	    catch (SQLException e) {
	        e.printStackTrace();
	    }
    
	    Scanner sc=new Scanner(System.in);
		int volba;
		int volba2;
		int volba3;

		boolean run=true;
		while(run)
		{
			System.out.println("Vyberte druh filmu:");
			System.out.println("1 .. hrane filmy");
			System.out.println("2 .. animovane filmy");
			System.out.println("3 .. ukonceni programu");
			
			volba=pouzeCelaCisla1(sc);
			switch(volba)
			{
				case 1:
					boolean run2=true;
					while(run2)
					{
						System.out.println("Vyberte funkci u hranych filmu:");
						System.out.println("1  .. pridani filmu");
						System.out.println("2  .. upraveni filmu");
						System.out.println("3  .. smazani filmu");
						System.out.println("4  .. upraveni hodnoceni filmu");
						System.out.println("5  .. vypis filmu");
						System.out.println("6  .. vyhledani filmu");
						System.out.println("7  .. vypis hercu, kteri se podileli na vice nez jednom filmu");
						System.out.println("8  .. vypis vsech filmu, ktere obsahuji konkretniho herce");
						System.out.println("9  .. ulozeni informace o vybranem filmu do souboru");
						System.out.println("10 .. nacteni vsech informaci o danem filmu ze souboru");
						System.out.println("11 .. navrat na vyber filmu");
						
						volba2=pouzeCelaCisla2(sc) + 2;
						switch(volba2)
						{
							case 3:
							
				                System.out.println("Zadejte nazev filmu:");
				                String title = scanner.nextLine();
	
				                System.out.println("Zadejte jmeno rezisera:");
				                String director = scanner.nextLine();
	
				                System.out.println("Zadejte rok vydani:");
				                int year = scanner.nextInt();
				                scanner.nextLine();
				                    
								System.out.println("Zadejte seznam hercu (oddelte carkami):");
		                        String actorsString = scanner.nextLine();
		                        String[] actors = actorsString.split(",");
		                        
		                        System.out.println("Zadejte bodove hodnoceni (1-5):");
		                        int rating = scanner.nextInt();
		                        scanner.nextLine();
		                        
		                        System.out.println("Zadejte slovni hodnoceni:");
				                String ratingText = scanner.nextLine();
	
		                        HranyFilm newMovie = new HranyFilm(title, director, year, actors, rating, ratingText);
		                        hranyFilmList.add(newMovie);
								break;
								
							case 4:
								System.out.println("Zadejte název filmu, ktery chcete upravit:");
								String title1 = scanner.nextLine();

								HranyFilm movieToEdit = null;
								for (HranyFilm movie : hranyFilmList) {
								    if (movie.getTitle().equals(title1)) {
								        movieToEdit = movie;
								        break;
								    }
								}
	
								if (movieToEdit == null) {
								    System.out.println("Film s nazvem " + title1 + " nebyl nalezen.");
								    break;
								}
	
								System.out.println("Vyberte, ktere udaje chcete upravit:");
								System.out.println("1. Nazev");
								System.out.println("2. Reziser");
								System.out.println("3. Rok vydani");
								System.out.println("4. Seznam hercu");
	
								int choice = scanner.nextInt();
								scanner.nextLine();
	
								switch (choice) {
								    case 1:
								        System.out.println("Zadejte novy nazev:");
								        String newTitle = scanner.nextLine();
								        movieToEdit.setTitle(newTitle);
								        break;
								    case 2:
								        System.out.println("Zadejte noveho rezisera:");
								        String newDirector = scanner.nextLine();
								        movieToEdit.setDirector(newDirector);
								        break;
								    case 3:
								        System.out.println("Zadejte novy rok vydani:");
								        int newYear = scanner.nextInt();
								        scanner.nextLine();
								        movieToEdit.setYear(newYear);
								        break;
								    case 4:
								        System.out.println("Zadejte novy seznam hercu (oddelte carkami):");
								        String newActorsString = scanner.nextLine();
								        String[] newActors = newActorsString.split(",");
								        movieToEdit.setActors(newActors);
								        break;
								    default:
								        System.out.println("Neplatna volba.");
								        break;
								}
	
								System.out.println("Upraveny film:");
								System.out.println(movieToEdit.toString());
								break;
								
							case 5:
								System.out.println("Zadejte nazev filmu, ktery chcete smazat:");
								String titleToDelete = scanner.nextLine();
	
								hranyFilmList.removeIf(movie -> movie.getTitle().equals(titleToDelete));
	
								System.out.println("Film byl uspesne smazan ze seznamu.");
								break;
								
							case 6:
								System.out.println("Zadejte nazev filmu, kterymu chcete upravit hodnoceni:");
								String title2 = scanner.nextLine();
		
								HranyFilm movieToEdit2 = null;
								for (HranyFilm movie : hranyFilmList) {
								    if (movie.getTitle().equals(title2)) {
								        movieToEdit2 = movie;
								        break;
								    }
								}

								if (movieToEdit2 == null) {
								    System.out.println("Film s nazvem " + title2 + " nebyl nalezen.");
								    break;
								}
	
								System.out.println("Vyberte, ktere udaje chcete upravit:");
								System.out.println("1. Bodove hodnoceni Filmu");
								System.out.println("2. Slovni hodnoceni Filmu");
			
								int choice2 = scanner.nextInt();
								scanner.nextLine();
	
								switch (choice2) {
								    case 1:
								        System.out.println("Zadejte nove bodove hodnocení (1-5):");
								        int newRating = scanner.nextInt();
								        scanner.nextLine();
								        movieToEdit2.setRating(newRating);
								        break;
								    case 2:
								        System.out.println("Zadejte nove slovni hodnoceni:");
								        String newRatingText = scanner.nextLine();
								        movieToEdit2.setRatingText(newRatingText);
								        break;
								   
								    default:
								        System.out.println("Neplatna volba.");
								        break;
								}
						
								System.out.println("Upraveny film:");
								System.out.println(movieToEdit2.toString());
								break;
								
							case 7:
								System.out.println("Seznam filmu:");
								for (Film film : hranyFilmList) {
								    if (film instanceof HranyFilm) {
								        System.out.println(film);
								    }
								}
						
								break;
								
							case 8:
								System.out.println("Zadejte nazev filmu, ktery chcete vyhledat:");
								String searchTitle = scanner.nextLine();
	
								for (HranyFilm movie : hranyFilmList) {
								   if (movie.getTitle().equalsIgnoreCase(searchTitle)) {
								       
								       System.out.println("Nazev: " + movie.getTitle());
								       System.out.println("Reziser: " + movie.getDirector());
								       System.out.println("Rok vydani: " + movie.getYear());
								       System.out.println("Seznam hercu: " + Arrays.toString(movie.getActors()));
								       System.out.println("Hodnoceni diváku: " + movie.getRating());
								       System.out.println("Slovni hodnoceni divaku: " + movie.getRatingText());
								       
								   }
								}
			  
								break;
							case 9:
								
								List<String> multipleMovieActors = new ArrayList<>();
	
								for (HranyFilm movie : hranyFilmList) {
								    
								    List<String> movieActors = Arrays.asList(movie.getActors());
								
								    for (String actor : movieActors) {
								        int count = 0; 
								        
								        for (HranyFilm otherMovie : hranyFilmList) {
								            if (otherMovie == movie) {
								                continue; 
								            }
								            List<String> otherMovieActors = Arrays.asList(otherMovie.getActors());
								            if (otherMovieActors.contains(actor)) {
								                count++; 
								            }
								        }
								   
								        if (count > 0) {
								            multipleMovieActors.add(actor);
								        }
								    }
								}
								
								Set<String> setMultipleMovieActors = new HashSet<>(multipleMovieActors);
								multipleMovieActors.clear();
								multipleMovieActors.addAll(setMultipleMovieActors);
	
								for (String actor : multipleMovieActors) {
								    List<HranyFilm> actorMovies = new ArrayList<>();
								    for (HranyFilm movie : hranyFilmList) {
								        if (Arrays.asList(movie.getActors()).contains(actor)) {
								            actorMovies.add(movie);
								        }
								    }
								    
								 if (actorMovies.size() > 1) {
								        System.out.println("Herec " + actor + " se podilel na techto filmech:");
								        for (HranyFilm movie : actorMovies) {
								            System.out.println("- " + movie.getTitle() + " (" + movie.getYear() + ")");
								        }
								 }   } 
								break;
								
							case 10:
								System.out.println("Zadejte jmeno herce:");
								String searchActor = scanner.nextLine();
	
								for (HranyFilm movie : hranyFilmList) {
								   for (String actor : movie.getActors()) {
								       if (actor.equalsIgnoreCase(searchActor)) {
								       
								           System.out.println(movie.getTitle());
								           break;
								       }
								   }
								}
								break;
								
							case 11:
								
								System.out.println("Zadejte nazev filmu pro vyhledani:");
								String title3 = scanner.nextLine();

								HranyFilm foundMovie = null;
								for (HranyFilm movie : hranyFilmList) {
								    if (movie.getTitle().equalsIgnoreCase(title3)) {
								        foundMovie = movie;
								        break;
								    }
								}

								if (foundMovie != null) {
								    FilmSaverByTitle filmSaver = new FilmSaverByTitle("hranyfilmy");
								    filmSaver.saveFilm(foundMovie);
								    System.out.println("Informace o filmu " + foundMovie.getTitle() + " byly uspesne ulozeny do souboru.");
								} else {
								    System.out.println("Film s nazvem " + title3 + " nebyl nalezen.");
								}
								break;
								
							case 12:
							
								System.out.println("Zadejte nazev souboru (nazev filmu.txt), ktery chcete nacist:");
								String fileName = scanner.nextLine();
						     
						        FilmLoader.loadFilm("hranyfilmy/" + fileName, hranyFilmList);
								break;
								
							case 13:
								run2=false;
								break;
						}}
				break;
				
				case 2:
					boolean run3=true;
					while(run3)
					{
						System.out.println("Vyberte funkci u animovanych filmu:");
						System.out.println("1  .. pridani filmu");
						System.out.println("2  .. upraveni filmu");
						System.out.println("3  .. smazani filmu");
						System.out.println("4  .. upraveni hodnoceni filmu");
						System.out.println("5  .. vypis filmu");
						System.out.println("6  .. vyhledani filmu");
						System.out.println("7  .. vypis animatoru, kteri se podileli na vice nez jednom filmu");
						System.out.println("8  .. vypis vsech filmu, ktere obsahuji konkretniho animatora");
						System.out.println("9  .. ulozeni informace o vybranem filmu do souboru");
						System.out.println("10 .. nacteni vsech informaci o danem filmu ze souboru");
						System.out.println("11 .. navrat na vyber filmu");
						
						volba3=pouzeCelaCisla3(sc) + 13;
						switch(volba3)
						{
							case 14:
								System.out.println("Zadejte nazev filmu:");
				                String title = scanner.nextLine();
	
				                System.out.println("Zadejte jmeno rezisera:");
				                String director = scanner.nextLine();
	
				                System.out.println("Zadejte rok vydani:");
				                int year = scanner.nextInt();
				                scanner.nextLine();
				                
				                System.out.println("Zadejte seznam animatoru (oddelte carkami):");
		                        String animatorsString = scanner.nextLine();
		                        String[] animators = animatorsString.split(",");
		                        
		                        System.out.println("Zadejte doporuceny vek divaka:");
		                        int ageRating = scanner.nextInt();
		                        scanner.nextLine();
		                        
		                        System.out.println("Zadejte bodove hodnocení (1-10):");
		                        int rating = scanner.nextInt();
		                        scanner.nextLine();
		                        
		                        System.out.println("Zadejte slovni hodnoceni:");
				                String ratingText = scanner.nextLine();
	
		                        AnimovanyFilm newMovie = new AnimovanyFilm(title, director, year, animators, rating, ratingText, ageRating);
		                        animovanyFilmList.add(newMovie);
								break;
								
							case 15:
								System.out.println("Zadejte nazev filmu, ktery chcete upravit:");
								String title1 = scanner.nextLine();
	
								AnimovanyFilm movieToEdit = null;
								for (AnimovanyFilm movie : animovanyFilmList) {
								    if (movie.getTitle().equals(title1)) {
								        movieToEdit = movie;
								        break;
								    }
								}
	
								if (movieToEdit == null) {
								    System.out.println("Film s nazvem " + title1 + " nebyl nalezen.");
								    break;
								}
	
								System.out.println("Vyberte, ktere udaje chcete upravit:");
								System.out.println("1. Nazev");
								System.out.println("2. Reziser");
								System.out.println("3. Rok vydani");
								System.out.println("4. Seznam animatoru");
								System.out.println("5. Doporuceny vek divaka");
	
								int choice = scanner.nextInt();
								scanner.nextLine();
	
								switch (choice) {
								    case 1:
								        System.out.println("Zadejte novy nazev:");
								        String newTitle = scanner.nextLine();
								        movieToEdit.setTitle(newTitle);
								        break;
								    case 2:
								        System.out.println("Zadejte noveho rezisera:");
								        String newDirector = scanner.nextLine();
								        movieToEdit.setDirector(newDirector);
								        break;
								    case 3:
								        System.out.println("Zadejte novy rok vydani:");
								        int newYear = scanner.nextInt();
								        scanner.nextLine();
								        movieToEdit.setYear(newYear);
								        break;
								    case 4:
								        System.out.println("Zadejte novy seznam animatoru (oddelte carkami):");
								        String newAnimatorsString = scanner.nextLine();
								        String[] newAnimators = newAnimatorsString.split(",");
								        movieToEdit.setAnimators(newAnimators);
								        break;
								    case 5:
								        System.out.println("Zadejte novy doporuceny vek divaka:");
								        int newAgeRating = scanner.nextInt();
								        scanner.nextLine();
								        movieToEdit.setAgeRating(newAgeRating);
								        break;
								    default:
								        System.out.println("Neplatna volba.");
								        break;
								}
			
								System.out.println("Upraveny film:");
								System.out.println(movieToEdit.toString());
								break;
				
							case 16:
								System.out.println("Zadejte nazev filmu, ktery chcete smazat:");
								String titleToDelete = scanner.nextLine();
	
								animovanyFilmList.removeIf(movie -> movie.getTitle().equals(titleToDelete));
	
								System.out.println("Film byl uspesne smazan ze seznamu.");
								break;
							case 17:
								System.out.println("Zadejte nazev filmu, ktery chcete upravit hodnoceni:");
								String title2 = scanner.nextLine();
	
								AnimovanyFilm movieToEdit2 = null;
								for (AnimovanyFilm movie : animovanyFilmList) {
								    if (movie.getTitle().equals(title2)) {
								        movieToEdit2 = movie;
								        break;
								    }
								}
	
								if (movieToEdit2 == null) {
								    System.out.println("Film s nazvem " + title2 + " nebyl nalezen.");
								    break;
								}
	
								System.out.println("Vyberte, ktere udaje chcete upravit:");
								System.out.println("1. Bodove hodnoceni Filmu");
								System.out.println("2. Slovni hodnoceni Filmu");
							
								int choice2 = scanner.nextInt();
								scanner.nextLine();
	
								switch (choice2) {
								    case 1:
								        System.out.println("Zadejte nove bodove hodnoceni (1-10):");
								        int newRating = scanner.nextInt();
								        scanner.nextLine();
								        movieToEdit2.setRating(newRating);
								        break;
								    case 2:
								        System.out.println("Zadejte nove slovni hodnoceni:");
								        String newRatingText = scanner.nextLine();
								        movieToEdit2.setRatingText(newRatingText);
								        break;
								   
								    default:
								        System.out.println("Neplatna volba.");
								        break;
								}
	
								System.out.println("Upraveny film:");
								System.out.println(movieToEdit2.toString());
								break;
							case 18:
								System.out.println("Seznam filmu:");
								for (Film film : animovanyFilmList) {
								    if (film instanceof AnimovanyFilm) {
								        System.out.println(film);
								    }
								}
								break;
								
							case 19:
								System.out.println("Zadejte nazev filmu, ktery chcete vyhledat:");
								String searchTitle = scanner.nextLine();
	
								for (AnimovanyFilm movie : animovanyFilmList) {
								   if (movie.getTitle().equalsIgnoreCase(searchTitle)) {
								       
								       System.out.println("Nazev: " + movie.getTitle());
								       System.out.println("Reziser: " + movie.getDirector());
								       System.out.println("Rok vydani: " + movie.getYear());
								       System.out.println("Seznam hercu: " + Arrays.toString(movie.getAnimators()));
								       System.out.println("Hodnoceni diváku: " + movie.getRating());
								       System.out.println("Slovni hodnoceni divaku: " + movie.getRatingText());
								       System.out.println("Doporuceny vek divaka: " + movie.getAgeRating());
								   }
								}
								break;
								
							case 20:
								List<String> multipleMovieAnimators = new ArrayList<>();
	
								for (AnimovanyFilm movie : animovanyFilmList) {
								    
								    List<String> movieAnimators = Arrays.asList(movie.getAnimators());
								    
								    for (String animator : movieAnimators) {
								        int count1 = 0; 
								        
								        for (AnimovanyFilm otherMovie : animovanyFilmList) {
								            if (otherMovie == movie) {
								                continue; 
								            }
								            List<String> otherMovieAnimators = Arrays.asList(otherMovie.getAnimators());
								            if (otherMovieAnimators.contains(animator)) {
								                count1++; 
								            }
								        }
								   
								        if (count1 > 0) {
								            multipleMovieAnimators.add(animator);
								        }
								    }
								}
								
								Set<String> setMultipleMovieAnimators = new HashSet<>(multipleMovieAnimators);
								multipleMovieAnimators.clear();
								multipleMovieAnimators.addAll(setMultipleMovieAnimators);
	
								for (String animator : multipleMovieAnimators) {
								    List<AnimovanyFilm> animatorMovies = new ArrayList<>();
								    for (AnimovanyFilm movie : animovanyFilmList) {
								        if (Arrays.asList(movie.getAnimators()).contains(animator)) {
								            animatorMovies.add(movie);
								        }
								    }
								    
								 if (animatorMovies.size() > 1) {
								        System.out.println("Animator " + animator + " se podilel na techto filmech:");
								        for (AnimovanyFilm movie : animatorMovies) {
								            System.out.println("- " + movie.getTitle() + " (" + movie.getYear() + ")");
								        }
								 }   
								 }
								
								 break;
								
							case 21:
								System.out.println("Zadejte jmeno animatora:");
								String searchAnimator = scanner.nextLine();
	
								for (AnimovanyFilm movie : animovanyFilmList) {
								   for (String animator : movie.getAnimators()) {
								       if (animator.equalsIgnoreCase(searchAnimator)) {
								       
								           System.out.println(movie.getTitle());
								           break;
								       }
								   }
								}
								break;
								
							case 22:
								System.out.println("Zadejte nazev filmu pro vyhledani:");
								String title4 = scanner.nextLine();

								AnimovanyFilm foundMovie = null;
								for (AnimovanyFilm movie : animovanyFilmList) {
								    if (movie.getTitle().equalsIgnoreCase(title4)) {
								        foundMovie = movie;
								        break;
								    }
								}

								if (foundMovie != null) {
								    FilmSaverByTitle2 filmSaver2 = new FilmSaverByTitle2("animovanyFilmy");
								    filmSaver2.saveFilm2(foundMovie);
								    System.out.println("Informace o filmu " + foundMovie.getTitle() + " byly uspesne ulozeny do souboru.");
								} else {
								    System.out.println("Film s nazvem " + title4 + " nebyl nalezen.");
								}
								break;
								
							case 23:
								System.out.println("Zadejte nazev souboru (nazev filmu.txt), ktery chcete nacist:");
								String fileName6 = scanner.nextLine();
						     
						        FilmLoader2.loadFilm2("animovanyfilmy/" + fileName6, animovanyFilmList);
								break;
								
							case 24:
								run3=false;
								break;
						    }
						}
					break;
					
				case 3:

			        DbConnection.createTable();

			        for (HranyFilm movie : hranyFilmList) {
			            DbConnection.insertMovie(movie.getTitle(), movie.getDirector(), movie.getYear(), String.join(",", movie.getActors()), movie.getRating(), movie.getRatingText());
			        }
		        
			        DbConnection2.createTable2();
			        for (AnimovanyFilm movie : animovanyFilmList) {
			            DbConnection2.insertMovie2(movie.getTitle(), movie.getDirector(), movie.getYear(), String.join(",", movie.getAnimators()), movie.getRating(), movie.getRatingText(), movie.getAgeRating());
			        }

			        dbConnection.closeConnection();
		            
			        System.out.println("Program byl ukoncen a databaze byly ulozeny do SQL databaze, ktera se opet nacte pri pristim spusteni programu. ");
			        
					run=false;
					scanner.close();
	                System.exit(0);
					break;
					
					}
				}
			}
		}