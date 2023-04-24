package project;

public class FilmSaverByTitle extends FilmSaver {
    
    private String folderPath;
    
    public FilmSaverByTitle(String folderPath) {
        this.folderPath = folderPath;
    }
    
    @Override
    public String getFileName(String title) {
        return folderPath + "/" + title + ".txt";
    }
}
