abstract class Engine {

    public boolean isWorking = false;
    private double power = 0.0;
    private int powerPercents = 0;
    private int maxPower;

    public void startStopEngine(double speed) {
        if (speed == 0) {
            if (this.isWorking == false) {
                this.isWorking = true;
            } else {
                this.isWorking = false;
            }
        }
    }

    public boolean getState() {
        return this.isWorking;
    }
    public String getStateString() {
        if (this.isWorking == true) {
            return "on";
        } else {
            return "off";
        }
    }

    public double getPower() {
        return this.power;
    }

    public void setPower(double power) {
        this.power = power;
        this.powerPercents = (int)this.power*100;
    }

    public void setMaxPower(int maxPower) {
        this.maxPower = maxPower;
    }

    public int getMaxPower() {
        return this.maxPower;
    }

    public int getPowerPercents() {
        return this.powerPercents;
    }

    abstract void increasePower(double value);
    abstract void decreasePower(double value);

}
