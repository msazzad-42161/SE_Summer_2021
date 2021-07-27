package Classes;

public abstract class Genre {
    Genre(){}
    public abstract void updateGenre();
    public abstract String getGenreName();
    public Book[] books = new Book[]{};
    public Book[] getbookList(){
        return books;
    }
}
