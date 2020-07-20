package oop;

public class OOP {
    public static void main(String[] args) {
        Student student_1 = new Student(null, null, 0);
        Teacher teacher_1 = new Teacher("Tea", "GV001", 1990);

        student_1.setBirthday(1995);
        student_1.setCode("SV001");
        student_1.setName("Perter");
        student_1.setScore(8.1);
        student_1.getAge();
        student_1.showInfo();

        teacher_1.getAge();
        // teacher_1.showInfo();

    }
}
