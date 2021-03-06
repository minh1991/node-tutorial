package oop;

import java.io.Serializable;

public class Student extends Person implements Serializable {

    public Student(String vName, String vCode, int vBirthday) {
        super(vName, vCode, vBirthday);
    }

    public double score;

    // setter
    public void setScore(double vScore) {
        this.score = vScore;
    }

    // getter
    public double getScore() {
        return this.score;
    }

    public void showInfo() {
        super.showInfo();
        System.out.println("Score---" + this.getScore());

    }

}