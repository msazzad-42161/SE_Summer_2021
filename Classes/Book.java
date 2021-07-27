package Classes;

public class Book {
    private String bookName="No Information",authorName="No Information",publisherName="No Information",publishDate="No Information",Category="No Information",Edition="No Information";
    Book(){
    }
    Book(String bookName,String Category,String authorName){
        this.bookName=bookName;
        this.Category = Category;
        this.authorName = authorName;
    }
    Book(String bookName,String Category,String authorName,String publishDate){
        this.bookName=bookName;
        this.Category = Category;
        this.authorName = authorName;
        this.publishDate = publishDate;
    }
    Book(String bookName,String Category,String authorName,String publisherName,String publishDate,String edition){
        this.bookName = bookName;
        this.Category = Category;
        this.authorName = authorName;
        this.publisherName = publisherName;
        this.publishDate = publishDate;
        this.Edition = edition;
    }

   public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

   public void setCategory(String category) {
        this.Category = category;
    }

  public   void setEdition(String edition) {
        this.Edition = edition;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

     public String getAuthorName() {
        return authorName;
    }

    public String getBookName() {
        return bookName;
    }

    public String getCategory() {
        return Category;
    }

    public String getEdition() {
        return Edition;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public String getPublisherName() {
        return publisherName;
    }
}
