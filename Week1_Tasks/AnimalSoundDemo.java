abstract class Animal {
    abstract void makeSound();
}

class Dog extends Animal {
    @Override
    void makeSound() {
        System.out.println("The dog is barking.");
    }
}

public class AnimalSoundDemo {
    public static void main(String[] args) {
        Animal dog = new Dog();
        dog.makeSound();
    }
}