package array;

public class ThreeConsecutiveOdds_1550 {
    public boolean threeConsecutiveOdds(int[] arr) {
        int max = 0;
        for (int i : arr) {
            if (i % 2 == 1) {
                max++;
            } else {
                max = 0;
            }
            if (max >= 3) {
                return true;
            }
        }
        return false;
    }
}
