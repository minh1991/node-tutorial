/*
    Nhập vào chiều cao và in ra hình như dưới đây (ví dụ với chiều cao bằng 4): 
                    1
                1   2   1
            1   2   3   2   1
        1   2   3   4   3   2   1
*/

package Exercises_Part_01.P03;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        int x, y, output;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào chiều cao:");
        x = scanner.nextInt();

        System.out.println("In ra:");
        for (int i = 0; i <= x; i++) {
            for (int j = 0; j <= 2 * x; j++) {
                y = j - x;
                if (y < 0) {
                    y = y * (-1);
                }
                output = i - y;
                if (output > 0) {
                    System.out.printf("%3d", output);
                } else {
                    System.out.printf("   ");
                }
            }
            System.out.println();
        }
    }
}