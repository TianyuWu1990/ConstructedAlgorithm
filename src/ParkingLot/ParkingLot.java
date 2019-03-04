package ParkingLot;

/**
 * 设计一个停车场
 *
 * 一共有n层，每层m列，每列k个位置
 * 2.停车场可以停摩托车，公交车，汽车
 * 3.停车位分别有摩托车位，汽车位，大型停车位
 * 4.每一列，摩托车位编号范围为[0,k/4)(注：包括0，不包括k/4),汽车停车位编号范围为[k/4,k/4*3),大型停车位编号范围为[k/4*3,k)
 * 5.一辆摩托车可以停在任何停车位
 * 6.一辆汽车可以停在一个汽车位或者大型停车位
 * 7.一辆公交车可以停在一列里的连续5个大型停车位。
 */


public class ParkingLot {
    private Level[] levels;
    private int NUM_LEVELS;

    /**
     * Construct a parking lot with information of num of floor, num of row, and num of spot in a row
      * @param floor
     * @param num_rows
     * @param spots_per_row
     */
    public ParkingLot(int floor, int num_rows, int spots_per_row) {
        NUM_LEVELS = floor;
        levels = new Level[NUM_LEVELS];
        for (int i = 0; i < NUM_LEVELS; i++) {
            // pass parking lot info to each level
            levels[i] = new Level(floor, num_rows, spots_per_row);
        }
    }

    /**
     * API for parking a vehicle
     * @param vehicle parking lot has the info of a vehicle
     * @return true if parked successfully, otherwise, return false
     */
    public boolean parkVehicle(Vehicle vehicle) {
        for (int i = 0; i < levels.length; i++) {
            // check with each level if the vehicle can be parked
            if (levels[i].parkVehicle(vehicle)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Clear occupied spots of this vehicle
     * @param vehicle
     */
    public void unParkVehicle(Vehicle vehicle) {
        vehicle.clearSpots();
    }

    /**
     * print the current info of the lot
     */
    public void print() {
        // iterate each level
        for (int i = 0; i < levels.length; i++) {
            System.out.print("Level " + i + ": ");
            levels[i].print();
            System.out.println("");
        }
        System.out.println("");
    }
}
