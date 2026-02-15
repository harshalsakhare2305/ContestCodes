//https://leetcode.com/problems/design-ride-sharing-system/

//Got one TLE prev i was just using linkedlist so its taking lot of time while deleting because  i was allowing extraa occ of riders and drivers 

class RideSharingSystem {

    LinkedList<Integer> rider;
    LinkedList<Integer> driver;

    HashSet<Integer> riderSet;
    HashSet<Integer> driverSet;

    public RideSharingSystem() {
        rider = new LinkedList<>();
        driver = new LinkedList<>();
        riderSet = new HashSet<>();
        driverSet = new HashSet<>();
    }

    public void addRider(int riderId) {
        if (riderSet.add(riderId)) {   // O(1)
            rider.addLast(riderId);
        }
    }

    public void addDriver(int driverId) {
        if (driverSet.add(driverId)) { // O(1)
            driver.addLast(driverId);
        }
    }

    public int[] matchDriverWithRider() {
        if (rider.isEmpty() || driver.isEmpty())
            return new int[]{-1, -1};

        int r = rider.removeFirst();
        int d = driver.removeFirst();

        riderSet.remove(r);
        driverSet.remove(d);

        return new int[]{d, r};
    }

    public void cancelRider(int riderId) {
        if (riderSet.remove(riderId)) { // O(1)
            rider.remove(Integer.valueOf(riderId)); // O(n) but rare
        }
    }
}
