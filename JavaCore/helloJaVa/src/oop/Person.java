package oop;

import java.util.Calendar;

public class Person {
    public String name;
    public String code;
    public int birthday;

    // CONSTRUCTOR START

    public Person(String vName, String vCode, int vBirthday) {
        this.name = vName;
        this.code = vCode;
        this.birthday = vBirthday;
    }

    // CONSTRUCTOR END
    // setter
    public void setName(String vName) {
        this.name = vName;
    }

    public void setCode(String vCode) {
        this.code = vCode;
    }

    public void setBirthday(int vBirthday) {
        this.birthday = vBirthday;
    }

    // getter
    public String getName() {
        return this.name;
    }

    public String getCode() {
        return this.code;
    }

    public int getBirthday() {
        return this.birthday;
    }

    public int getAge() {
        int age = 0;
        Calendar nowCalendar = Calendar.getInstance();
        // System.out.println(nowCalendar.get(Calendar.YEAR)); --- 2020
        age = nowCalendar.get(Calendar.YEAR) - this.getBirthday();
        return age;
    }

    // show Person info
    public void showInfo() {
        System.out.println("Person Info: ");
        System.out.println("birthday---" + this.getBirthday());
        System.out.println("name---" + this.getName());
        System.out.println("code---" + this.getCode());
        System.out.println("age---" + this.getAge());
        System.out.println("------------------------------------");
    }
}