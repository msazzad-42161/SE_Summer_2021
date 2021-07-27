package Classes;

public class Horror extends Genre{
    String genre = "Horror";
    private Book b1 = new Book("Bhoot Samagro",genre,"Ahsan habib","Shuvro Prokashi","2013","Single Edition");
    private Book b2 = new Book("Shimulgorer Kkhune Bhoot",genre,"Shomoresh Bosu");
    private Book b3 = new Book("Pataljhor",genre,"Awnish Deb");
    private Book b4 = new Book("The Conjuring: The Devil Made Me Do It",genre,"James Wan & David Lesley Johnson","2020");
    private Book b5 = new Book("it",genre,"Stephen King","Viking Press","1985","1st Edition");
    private Book b6 = new Book("Annabelle",genre,"Gary Douberman","No Information","September 26, 2014","1st Edition");
    private Book b7 = new Book("Conjuring",genre,"Hayes Brothers","2013");
    private Book[] books = new Book[]{b1,b2,b3,b4,b5,b6,b7};

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
