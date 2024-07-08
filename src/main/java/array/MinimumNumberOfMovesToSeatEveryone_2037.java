package array;

import java.util.Arrays;

public class MinimumNumberOfMovesToSeatEveryone_2037 {

    public int minMovesToSeat(int[] seats, int[] students) {
        int rs = 0;
        Arrays.sort(seats);
        Arrays.sort(students);
        for (int i = 0; i < seats.length; i++) {
            rs += Math.abs(seats[i] - students[i]);
        }
        return rs;
    }
}
