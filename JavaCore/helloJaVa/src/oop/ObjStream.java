package oop;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ObjStream {
    public static void main(String[] args) {
        Student student = new Student("Nguyen Van A", "B19DCCN123", 20200101);
        try {
            FileOutputStream fos = new FileOutputStream("Student.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(student);
            oos.close();
            fos.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}