package Classes;

public class ScienceandTechnology extends Genre{
    String genre = "Science and Tech.";
    private Book b1 = new Book("WILL MY CAT EAT MY EYEBALLS",genre,"Caitlin Doughty, Dianné Ruz(Illustrator)","No Information","No Information","Single Edition");
    private Book b2 = new Book("THE BODY",genre,"BILL BRYSON","No Information","No Information","Single Edition");
    private Book b3 = new Book("Invisible Womem",genre,"Caroline Criado Perez, Anna Sak (Translator)","Paperback","March 12 ,2019","Single Edition");
    private Book b4 = new Book("Mama's Last Hug",genre,"FRANS DE WAAL","PAPERBACK","Mar 10,2020","Single Edition");
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
