package array;

public class AverageWaitingTime_1701 {
    public double averageWaitingTime(int[][] customers) {
        double totalSupportTime = customers[0][1];
        int timeToDone = customers[0][0] + customers[0][1];

        for (int i = 1; i < customers.length; i++) {
            int[] customer = customers[i];
            int arri = customer[0];
            int wait = customer[1];
            if (arri > timeToDone) {
                timeToDone = arri + wait;
                totalSupportTime += wait;
            } else {
                timeToDone += wait;
                totalSupportTime += (timeToDone - arri);
            }
        }
        return totalSupportTime / customers.length;
    }
}
