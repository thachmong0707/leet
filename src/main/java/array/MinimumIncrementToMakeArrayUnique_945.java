package array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MinimumIncrementToMakeArrayUnique_945 {

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 2, 1, 7};
        int i = new MinimumIncrementToMakeArrayUnique_945().minIncrementForUnique(nums);
        System.out.println(i);
    }

    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);
        Set<Integer> same = new HashSet<>();
        int min = 0;
        int numBefore = -1;
        int maxVal = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != numBefore && !same.contains(nums[i])) {
                numBefore = nums[i];
                maxVal = numBefore;
                same.add(numBefore);
                continue;
            }
            int jump = Math.abs(maxVal - nums[i]) + 1;
            while (jump < Integer.MAX_VALUE) {
                if (same.contains(jump + nums[i])) {
                    jump++;
                    continue;
                }
                min += jump;
                numBefore = nums[i] + jump;
                maxVal = numBefore;
                same.add(numBefore);
                break;
            }
        }
        return min;
    }

    public int minIncrementForUniqueV2(int[] nums) {
        Arrays.sort(nums);
        int min = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) {
                min += nums[i - 1] - nums[i] + 1;
                nums[i] = nums[i - 1] + 1;
            }
        }
        return min;
    }
}
