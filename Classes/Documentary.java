package Classes;
public class Documentary extends Genre{
    String genre = "Documentary";
    private Book b1 = new Book("I am Malala",genre,"Malala Yousufzai","Paperback,Penguin group","July 30,2005","1st Edition");
    private Book b2 = new Book("Into Thin Air:A Personal Account of the Mount Everest Disaster",genre,"John Krakauer","Paperback","1997","Single Edition");
    private Book b3 = new Book("The Diary of a Young Girl",genre,"Anne Frank","Mass Market Paperback","2011","Single Eition");
    private Book b4 = new Book("Steve Jobs",genre,"Walter Isaacson","2008");
    private Book b5 = new Book("Sapiens: A Brief History of HumanKind",genre,"Yuval Noah Harari","2011");
    private Book b6 = new Book("India After Gandhi: The History of the World's Largest Democracy",genre,"Ramachadra Guha","19 July 2017");
    private Book[] books = new Book[]{b1,b2,b3,b4,b5};

    public void updateGenre() {
    }

    public String getGenreName() {
        return genre;
    }

    public Book[] getbookList() {
        return books;
    }
}
