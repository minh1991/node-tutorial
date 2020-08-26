package java_interface;

public class Dog implements Animal {

    @Override
    public void move() {
        // TODO Auto-generated method stub
        System.out.println("Dogs move by his hands");
    }

    @Override
    public void eat() {
        // TODO Auto-generated method stub
        System.out.println("Cat eat rices");
    }

    @Override
    public void sleep() {
        // TODO Auto-generated method stub
        System.out.println("Dog sleep in daylight");

    }

}