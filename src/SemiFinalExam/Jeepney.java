package semifinal;

public class Jeepney extends Ride implements StudentDiscount {
    public Jeepney(String passenger, double km) {
        super(passenger, km);
    }

    @Override
    public double fare() {
        if (getKm() <= 4) {
            return 13.00; // Base fare for first 4 km
        }
        return 13.00 + (getKm() - 4) * 2.25; // Additional per km charge
    }

    @Override
    public String vehicle() {
        return "Jeepney";
    }

    @Override
    public double discountedFare() {
        return fare() * 0.80; // 20% discount for students
    }
}