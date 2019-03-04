package ParkingLot;

public class Car extends Vehicle{

    public Car() {
        spotNeeded = 1;
        type = SpotType.Compact;
    }

    @Override
    public boolean canFitSpot(ParkingSpot spot) {
        return spot.getSize() == SpotType.Compact || spot.getSize() == SpotType.Large;
    }

    @Override
    public void print() {
        System.out.print("C");
    }
}
