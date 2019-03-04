package ParkingLot;

public class Bus extends Vehicle {

    public Bus() {
        spotNeeded = 5;
        type = SpotType.Large;
    }

    @Override
    public boolean canFitSpot(ParkingSpot spot) {
        return spot.getSize() == SpotType.Large;
    }

    @Override
    public void print() {
        System.out.print("B");
    }
}