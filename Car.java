import java.awt.*;
import java.lang.reflect.Array;

public class Car {

    private double speed = 0.0;
    //private double resist;

    public Body body;
    public Engine engine;
    public Transmission transmission;
    public Wheels wheels;

    public Car() {
        this.body = new Body(2000.0);
        this.engine = new ElectricEngine(100);
        this.transmission = new Transmission();
        this.wheels = new Wheels();
    }

    public void calculateSpeed() {
        if (this.engine.isWorking) {
            double newSpeed = this.calculateNewSpeed();

            if (this.speed == 0 && newSpeed != 0) {
                if ((this.transmission.getMode() == "D" && newSpeed > 0) ||
                    (this.transmission.getMode() == "R" && newSpeed < 0))
                {
                    this.speed = newSpeed;
                }
            } else if ((this.transmission.getMode() == "D" || this.transmission.getMode() == "N") && this.speed > 0) {
                if (newSpeed <= 200 && newSpeed >= 0) {
                    this.speed = newSpeed;
                } else if (newSpeed > 200) {
                    this.speed = 200;
                } else if (newSpeed < 0) {
                    this.speed = 0;
                }
            } else if ((this.transmission.getMode() == "R" || this.transmission.getMode() == "N") && this.speed < 0) {
                if (newSpeed <= 0 && newSpeed >= -20) {
                    this.speed = newSpeed;
                } else if (newSpeed < -20) {
                    this.speed = -20;
                } else if (newSpeed > 0) {
                    this.speed = 0;
                }
            }
        }
    }

    public double getSpeed() {
        return  this.speed;
    }

    public int getRoundedSpeed() {
        return (int)Math.round(this.speed);
    }

    private double calculateNewSpeed() {

        double newSpeed = 0;
        newSpeed += this.speed;
        if (this.transmission.getMode() == "D") {
            newSpeed += this.engine.getPower() * this.engine.getMaxPower() / 40;
        } else if (this.transmission.getMode() == "R") {
            newSpeed -= this.engine.getPower() * this.engine.getMaxPower() / 40;
        }
        if (this.speed > 0) {
            newSpeed -= this.body.getResist(this.speed);
            newSpeed -= this.wheels.getBrakesPower() * 5;
        } else if (this.speed < 0) {
            newSpeed += this.body.getResist(this.speed);
            newSpeed += this.wheels.getBrakesPower() * 5;
        } else if (this.speed == 0) {
            if (this.transmission.getMode() == "D")  {
                newSpeed -= this.wheels.getBrakesPower() * 5;
            } else if (this.transmission.getMode() == "R") {
                newSpeed += this.wheels.getBrakesPower() * 5;
            }
        }


        return newSpeed;
    }
}