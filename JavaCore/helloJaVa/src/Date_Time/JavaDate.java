package Date_Time;

import java.text.SimpleDateFormat;
import java.util.Date;

public class JavaDate {
    public static void main(String[] args) {
        // thời gian hiện tại
        Date now = new Date();
        System.out.println("now - Date()--- " + now);
        // tính mili giây
        long nowInMs_01 = now.getTime(); // sử dụng Date
        long nowInMs_02 = System.currentTimeMillis(); // sử dụng currentTimeMillis
        System.out.println("nowInMs_01 - getTime()--- " + nowInMs_01);
        System.out.println("nowInMs_02 - currentTimeMillis()--- " + nowInMs_02);
        // Tính thời điểm này ngày mai
        Date tomorrow = new Date(nowInMs_01 + (24 * 60 * 60 * 1000));
        System.out.println("tomorrow--- " + tomorrow);
        // Tính thời điểm này hôm qua
        Date afterDay = new Date(nowInMs_01 - (24 * 60 * 60 * 1000));
        System.out.println("afterDay--- " + afterDay);
        // SimpleDateFormat
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("E dd/MM/YYYY");
        String myTime = simpleDateFormat.format(now);
        System.out.println("SimpleDateFormat--- " + myTime);
        // cover string to Date
        Date CovedTime;
        String inputTime = "11/09/2020";
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("dd/MM/yyyy");
        try {
            CovedTime = simpleDateFormat2.parse(inputTime);
            System.out.println(inputTime);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}