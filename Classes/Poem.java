package Classes;

public class Poem extends Genre{
    String genre = "Poem";
    private Book b1 = new Book("Ghor Duar",genre,"Nirendronath Chokroborti","No Information","No Information","Single Edition");
    private Book b2 = new Book("Chollisher Dinguli",genre,"Nirendronath Chokroborti");
    private Book b3 = new Book("Jongole",genre,"Nirendronath Chokroborti");
    private Book b4 = new Book("Kobitar kobita",genre,"Nirendronath Chokroborti","2008");
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
