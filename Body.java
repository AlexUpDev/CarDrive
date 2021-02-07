import java.util.*;

public class Body {
    private double weight;
    private double resist = 0.0;

    public Body(double weight) {
        this.weight = weight;
    }

    public double getWeight() {
        return this.weight;
    }

    public double getResist(double speed) {

        List<ResistRate> rates = this.getResistRates();

        for (ResistRate r : rates) {
            if (speed > r.fromSpeed && speed < r.toSpeed) {
                this.resist = r.resist;
            }

        }

        return this.resist;
    }

    private List<ResistRate> getResistRates() {
        List rates = new ArrayList<ResistRate>();
        rates.add(new ResistRate(0.05, -20.0, -10.0));
        rates.add(new ResistRate(0.00, -9.99, 0.0));
        rates.add(new ResistRate(0.00, 0.0, 9.99));
        rates.add(new ResistRate(0.05, 10.0, 19.99));
        rates.add(new ResistRate(0.11, 20.0, 29.99));
        rates.add(new ResistRate(0.17, 30.0, 39.99));
        rates.add(new ResistRate(0.24, 40.0, 49.99));
        rates.add(new ResistRate(0.32, 50.0, 59.99));
        rates.add(new ResistRate(0.41, 60.0, 69.99));
        rates.add(new ResistRate(0.49, 70.0, 79.99));
        rates.add(new ResistRate(0.57, 80.0, 89.99));
        rates.add(new ResistRate(0.66, 90.0, 99.99));
        rates.add(new ResistRate(0.77, 100.0, 109.99));
        rates.add(new ResistRate(0.79, 110.0, 119.99));
        rates.add(new ResistRate(0.82, 120.0, 129.99));
        rates.add(new ResistRate(0.96, 130.0, 139.99));
        rates.add(new ResistRate(1.11, 140.0, 149.99));
        rates.add(new ResistRate(1.27, 150.0, 159.99));
        rates.add(new ResistRate(1.43, 160.0, 169.99));
        rates.add(new ResistRate(1.61, 170.0, 179.99));
        rates.add(new ResistRate(1.80, 180.0, 189.99));
        rates.add(new ResistRate(2.00, 190.0, 200.00));


        return rates;
    }

    private class ResistRate {

        private double resist;
        private double fromSpeed;
        private double toSpeed;

        private ResistRate(double resist, double fromSpeed, double toSpeed) {
            this.resist = resist;
            this.fromSpeed = fromSpeed;
            this.toSpeed = toSpeed;
        }
    }
}
