package ArrayLishTur;

import java.util.ArrayList;

public class ArrLish {
    public static void main(String[] args) {
        String[] strings = new String[10];
        ArrayList<String> list = new ArrayList<String>();
        list.add("a1");
        list.add("a2");
        list.add("a4");
        System.out.println("arr--- " + strings.length);
        System.out.println("ls--- " + list.size());
        // add vào vị trí tùy chọn
        list.add(2, "a3");

        String s1 = list.get(0);
        String s2 = list.get(list.size() - 1);
        System.out.println("Phần tử đầu tiên--- " + s1);
        System.out.println("Phần tử cuối cùng--- " + s2);
        for (String s : list) {
            System.out.println("In ra toàn bộ phần tử ---" + s);
        }

    }
}