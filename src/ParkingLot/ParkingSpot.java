package ParkingLot;

public class ParkingSpot {
    private Vehicle vehicle;
    private SpotType spotType;
    private int row;
    private int spotNumber;
    private Level level;

    /**
     * Construct a parkingspot with geographic and type information 
     * @param lvl
     * @param r
     * @param n
     * @param type
     */
    public ParkingSpot(Level lvl, int r, int n, SpotType type) {
        level = lvl;
        row = r;
        spotNumber = n;
        spotType = type;
    }

    /**
     * the spot is available only if the vehicle is removed
     * @return
     */
    public boolean isAvailable() {
        return vehicle == null;
    }

    /**
     * return true only if it's available and the v can park here ignore the spaces that v takes
     * @param vehicle
     * @return
     */
    public boolean canFitVehicle(Vehicle vehicle) {
        return isAvailable() && vehicle.canFitSpot(this);
    }

    /**
     * fill v in this spot, and assign the spot to vehicle
     * @param v
     * @return
     */
    public boolean park(Vehicle v) {
        if (!canFitVehicle(v)) {
            return false;
        }
        vehicle = v;
        vehicle.parkInSpot(this);
        return true;
    }

    /**
     * recaculate the spots in current level
     */
    public void removeVehicle() {
        level.spotFreed();
        vehicle = null;
    }

    public int getRow() {
        return row;
    }

    public int getSpotNumber() {
        return spotNumber;
    }

    public SpotType getSize() {
        return spotType;
    }

    public void print() {
        if (vehicle == null) {
            if (spotType == SpotType.Compact) {
                System.out.print("c");
            } else if (spotType == SpotType.Large) {
                System.out.print("l");
            } else if (spotType == SpotType.MotorCycle) {
                System.out.print("m");
            }
        } else {
            vehicle.print();
        }
    }
}
