package org.example;

class Animal{
    Animal(){
        System.out.println("Animal class constructor");
    }
    public void makeSound(){
        System.out.println("Animal make sound");
    }
}
class Dog extends Animal{
    Dog(){
        super(); // call parent class constructor
    }
    public void makeSound(){
        System.out.println("Dog Barks");
        super.makeSound(); // call parent class method
    }
}
public class MethodOverriding {
    public static void main(String[] args) {
        Animal animal = new Animal();
        animal.makeSound();

        // below line demonstrates polymorphism in Java. Here, a reference of the parent class (Animal) is used to hold an object of the child class (Dog).
        // This allows the program to call overridden methods of the child class (Dog) while maintaining a reference to the parent class
        Animal dog = new Dog();
        dog.makeSound();

    }
}
