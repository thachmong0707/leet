package prefix_sum;

public class CorporateFlightBookings {


    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] flats = new int[n + 1];
        for (int[] booking : bookings) {
            flats[booking[0] - 1] += booking[2];
            flats[booking[1]] -= booking[2];
        }

        int[] res = new int[n];
        res[0] = flats[0];
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] + flats[i];
        }
        return res;
    }
}
