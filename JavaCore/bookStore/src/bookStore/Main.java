package bookStore;

import java.util.Scanner;

public class Main {
    private static Book bookObj = null;

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int FunctionId = 0;
        boolean flg = true;
        do {
            showMenu();
            FunctionId = scanner.nextInt();
            scanner.nextLine();
            switch (FunctionId) {
                case 1:
                    addBook();
                    break;
                case 2:
                    editBook();
                    break;
                case 3:
                    infoBook();
                    break;
                default:
                    flg = false;
                    break;
            }
        } while (flg == true);
        scanner.close();

    }

    public static void showMenu() {
        myPrint("======================= Book Manage ======================= ");
        myPrint("1.  Add book");
        myPrint("2.  Edit book");
        myPrint("3.  Info book");
        myPrint("4.  Exit");
        myPrint("Your choise [1-4]:  ");
    }

    public static void myPrint(String vContent) {
        System.out.println(vContent);
    }

    public static void addBook() {
        Scanner scanner = new Scanner(System.in);
        String bookName = "";
        String bookID = "";
        double bookPrice = 0;
        myPrint("bookID:    ");
        bookID = scanner.nextLine();
        myPrint("bookName:    ");
        bookName = scanner.nextLine();
        myPrint("bookPrice:    ");
        bookPrice = scanner.nextDouble();

        bookObj = new Book(bookID, bookName, bookPrice);

    }

    public static void editBook() {
        if (bookObj != null) {
            Scanner scanner = new Scanner(System.in);
            String bookName = "";
            double bookPrice = 0;
            myPrint("bookName:    ");
            bookName = scanner.nextLine();
            myPrint("bookPrice:    ");
            bookPrice = scanner.nextDouble();
            bookObj.setName(bookName);
            bookObj.setPrice(bookPrice);
            ;
        } else {
            myPrint("Not Exits");
        }
    }

    public static void infoBook() {
        if (bookObj != null) {
            bookObj.showInfo();
        } else {
            myPrint("Not Exits");
        }

    }
}
