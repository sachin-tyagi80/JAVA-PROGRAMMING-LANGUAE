// Abstraction
abstract class Animal {
    // Encapsulation
    private String name;

    // Constructor
    Animal(String name) {
        this.name = name;
    }

    // Getter
    public String getName() {
        return name;
    }

    // Abstract method
    abstract void sound();
}

// Inheritance
class Dog extends Animal {

    Dog(String name) {
        super(name);
    }

    // Polymorphism (Method Overriding)
    @Override
    void sound() {
        System.out.println(getName() + " says Woof Woof");
    }
}

public class Demo {
    public static void main(String[] args) {

        // Polymorphism
        Animal a = new Dog("Tommy");

        a.sound();
    }
}