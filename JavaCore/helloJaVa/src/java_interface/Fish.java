package java_interface;

public class Fish implements Animal {

    @Override
    public void move() {
        // TODO Auto-generated method stub
        System.out.println("Fish is swimming");
    }

    @Override
    public void eat() {
        // TODO Auto-generated method stub
        System.out.println("Fish like Jun");

    }

    @Override
    public void sleep() {
        // TODO Auto-generated method stub
        System.out.println("Fish sleep when she is dont move");
    }

}