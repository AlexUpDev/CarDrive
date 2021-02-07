public class ElectricEngine extends Engine {

    public ElectricEngine(int maxPower) {
        this.setMaxPower(maxPower);
    }

    @Override
    void increasePower(double value) {
        double newPower = this.getPower() + value;
        System.out.println("NewPower: " + newPower);
        if (newPower <= 1) {
            this.setPower(newPower);
        } else {
            this.setPower(1);
        }

    }

    @Override
    void decreasePower(double value) {
        double newPower = this.getPower() - value;
        if (newPower >=0) {
            this.setPower(newPower);
        } else {
            this.setPower(0.0);
        }
    }
}
