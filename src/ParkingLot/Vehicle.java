package ParkingLot;

import java.util.ArrayList;

abstract class Vehicle {
    //visible to subclass
    protected int spotNeeded;
    protected SpotType type;
    protected String LicensePlate;

    // the spots that assigned to this v
    protected ArrayList<ParkingSpot> parkingSpots = new ArrayList<>();

    public int getSpotNeeded() {
        return spotNeeded;
    }

    public SpotType getSize() {
        return type;
    }

    public void parkInSpot(ParkingSpot spot) {
        parkingSpots.add(spot);
    }

    public void clearSpots() {
        // remove the v in each old spot assigned to it
        for (int i = 0; i < parkingSpots.size(); i++) {
            parkingSpots.get(i).removeVehicle();
        }
        parkingSpots.clear();
    }

    public abstract boolean canFitSpot(ParkingSpot spot);
    public abstract void print();
}
