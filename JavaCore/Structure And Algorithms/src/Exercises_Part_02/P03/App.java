/*
    Tạo ngẫu nhiên mảng a[N] gồm các số nguyên bất kỳ sau đó thực hiện:
    • Sắp xếp dãy a theo thứ tự tăng dần
    • Loại bỏ bớt các phần tử trùng nhau sao cho mỗi giá trị chỉ xuất hiện trong a duy nhất một lần.
 */

package Exercises_Part_02.P03;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Chiều dài của mảng:");
        int n = scanner.nextInt();
        // số nguyên bất kỳ
        Random random = new Random();

        // Khởi tạo arr có n phần tử chứa các số nguyên random
        int[] arr = new int[n];
        int count = 0;
        // gán các phần tử cho arr bằng vòng lặp while
        while (count < n) {
            arr[count++] = random.nextInt(100); // Chon số ngẫu nhiên cho arr
        }

        // Mảng trước khi sắp xếp
        System.out.println("Mảng trước khi sắp xếp:");
        System.out.println(Arrays.toString(arr));

        // Mảng sau khi sắp xếp theo thứ tự tăng dần
        SortArr(arr);
        System.out.println("Mảng sau khi sắp xếp theo thứ tự tăng dần:");
        System.out.println(Arrays.toString(arr));

        // Mảng sau khi loại bỏ phần tử trùng lặp
        int[] NewArr = FindExist(arr);
        System.out.println("Mảng sau khi loại bỏ phần tử trùng lặp:");
        System.out.println(Arrays.toString(NewArr));

    }

    /**
     * Sắp xếp mảng số nguyên theo thứ tự tăng dần
     * 
     * @param arr: Mảng truyền vào
     */
    public static void SortArr(int[] arr) {
        int tmp = arr[0];
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    tmp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = tmp;
                }
            }
        }
    }

    /**
     * Loại bỏ các phần tử trùng lặp trong mảng
     * 
     * @param arr: Mảng truyền vào
     * @return : mảng sau khi đã loại bỏ các phần tử trùng lặp
     */
    public static int[] FindExist(int[] arr) {
        int[] NotExistArr = new int[arr.length];
        int NewArrLength = 0;
        boolean isExist = false;
        for (int i = 0; i < arr.length; i++) {
            isExist = false;
            for (int j = 0; j < NewArrLength; j++) {
                if (arr[i] == NotExistArr[j]) {
                    isExist = true;
                    break;
                }
            }
            if (isExist == false) {
                NotExistArr[NewArrLength++] = arr[i];
            }
        }
        NotExistArr = Arrays.copyOfRange(NotExistArr, 0, NewArrLength);
        return NotExistArr;
    }

}