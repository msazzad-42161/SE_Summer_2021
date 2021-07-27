import java.util.InputMismatchException;
import java.util.Scanner;

public class Library {
    private static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        //Library code goes here...
        HelloLibrarian();
    }


    private static void HelloLibrarian(){
        introPlease();
        startOperation();

    }
    private static void introPlease(){
        System.out.println("HEY THERE!\n->WELCOME TO THE VIRTUAL LIBRARY CREATED BY SAZZAD AND SAGOR.\n->I am not any A.I but powerful enough to be a virtual librarian for you :)");
        System.out.println("I need your name to address you in future...\n[WARNING] : CAREFUL WHILE CHOOSING OPTIONS OR ENTERING  DATA...");
        Librarian.startOperation();
        System.out.print("Thats all I need!\n");
        System.out.println("Thanks for the information");
    }
    private static void exitprogram(int exitCode){
    if(exitCode==5){
        System.out.print("THANK YOU for visiting this virtual library.\nHAVE A HEALTHY DAY!");
    }
    }

    private static void startOperation(){
        System.out.println("Generating library menu...");
        System.out.println("LIBRARY MENU:>>>");
        System.out.println("What would you like to do?");
        System.out.print("1.BORROW\n2.DONATE\n3.CHECK BORROW HISTORY\n4.CHECK DONATION HISTORY\n5.EXIT LIBRARY\n\nI WOULD LIKE TO [ENTER 1,2,3,4 OR 5]: ");
try {
    int agreement =  input.nextInt();
    if (agreement == 1) {
        borrowoperation();
        startOperation();
    } else if (agreement == 2) {
        donateOperation();
        startOperation();
    }
    else if(agreement==3){
        showHistory(agreement);
        startOperation();
    }
    else if(agreement==4){
        showHistory(agreement);
        startOperation();
    } else if(agreement==5){
        System.out.println("Exiting library management system\n");
        exitprogram(agreement);
    }
    else{
        System.out.println("Please enter from 1 to 5");
        startOperation();
    }

}catch (InputMismatchException e){
    System.out.println("Wrong Input!\nPlease enter integer number only\n");
    startOperation();
}


    }
    private static void showHistory(int choice){
Librarian m = new Librarian();
    if(choice==3){
        m.showBorrowHistory();
    }
    else if(choice==4){
        m.showDonationHistory();
    }
    }
    private static void borrowoperation(){
Librarian m = new Librarian();
        m.generateCategories();
        m.showCategories();
        m.selectCategory();
        m.setBooks();
        m.showBooks();
        m.selectBook();
        System.out.print("Would you like to borrow more?: ");
        String agreement = input.next().toLowerCase();
        if (agreement.equals("yes")||agreement.equals("y")){
            borrowoperation();
        }
        else if(agreement.equals("no")||agreement.equals("n")){
            System.out.println("Successfully borrowed books");
            System.out.println("Thanks for borrowing book!");

        }else{
            System.out.println("Wrong input!\nYou have to start borrowing from the beginning... :(");
            borrowoperation();
        }
    }
    private static void donateOperation(){
Librarian m = new Librarian();
m.setCategory();
m.setBookInfo();
    }

}
