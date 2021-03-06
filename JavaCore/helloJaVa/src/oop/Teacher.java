package oop;

import java.util.Calendar;

public class Teacher {
    public String name;
    public String code;
    public int birthday;
    public double salary;

    // CONSTRUCTOR START

    public Teacher(String vName, String vCode, int vBirthday) {
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

    public void setSalary(double vSalary) {
        this.salary = vSalary;
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

    public double getSalary() {
        return this.salary;
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
        System.out.println("Teacher Info: ");
        System.out.println("Teacher.birthday---" + this.getBirthday());
        System.out.println("Teacher.name---" + this.getName());
        System.out.println("Teacher.code---" + this.getCode());
        System.out.println("Teacher.age---" + this.getAge());
    }
}