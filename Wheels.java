public class Wheels {
    private double brakesPower = 0.0;
    private int brakesPowerPercents = 0;

    public void setBrakesPower(double brakesPower) {
        if (brakesPower >=0 && brakesPower <= 1) {
            this.brakesPower = brakesPower;
            this.brakesPowerPercents = (int) brakesPower*100;
        }
    }

    public double getBrakesPower() {
        return this.brakesPower;
    }
    public int getBrakesPowerPercents() {return  this.brakesPowerPercents; }
}
