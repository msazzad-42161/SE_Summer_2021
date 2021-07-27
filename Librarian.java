import Classes.*;
import Interfaces.*;

import java.io.*;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

class Librarian extends UserInfo implements BorrowBook, DonateBook {
    static String username = UserInfo.getName();
    static String emailAddress = UserInfo.getMail();
    private static String date = new Date().toString();
    private String usrInfo = "Name: "+username+"\nEmail Address: "+emailAddress+"\nBecame library member at: "+date+"\n\n";
    //Categories::>
    private String categories_file = "TextFiles\\Book Categories.txt";
    private String borrowHistoryDest = "TextFiles\\User History\\Borrow history.txt";
    private String donatedBookHistoryDestination = "TextFiles\\User History\\Donation history.txt";
    private Genre horror = new Horror();
    private Genre myst = new Mystery();
    private Genre scifi = new ScienceFiction();
    private Genre thriller = new Thriller();
    private Genre programming = new Programming();
    private Genre comedy = new Comedy();
    private Genre biography = new Biography();
    private Genre documentary = new Documentary();
    private Genre others = new Others();
    private Genre scienceNtech = new ScienceandTechnology();
    private Genre poem = new Poem();
    private Genre[] genres = new Genre[]{horror,biography,documentary,thriller,comedy,poem,scifi,scienceNtech,programming,myst,others};
    //Borrowing methods:
    public void generateCategories()  {
        try{
            File categoryFile = new File(categories_file);
            categoryFile.createNewFile();
            FileWriter writer = new FileWriter(categoryFile);
            for (int i = 0; i <genres.length ; i++) {
                writer.write((i+1)+") "+genres[i].getGenreName()+"\n");
            }
            writer.close();
        }
        catch (IOException e){
            System.out.println("Error Occurred!");
        }
    }
    public void showCategories() {
        try{
            File file = new File(categories_file);
            Scanner read = new Scanner(file);
            while(read.hasNextLine()){
                String lines = read.nextLine();
                System.out.println(lines);
            }
            read.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }
    private Genre genre;
    public void selectCategory() {
        int choosedNum;
        Scanner input = new Scanner(System.in);
        System.out.print("Select your category [Ex. 1,2,3,4]: ");
        try {
            choosedNum = input.nextInt();
            for (int i = 0; i <genres.length ; i++) {
                genre = genres[choosedNum-1];
            }

        }catch (InputMismatchException exception){
            System.out.println("Wrong Input!\nTry entering integer numbers.");
            selectCategory();
        }
        catch (IndexOutOfBoundsException exception){
            System.out.println("You must choose between 1 to "+genres.length);
            selectCategory();
        }
    }
    public void setBooks() {
        String genrename = genre.getGenreName();
        String single_category_path = "TextFiles\\Categories\\" + genrename + "-Category.txt";
        System.out.println("Category: "+genrename);
        try {
            FileWriter fileWriter = new FileWriter(new File(single_category_path));
            for (int i = 0; i <genre.getbookList().length ; i++) {
                Book[] books = genre.getbookList();
                fileWriter.write((i+1)+") "+books[i].getBookName()+"\n");
            }
            fileWriter.flush();
            fileWriter.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    public void showBooks() {
        String genrename = genre.getGenreName();
        String books_path = "TextFiles\\Categories\\" + genrename + "-Category.txt";
        System.out.println("Books:");
        try{
            File file = new File(books_path);
            Scanner read = new Scanner(file);
            while(read.hasNextLine()){
                String lines = read.nextLine();
                System.out.println(lines);
            }
            read.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
    private Book book;
    public void selectBook() {
        Book[] books = genre.getbookList();
        Scanner input = new Scanner(System.in);
        System.out.print("Choose your book: ");
        try {
            int choiceInput = input.nextInt()-1;
            book = books[choiceInput];
            System.out.println("Book Details::>");
            System.out.println("Name: "+book.getBookName());
            System.out.println("Category :"+book.getCategory());
            System.out.println("Author: "+book.getAuthorName());
            System.out.println("Published: "+book.getPublishDate());
            System.out.println("Publisher: "+book.getPublisherName());
            System.out.println("Edition: "+book.getEdition());
        }catch (InputMismatchException e){
            System.out.println("Wrong Input!\nTry entering integer numbers.");
            selectBook();
        }
        catch (IndexOutOfBoundsException e){
            System.out.println("You must choose between 1 to "+books.length);
            selectBook();
        }
        writeBorrowHistory();
    }
    public void writeBorrowHistory() {

        //Get the book info.
        String bookInformation = "Book name: "+book.getBookName()+"\n"+
                "Book Category: "+book.getCategory()+"\n"+
                "Book Author: "+book.getAuthorName()+"\n"+
                "Book Publisher: "+book.getPublisherName()+"\n"+
                "Book Publish Date: "+book.getPublishDate()+"\n"+
                "Book Edition: "+book.getEdition()+"\n"+
                "Borrowed at: "+ new Date().toString();
        try {
            File file = new File(borrowHistoryDest);
            if(file.createNewFile()){
                System.out.println("\nOhh! It seems like you are borrowing book/(s) first time from here.");
                System.out.println("\nTo keep information of your borrow history we are saving borrow history in a .txt format file.");
            }else{
                System.out.println("\nOverwriting file: "+file.getName()+".");
            }
            Scanner scanner = new Scanner(file);
            String oldString = "";
            while (scanner.hasNextLine()){
                oldString = oldString.concat(scanner.nextLine()+"\n");
            }
            if (oldString.isEmpty()) {
                oldString = "User Information::>\nHi "+username+"!\nBORROW HISTORY (DETAILS)::>\n\n"+usrInfo;            }
            oldString = oldString.concat("BookInfo:\n"+bookInformation);
            Writer writer = new FileWriter(new File(borrowHistoryDest));
            writer.write(oldString);
            writer.close();
        }
        catch (IOException exception){
            System.out.println("Failed to write borrow history");
        }

        System.out.println("Your borrow information has been added as history in the file: "+new File(borrowHistoryDest).getName());
        System.out.println("File Destination: "+new File(borrowHistoryDest).getAbsolutePath());
    }
    public void showBorrowHistory() {
        try {
            Scanner reader = new Scanner(new File(borrowHistoryDest));
            System.out.println("\nYour borrow history::>\n");
            String outputString = "";
            while (reader.hasNextLine()) {
                outputString=outputString.concat(reader.nextLine()+"\n");
            }
            System.out.println(outputString);
            if (outputString.isEmpty()){
                System.out.println("You have not borrowed anything yet");
            }
                    System.out.println("These information are saved here in .txt file: "+new File(borrowHistoryDest).getAbsolutePath()+"\n\n");

        }
        catch (FileNotFoundException e){
            System.out.println("\nThere is no borrow history yet!\nBorrow some books first...\n");
        }
    }

    //Donating methods:

    private String donategenreName="";
    public void setCategory() {
        String oldString ="";
        try
        {
            Scanner input = new Scanner(System.in);
            File categoryFile = new File(categories_file);
            Scanner reader = new Scanner(categoryFile);
            while (reader.hasNextLine()){
                oldString = oldString.concat(reader.nextLine()+"\n");
            }
            System.out.println(oldString);
            System.out.print("Under which category you want to donate your book?\nChoose one [Ex. 1,2,3,4....]:");
            int choice = input.nextInt()-1;
            donategenreName =  genres[choice].getGenreName();
        }
        catch (FileNotFoundException  exception){
            System.out.println("We could not find the file to read the categories");
        }
        catch (InputMismatchException m){
            System.out.println("Enter integers only please!");
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("You must enter from 1 to "+genres.length+" from the list above.");
        }
    }

    public void setBookInfo() {
        System.out.print("What is your book name?: ");
        Scanner input = new Scanner(System.in);
        String bookName= input.nextLine();
        System.out.print("Author name: ");
        String author = input.nextLine();
        System.out.print("Publisher: ");
        String publisher = input.nextLine();
        System.out.print("Publishing date: ");
        String pubdate = input.nextLine();
        System.out.print("Edition: ");
        String edition = input.nextLine();
        String donationDate = new Date().toString();
        String bookInformation = "Book name: "+bookName+"\n"+
                "Book Category: "+donategenreName+"\n"+
                "Book Author: "+author+"\n"+
                "Book Publisher: "+publisher+"\n"+
                "Book Publish Date: "+pubdate+"\n"+
                "Book Edition: "+edition+"\n"+
                "Donated at: "+ donationDate;

        writeDonationHistory(bookInformation);
        showBookInfo(bookInformation);
    }
    public void writeDonationHistory(String bookInformation) {
        String oldString = "";
        try {
            File donationhistoryFile = new File(donatedBookHistoryDestination);
            if(donationhistoryFile.createNewFile()){
                System.out.println("Writing donation history in the file named: "+donationhistoryFile.getName());
                System.out.println("File destination: "+donationhistoryFile.getAbsolutePath());
            }
            else {
                System.out.println("Overwriting file "+donationhistoryFile.getName());
                System.out.println("Donation information saved at: "+donationhistoryFile.getCanonicalPath());
            }
            Scanner reader = new Scanner(donationhistoryFile);
            while (reader.hasNextLine()){
                oldString = oldString.concat(reader.nextLine()+"\n");
            }
            if (oldString.isEmpty()) {
                oldString = "Hi "+username+"!\nHere is your donation history information in details::>\n\n"+usrInfo;;
            }
            oldString = oldString.concat("BookInfo:\n"+bookInformation);
            Writer fileWriter = new FileWriter(donationhistoryFile);
            fileWriter.write(oldString);
            fileWriter.close();
        }
        catch (IOException e){
            System.out.println("Sorry, failed to write donation history\nPlease enter book information again");
            setCategory();
        }
    }
    public void showBookInfo(String bookinformation) {
        System.out.println("Book Information:");
        System.out.print(bookinformation+"\n\n");
        System.out.print("Do you want to donate more?: ");
        Scanner in = new Scanner(System.in);
        try{
            String agreement = in.nextLine().toLowerCase();
            if(agreement.equals("yes")||agreement.equals("y")){
                setCategory();
            }
            else if(agreement.equals("no")||agreement.equals("n")){
                System.out.println("Thanks for your donation\n");
                System.out.println("You can find your donation information here: "+donatedBookHistoryDestination);
            }
        }
        catch (InputMismatchException e){
            System.out.println("Wrong Input!\nYou have to enter either 'yes' or 'no'");
        }
    }
    public void showDonationHistory() {

        System.out.println("Your donation summary:");
        try{
            Scanner reader = new Scanner(new File(donatedBookHistoryDestination));
            String outputString="";
            while(reader.hasNextLine()){
                outputString=outputString.concat(reader.nextLine()+"\n");
            }
            if (outputString.isEmpty()){
                System.out.println("You have not donated anything yet");
            }
            System.out.println(outputString);
                    System.out.println("\n\nThese information are saved here in .txt file: "+new File(donatedBookHistoryDestination).getAbsolutePath()+"\n\n");

        }
        catch (FileNotFoundException e){
            System.out.println("\nFile not found in the destination\n");
        }
    }
}