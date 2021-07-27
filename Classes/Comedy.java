package Classes;

public class Comedy extends Genre{
    String genre = "Comedy";
    private Book b1 = new Book("Botuk Buror Choshma",genre,"Shirshendu Mukhopadhyay","Ananda Publishers","2011","Single Edition");
    private Book b2 = new Book("Dudh Sayorer Dweep",genre,"Shirshendu Mukhopadhyay","Ananda Publishers","1997","Single Edition");
    private Book b3 = new Book("Kompu Cartoon",genre,"Ahsan Habib","Anyaprokash","2002","Single Edition");
    private Book b4 = new Book("Bhut Shikari Mejhokorta Ebong ...",genre,"Premendro Mitro","Dey's Publishing","January 2009","Single Edition");
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
