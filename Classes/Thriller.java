package Classes;


public class Thriller extends Genre {
   public String genre = "Thriller";
    private Book b1 = new Book("The Night Swim",genre,"Megan Goldin","Paperback,Penguin group","July 30,2005","1st Edition");
    private Book b2 = new Book("The Silent Wife",genre,"Karin Slaughter");
    private Book b3 = new Book("Sisters",genre,"Daisy Johnson");
    private Book b4 = new Book("The Companion",genre,"Katie Alender","Aug 25,2020");
    private Book[] books = new Book[]{b1,b2,b3,b4};
public
    void updateGenre() {

    }
public     String getGenreName() {
        return genre;
    }

    public Book[] getbookList() {
        return books;
    }
}
