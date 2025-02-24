// Parent class demonstrating Abstraction

abstract class Vehicle {
    String brand;

    // Constructor
    public Vehicle(String brand) {
        this.brand = brand;
    }

    // Abstract method to be implemented by child classes
    abstract void start();
}


//Child Class demonstrating Inheritance 
class Car extends Vehicle{
    int speed;
    public Car(String brand,int speed) {
            super(brand);
            this.speed = speed;
        }
        //now we will implement abstract method 
        @Override
        public void start(){
            System.out.println(brand + " Car is starting at speed:  " + speed + " km/h");    
        }
}

//Another class demonstrating Composition 

class Engine{
    void engineType(){
        System.out.println("This is a Petrol Engine");
    }
}

class Bike extends Vehicle{

    Engine engine; //Composition

    public Bike(String brand){
        super(brand);
        this.engine =new Engine(); //Creating a new Engine Instance inside Bike.. 
    }
    @Override
    public void start(){
        System.out.println(brand + " Bike is Starting");
        engine.engineType();
    }
}

public class InheritanceExample{
    public static void main(String[] args) {
        Car car = new Car("Ferrari", 290);
        car.start(); 

        Bike bike = new Bike("Harley-Davidson");
        bike.start();
    }
}
