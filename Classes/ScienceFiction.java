package Classes;

public class ScienceFiction extends Genre {
   public String genre = "Sci-Fi";
    private Book b1 = new Book("Dune",genre,"Frank Herbert","Paperback,Penguin group","July 30,2005","1st Edition");
    private Book b2 = new Book("Science Fiction Shomogro",genre,"Muhammad Zafar Iqbal");
    private Book b3 = new Book("Mitul o tar Robot",genre,"Muahammad Zafar Iqbal");
    private Book b4 = new Book("The Three-Body Problem",genre,"Liu Cixin","Paperback","January 12 2016","Single Edition");
    private Book b5 = new Book("Kindred",genre,"Octavia E.Buttler","Bluestreak","1979","Single Edition");
    private Book b6 = new Book("The Blazing World",genre,"Margaret Cavendish","1666");
    private Book b7 = new Book("Jurassic Park",genre,"Michael Crichton","1990");
    private Book[] books = new Book[]{b1,b2,b3,b4,b5,b6,b7};

    public void updateGenre() {
    }


   public String getGenreName() {
        return genre;
    }

    public Book[] getbookList() {
        return books;
    }
}
