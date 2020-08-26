/*
    Nhập vào kích thước chiều rộng chiều cao và in ra hình chữ nhật các dấu *.
    Ví dụ với chiều cao là 5, chiều rộng là 5
                    * * * * *
                    * * * * *
                    * * * * *
                    * * * * *
                    * * * * *
*/
package Exercises_Part_01.P01;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập chiều cao: ");
        int m = scanner.nextInt(); // chiều cao hình chữ nhật
        System.out.println("Nhập chiều rộng: ");
        int n = scanner.nextInt(); // chiều rộng hình chữ nhật

        for (int i = 0; i < m; i++) { // loop theo hàng
            for (int j = 0; j < n; j++) { // loop theo cột
                System.out.print(" * "); // in không xuống dòng
            }
            System.out.println(); // Xuống dòng
        }

    }
}