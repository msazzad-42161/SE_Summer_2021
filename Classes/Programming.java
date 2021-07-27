package Classes;
public class Programming extends Genre {
    public String genre = "Programming";
    private Book b1 = new Book("Python Crash Course",genre,"Erik Matthes","Paperback,Penguin group","December 2015","Single Edition");
    private Book b2 = new Book("Head First Python",genre,"Paul Barry","Paperback","16 December 2016","Second Edition");
    private Book b3 = new Book("Java:An Object Oriented Programming Language",genre,"James Gosling","Paperback","1995","Single Edition");
    private Book b4 = new Book("Learn C the Hard Way",genre,"Zed A. Shaw","Paperback","17 September, 2015","Single Edition");
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
