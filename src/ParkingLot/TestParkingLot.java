package ParkingLot;
/***
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
import java.util.ArrayList;
import java.util.Random;

public class TestParkingLot {
    public static void main(String[] args) {
        // lot1: 5 floors, 10 rows and 20 spots per row
        ParkingLot lot1 = new ParkingLot(2, 3, 20);
        int carCount = 1100;
        ArrayList<Vehicle> parkedVehicles = new ArrayList<Vehicle>();
        for (int i = 0; i < 10; i++) {
            Vehicle v = getRandomVehicle();
            parkedVehicles.add(v);
            if (lot1.parkVehicle(v)) {
                v.print();
                System.out.println(" parked in");
            } else {
                v.print();
                System.out.println(" failed parking ");
                lot1.print();
            }
        }
        for (int i = 0; i < carCount; i++) {

            int user_story = parkedVehicles.size() > 0 ? getUserStory() : 0;
            switch (user_story) {
                case 0: Vehicle v = getRandomVehicle();
                        parkedVehicles.add(v);
                        if (lot1.parkVehicle(v)) {
                            v.print();
                            System.out.println(" parked in");
                        } else {
                            v.print();
                            System.out.println(" failed parking ");
                            lot1.print();
                        }

                case 1: Vehicle vu = parkedVehicles.remove(getRandom(parkedVehicles.size()));
                        lot1.unParkVehicle(vu);
                        vu.print();
                        System.out.println(" unParked");

            }


        }





    }

    public static Vehicle getRandomVehicle() {
        Random rd = new Random();
        int k = rd.nextInt(3);
        if (k == 0) {
            return new Motorcycle();
        } else if (k == 1) {
            return new Car();
        } else {
            return new Bus();
        }
    }

    public static int getUserStory() {
        Random rd = new Random();
        return rd.nextInt(2);
    }

    public static int getRandom(int bound) {
        Random rd = new Random();
        return rd.nextInt(bound);
    }
}
