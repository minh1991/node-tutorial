package oop;

import java.util.Calendar;

public class Student {
    public String name;
    public String code;
    public int birthday;

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

    // show Studen info
    public void showInfo() {
        System.out.println("student.birthday---" + this.getBirthday());
        System.out.println("student.name---" + this.getName());
        System.out.println("student.code---" + this.getCode());
        System.out.println("student.age---" + this.getAge());
    }
}