package Classes;


public class Mystery extends Genre {
    String genre = "Mystery";
    private Book b1 = new Book("The Girl with the Dragon tattoo",genre,"No Information","Paperback,Penguin group","No Information","Single Edition");
    private Book b2 = new Book("Kingdom of ashes",genre,"Sarah j. Maas");
    private Book b3 = new Book("Dhongsho Pahar",genre,"Masud Rana");
    private Book b4 = new Book("Best Masud Rana Msytery Collection",genre,"Masud Rana");
    private Book b5 = new Book("The Blue Umbrella",genre,"Ruskin Bond","Paperback","7 January 1992","Single Edition");
    private Book[] books = new Book[]{b1,b2,b3,b4,b5};

public     void updateGenre() {

    }

    public
    String getGenreName() {
        return genre;
    }

    public Book[] getbookList() {
        return books;
    }
}
