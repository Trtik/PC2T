package project;

public class FilmSaverByTitle2 extends FilmSaver2 {
    
    private String folderPath;
    
    public FilmSaverByTitle2(String folderPath) {
        this.folderPath = folderPath;
    }
    
    @Override
    public String getFileName2(String title) {
        return folderPath + "/" + title + ".txt";
    }
}
