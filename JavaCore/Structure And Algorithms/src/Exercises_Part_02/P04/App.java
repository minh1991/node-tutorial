/*
    Nhập 2 mảng a[N] và b[M] và số nguyên p (0 ≤ p < N). Hãy chèn mảng b[]
    vào vị trí p của a[]. 
    Ví dụ: 
        a[4]: 5 3 6 7; 
        b[3]: 2 9 11; 
        p = 1 
        → a[7]: 5 2 9 11 3 6 7. 
 */

package Exercises_Part_02.P04;

import java.util.Scanner;

public class App {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] a, b, c; // 3 array được sử dụng
        int m, n, k; // length 3 array được sử dụng
        int p; // Vị trí sẽ chèn
        Scanner scanner = new Scanner(System.in);

        // Nhập lenth các mảng sử dụng
        System.out.println("Chiều dài mảng a: ");
        m = scanner.nextInt();
        System.out.println("Chiều dài mảng b: ");
        n = scanner.nextInt();
        k = m + n;
        System.out.println("Suy ra chiều dài mảng c là " + k);

        // nhập phần tử cho mảng
        System.out.println("Nhập mảng a gồm " + m + " phần tử:");
        a = ArrItem(m);
        System.out.println("Nhập mảng b gồm " + n + " phần tử:");
        b = ArrItem(n);
        c = new int[k];

    }

    public static int[] ArrItem(int n) {
        int[] x = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = scanner.nextInt();
        }
        return x;
    }
}