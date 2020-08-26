/*
    Đọc vào dãy số a có n phần tử chỉ gồm các số nguyên dương.
    Kiểm tra mảng a có phải là mảng đối xứng hay không (ví dụ: 15 2 1 2 15 là mảng đối xứng).
*/

package Exercises_Part_02.P01;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        int[] arr;
        int n;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập Chiều dài mảng: ");
        n = scanner.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Nhập Phần tử thứ " + i + " Của mảng: ");
            arr[i] = scanner.nextInt();
        }
        // System.out.println(arr);
        // Kiểm tra đối xứng
        boolean ok = true;
        int mid = n / 2;
        int x;
        for (int i = 0; i < mid; i++) {
            x = n - 1 - i;
            if (arr[i] != arr[x]) {
                ok = false;
                break;
            }
        }
        if (ok == true) {
            System.out.println("mảng đối xứng");
        } else {
            System.out.println("mảng không đối xứng");
        }
    }
}