package Classes;

public class Others extends Genre{
    String genre = "Others";
    private Book b1 = new Book("The Discovery of India","History","Jawharlal Nehry","No Information","February 2008","1st Edition");
    private Book b2 = new Book("Harry Potter Box Set: The Complete Collection","Fantasy","J.K ROWLING","1st November 2014");
    private Book b3 = new Book("The Handmaids Tale","Fantasy","Margaret Atwood","19 September 1996");
    private Book b4 = new Book("Tuesdays With Morrie: An old man, a young man, and life's greatest lesson","Memories","Mitch Album","1st December 1998");
    private Book[] books = new Book[]{b1,b2,b3,b4};

    public void updateGenre() {

    }

    public String getGenreName() {
        return genre;
    }

    public Book[] getbookList() {
        return books;
    }
}
