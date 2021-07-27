package Classes;

public class Biography extends Genre{
    String genre = "Biography";
    private Book b1 = new Book("Chobir Deshe Kobitar Deshe",genre,"Sunil Gangopadhyay","No Information","1991","Single Edition");
    private Book b2 = new Book("Oshomapto Attojiboni",genre,"Sheikh Mujeebur Rahman","The University Press","2012","Single Edition");
    private Book b3 = new Book("Atyacharita",genre,"Prafulla Roy","Bishwa Sahitya","2015","Single Edition");
    private Book b4 = new Book("Humayun Ahmed er Oprokashito Rochona",genre,"Humayun Ahmed","No Information","No Information","Single Edition");
    private Book b5 = new Book("Wings of Fire: An Autobiography of Abdul Kalam",genre,"A. P. J. Abdul Kalam","Paperback","1 January 1999","Single Edition");
    private Book b6 = new Book("The Immortals of Meluha (Shiva Trilogy)",genre,"Amish","Paperback","24 July 2017","Single Edition");
    private Book[] books = new Book[]{b1,b2,b3,b4,b5,b6};

    public void updateGenre() {

    }

    public String getGenreName() {
        return genre;
    }

    public Book[] getbookList() {
        return books;
    }
}
