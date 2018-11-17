package model;

public class Car {

    private String name;
    private int aero, chassis, motor;

    public Car(String name, int aero, int chassis, int motor) {
        this.name = name;
        this.aero = aero;
        this.chassis = chassis;
        this.motor = motor;
    }

    public String getName() {
        return name;
    }

    public int getAero() {
        return aero;
    }

    public int getChassis() {
        return chassis;
    }

    public int getMotor() {
        return motor;
    }
}
