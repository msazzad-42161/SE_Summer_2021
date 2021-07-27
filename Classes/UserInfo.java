package Classes;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public abstract class UserInfo {
    private static int shifter=6;
    private static String username="";
    private static String emailAddress = "";
    private static final String usernamesDestination = "TextFiles\\User Information\\Usernames.txt";
    private static final String passwordsDestination = "TextFiles\\User Information\\Passwords.txt";
    private static final String emailsDestination = "TextFiles\\User Information\\EmailAddresses.txt";

    public static void startOperation() {
        askOperation();
    }
    public static String getName(){
        return username;
    }
    public static String getMail(){
        return emailAddress;
    }
    static void getnsetname() {

        System.out.print("Your name: ");
        Scanner input = new Scanner(System.in);
        String name = input.nextLine();

        File nameFile = new File(usernamesDestination);
        try {
            nameFile.createNewFile();
            ArrayList<String> names = new ArrayList<>();
            String tempName="";
            Scanner reader = new Scanner(nameFile);
            while (reader.hasNextLine()){
                tempName = reader.nextLine();
                names.add(tempName);
            }
            if (names.size()>0){
                for (String usr:names) {
                    if(name.equals(usr)){
                        System.out.println("There is already an account created with username: "+name+"\nSo you have to create a new account with unique username..\nIf you want to look at the taken username they are saved in the following destination: "+new File(usernamesDestination).getAbsolutePath()+"\n\nCREATE A NEW USER:>");
                        askOperation();
                    }
                }
            }
            String string = "";
            while(reader.hasNextLine()){
                string = string.concat(reader.nextLine()+"\n");

            }
            username=username.concat(name);
            string = string.concat(name);
            FileWriter namewriter = new FileWriter(nameFile);
            namewriter.write(string);
            namewriter.close();
        }
        catch (IOException e){
            System.out.println("Failed to read file: "+nameFile.getName());
            askOperation();
        }
    }
    static String getnencryptPass(){
        System.out.print("Password:");
        Scanner input = new Scanner(System.in);
        String password = input.nextLine();
        String encryptedPass = "";
        char[] chars = password.toCharArray();
        for (char c:chars) {
            c+=shifter;
            encryptedPass = encryptedPass+c;
        }
        return encryptedPass;
    }
    static void saveEpass(String encryptedPassword){
        try{
            File passFile = new File(passwordsDestination);
            passFile.createNewFile();
            Scanner reader = new Scanner(passFile);
            String old = "";
            while (reader.hasNextLine()){
                old = old.concat(reader.nextLine()+"\n");
            }

            old=old.concat(encryptedPassword);
            FileWriter passwriter = new FileWriter(passFile);
            passwriter.write(old);
            passwriter.close();
        }
        catch (FileNotFoundException exception){
            System.out.println("File not found");
        }
        catch (IOException e){
            System.out.println("Failed to read passwords");
        }



    }
    static void LoginOperation() {
         ArrayList<String> names = new ArrayList<>();
         ArrayList<String> mails = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        try {

            Scanner read = new Scanner(new File(usernamesDestination));
            Scanner readMail = new Scanner(new File(emailsDestination));
            String name = "";
            String electronicMail = "";
            if(read.hasNextLine()){
                while (readMail.hasNextLine()){
                    electronicMail = readMail.nextLine();
                    mails.add(electronicMail);
                }
            while (read.hasNextLine()) {
                name = read.nextLine();
                names.add(name);
            }
            System.out.println("\nLogin::>\n");
            System.out.print("Name or Mail: ");
            String usrKey = input.nextLine();
            for (int i=0;i<names.size();i++) {
                if(usrKey.equals(names.get(i))||usrKey.equals(mails.get(i))){
                    System.out.println("Found a user: "+usrKey);
                    System.out.print("Password :");
                    String password =  input.next();
                    checkPassword(password,i);
                    break;
                }
                else if(!(usrKey.equals(names.get(i))||usrKey.equals(mails.get(i)))){
                    System.out.println("NO USER FOUND!");
                    askOperation();
                    break;
                }
            }

        } else{
                System.out.print("\nFound no account!\nCreate one to Login\nYou have to add a new user account...\n\n");
                createnewUser();
            }
        }

        catch (FileNotFoundException e) {
            System.out.print("\nFound no account!\nCreate one to Login\nYou have to add a new user account...\n\n");
            createnewUser();
        }
    }

    static void checkPassword(String password,int index){
        if(password.equals(decngetPass(index))){
            System.out.println("\nSuccessfully Logged in!\n");
        }
        else {
            System.out.println("\n!!!Wrong password try again!!!\n");
            LoginOperation();
        }
    }
    static String decngetPass(int index){
        String dString = "";
        ArrayList<String> passListenc = new ArrayList<>();
        try {
            Scanner read = new Scanner(new File(passwordsDestination));
            String pass = "";
            while (read.hasNextLine()){
                pass = read.nextLine();
                passListenc.add(pass);
            }
            String toD = passListenc.get(index);
            char[] chars = toD.toCharArray();
            for (char c: chars ) {
                c-=shifter;
                dString = dString+c;
            }

        }
        catch (IOException e){
            System.out.println("Failed to read file.");
        }
        return dString;
    }
    static void askOperation(){
        try{
        System.out.println("1) Login");
        System.out.println("2) Create new account");
        System.out.print("I would like to [choose either 1 or 2]: ");
        Scanner read = new Scanner(System.in);
        int iccha=read.nextInt();
        if(iccha==1){
            LoginOperation();
        }
        else if(iccha==2){
            createnewUser();
        }
        else{
            System.out.println("Wrong input!\nChoose either 1 or 2.\nLet's try again!!!");
            askOperation();
        }
        }
        catch (InputMismatchException exception){
            System.out.println("Wrong input...\nTry using integer 1 or 2\nTRY AGAIN:");
            askOperation();
        }
    }
    private static void createnewUser(){
        getnsetname();
        getnsetEmail();
        String password=getnencryptPass();
        saveEpass(password);
    }
    static void getnsetEmail(){
        Scanner in = new Scanner(System.in);
        System.out.print("Your email address: ");
        String mail = in.nextLine();
        if(mail.contains("@")&&mail.contains(".")){
 emailAddress=emailAddress.concat(mail);
            try{
                File mailFile = new File(emailsDestination);
                mailFile.createNewFile();
                Scanner reader = new Scanner(mailFile);

                while(reader.hasNextLine()){
                    if(mail.equals(reader.nextLine())){
                        System.out.println("Email address already in use! Try another one.");
                        getnsetEmail();
                    }
                }
                String text = "";
                while (reader.hasNextLine()){
                    text=text.concat(reader.nextLine()+"\n");
                }
                text = text.concat(mail);
                FileWriter mailWriter = new FileWriter(mailFile);
                mailWriter.write(text);
                mailWriter.close();
            }
            catch (IOException exception){
                System.out.println("Failed to write email address");
            }
        }
        else{
            System.out.println("...Invalid email address!\nEnter email properly this time:");
            getnsetEmail();
        }
    }

}

