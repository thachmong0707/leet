package prefix_sum;

import java.util.Arrays;

public class FindPivotIndex {

    public int pivotIndex(int[] nums) {
        int[] prefix = new int[nums.length];
        prefix[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefix[i] = nums[i] + prefix[i - 1];
        }
        int leftValue = 0;
        for (int idx = 0; idx < prefix.length; idx++) {
            if (leftValue == (prefix[nums.length - 1] - leftValue - nums[idx])) {
                return idx;
            }
            leftValue = prefix[idx];
        }
        return -1;
    }

    public int pivotIndex1(int[] nums) {
        int s = 0;
        int total = Arrays.stream(nums).sum();
        for (int i = 0; i < nums.length; i++) {
            total = total - nums[i];
            if (s == total) {
                return i;
            }
            s = s + nums[i];
        }
        return -1;
    }
}
