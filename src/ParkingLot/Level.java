package ParkingLot;

/**
 * Level --> ParkingLot
 */
public class Level {
    private int floor;
    private ParkingSpot[] spots;
    private int availableSpots = 0;
    private int SPOTS_PER_ROW;

    /**
     * Construct a level with info of floor, num of row, and num of spot in each row
     * @param fl
     * @param num_rows
     * @param spots_per_row
     */
    public Level(int fl, int num_rows, int spots_per_row) {
        floor = fl;
        SPOTS_PER_ROW = spots_per_row;
        int spotIndex = 0;
        // create one array of parkingspot for this level
        spots = new ParkingSpot[num_rows * spots_per_row];
        // distribute different kind of type ParkingSpot to the array
        for (int row = 0; row < num_rows; ++row) {
            // [0, 1/4) motorcycle
            for (int spot = 0; spot < spots_per_row / 4; ++spot) {
                SpotType type = SpotType.MotorCycle;
                spots[spotIndex] = new ParkingSpot(this, row, spotIndex, type);
                spotIndex ++;
            }
            // [1/4, 3/4) car
            for (int spot = spots_per_row / 4; spot < spots_per_row / 4 * 3; ++spot) {
                SpotType type = SpotType.Compact;
                spots[spotIndex] = new ParkingSpot(this, row, spotIndex, type);
                spotIndex ++;
            }
            // [3/4, 1] bus
            for (int spot = spots_per_row / 4 * 3; spot < spots_per_row; ++spot) {
                SpotType type = SpotType.Large;
                spots[spotIndex] = new ParkingSpot(this, row, spotIndex, type);
                spotIndex ++;
            }
        }
        availableSpots = spotIndex;
    }

    /**
     * park a vehicle on this level
     * @param vehicle
     * @return true if parked successfully
     */
    public boolean parkVehicle(Vehicle vehicle) {
        // validation is not neccesary if theres no enough space at this level
        if (availableSpots() < vehicle.getSpotNeeded()) {
            return false;
        }
        // ge the spot number that the vehicle assigned
        int spotNumber = findAvailableSpots(vehicle);
        if (spotNumber < 0) {
            return false;
        }
        return parkStartingAtSpot(spotNumber, vehicle);
    }

    /**
     * remove the spots that v took before, then assign each new spot to this v
     * @param spotNumber
     * @param vehicle
     * @return
     */
    private boolean parkStartingAtSpot(int spotNumber, Vehicle vehicle) {
        vehicle.clearSpots();
        boolean success = true;
        for (int i = spotNumber; i < spotNumber + vehicle.getSpotNeeded(); i++) {
            success &= spots[i].park(vehicle);
        }
        availableSpots -= vehicle.spotNeeded;
        return success;
    }

    /**
     * after removing the v from the spot, free that spot
     */
    public void spotFreed() {
        availableSpots ++;
    }

    public int availableSpots() {
        return availableSpots;
    }

    /**
     *  locate available spot number for the vehicle
     * @param vehicle
     * @return spot number
     */
    private int findAvailableSpots(Vehicle vehicle) {
        int spotsNeeded = vehicle.getSpotNeeded();
        int last_checked_row = -1;
        int spotsFound = 0;

        for (int i = 0; i < spots.length; i++) {
            // validate each spot in this level according to consecutiveness and spot type
            ParkingSpot spot = spots[i];
            // spotsFound must in same row
            if (last_checked_row != spot.getRow()) {
                spotsFound = 0;
                last_checked_row = spot.getRow();
            }
            // validate the spot type
            // double validation: v.canfitspot + spot.canfitvehicle
            if (spot.canFitVehicle(vehicle)) {
                spotsFound ++;
            } else {
                spotsFound = 0;
            }
            // return the spot index
            if (spotsFound == spotsNeeded) {
                return i - spotsNeeded + 1;
            }
        }
        return -1;
    }

    public void print() {
        int last_checked_row = -1;
        for (int i = 0; i < spots.length; i++) {
            ParkingSpot spot = spots[i];
            if (spot.getRow() != last_checked_row) {
                System.out.print("  ");
                last_checked_row = spot.getRow();
            }
            spot.print();
        }
    }
}
