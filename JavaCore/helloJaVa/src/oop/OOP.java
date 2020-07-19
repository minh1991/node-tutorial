package oop;

public class OOP {
    public static void main(String[] args) {
        Student student_1 = new Student();
        Student student_2 = new Student();

        student_1.setBirthday(1994);
        student_1.setCode("S001");
        student_1.setName("John");

        student_1.showInfo();
        student_1.getAge();

        Teacher teacher_1 = new Teacher();
        Teacher teacher_2 = new Teacher();
    }
}
