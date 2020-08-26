/*
        Đọc vào một dãy số a có n phần tử là các số nguyên. 
        Đếm số lần xuất hiện của từng phần tử trong mảng. 
        In ra phần tử và số lần xuất hiện của phần tử có số lần xuất hiện nhiều nhất trong a.
 */

package Exercises_Part_02.P02;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Nhập vào số phần tử của mảng
        System.out.println("Nhập Chiều dài mảng: ");
        int n = scanner.nextInt();

        // Khởi tạo arr có n phần tử
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Nhập Phần tử thứ " + i + " Của mảng: ");
            arr[i] = scanner.nextInt();
        }
        // in ra mảng đã nhập vào
        // System.out.println(Arrays.toString(arr));

        // Tìm số lần xuất hiện trong mảng
        Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            addElm(map, arr[i]);
        }
        System.out.println("Số lần các phần tử xuất hiện: ");
        for (Integer key : map.keySet()) {
            System.out.printf("%d Xuất hiện %d lần. \n", key, map.get(key));
        }
    }

    /**
     * Thêm phần tử vào map
     * 
     * @param map: giá trị và số lần xuất hiện
     * @param elm: cần thêm vào wordMap
     */
    public static void addElm(Map<Integer, Integer> map, int elm) {
        if (map.containsKey(elm)) {
            int count = map.get(elm) + 1;
            map.put(elm, count);
        } else {
            map.put(elm, 1);
        }
    }
}