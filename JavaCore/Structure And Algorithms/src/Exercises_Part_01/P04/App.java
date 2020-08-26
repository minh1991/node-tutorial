/**
    Viết chương trình in ra Bảng cửu chương  
 */

package Exercises_Part_01.P04;

public class App {
    public static void main(String[] args) {
        for (int i = 1; i < 10; i++) {
            for (int j = 0; j <= 10; j++) {
                System.out.printf("%2d x %2d = %3d\n", i, j, (i * j));
            }
            System.out.println("______________________________");
        }
    }
}