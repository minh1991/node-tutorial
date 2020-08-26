package java_interface;

public class JavaInterfaceExample {
    public static void main(String[] args) {
        // Animal animal = new Animal();

        var animal2 = new Fish();
        var animal3 = new Cat();
        var animal4 = new Dog();

        animal2.sleep();
        animal3.eat();
        animal4.move();
    }
}