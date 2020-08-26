/*
    Nhập vào kích thước chiều rộng, chiều cao và in ra hình chữ nhật các dấu *
    nhưng rỗng bên trong. Ví dụ với chiều cao là 5, chiều rộng là 5
                    * * * * *
                    *       *
                    *       *
                    *       *
                    * * * * *
*/
/*
Phân tích
    Điều kiện in ra
    - Vị trí đầu tiên của chiều ngang
    - Vị trí đầu tiên chiều dọc
    - Vị trí cuối của chiều ngang
    - Vị trí cuối theo chiều dọc
*/
package Exercises_Part_01.P02;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập chiều cao: ");
        int m = scanner.nextInt(); // chiều cao hình chữ nhật
        System.out.println("Nhập chiều rộng: ");
        int n = scanner.nextInt(); // chiều rộng hình chữ nhật
        System.out.println("In ra:");
        for (int i = 0; i < m; i++) { // in ra chiều cao
            for (int j = 0; j < n; j++) {// in ra chiều rộng
                if (i == 0 || j == 0 || i == m - 1 || j == n - 1) {
                    System.out.print(" * ");
                } else {
                    System.out.print("   ");
                }
            }
            System.out.println(); // xuống dòng
        }

    }
}