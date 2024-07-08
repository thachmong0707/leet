package array;

public class GrumpyBookstoreOwner_1052 {
    public static void main(String[] args) {
        int minutes = 2;
        int[] nums = {2, 4, 1, 4, 1};
        int[] grum = {1, 0, 1, 0, 1};
        int i = new GrumpyBookstoreOwner_1052().maxSatisfied(nums, grum, minutes);
        System.out.println(i);
    }

    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int totalCustomers = 0;
        int length = customers.length;
        int maxGrumpy = 0;
        for (int i = 0; i < length; i++) {
            if (grumpy[i] == 0) {
                totalCustomers += customers[i];
                continue;
            }
            int end = Math.min(i + minutes, length);
            int val = sumGrumpy(customers, grumpy, i, end);
            maxGrumpy = maxGrumpy < val ? val : maxGrumpy;
        }
        return totalCustomers + maxGrumpy;
    }

    private int sumGrumpy(int[] cus, int[] grump, int start, int end) {
        int rs = 0;
        for (int i = start; i < end; i++) {
            if (grump[i] == 1) {
                rs += cus[i];
            }
        }
        return rs;
    }
}
