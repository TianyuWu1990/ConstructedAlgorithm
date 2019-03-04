package ParkingLot;

public class Motorcycle extends Vehicle{

    public Motorcycle() {
        spotNeeded = 1;
        type = SpotType.MotorCycle;
    }

    @Override
    public boolean canFitSpot(ParkingSpot spot) {
        return true;
    }

    @Override
    public void print() {
        System.out.print("M");
    }
}
