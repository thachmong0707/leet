package array;

import java.util.Arrays;

public class MinimumDifferenceBetweenLargestAndSmallestValueInThreeMoves_150 {
    public static void main(String[] args) {
        int[] nums = {9, 48, 92, 48, 81, 31};
        new MinimumDifferenceBetweenLargestAndSmallestValueInThreeMoves_150().minDifference(nums);
    }

    public int minDifference(int[] nums) {
        if (nums.length <= 3) {
            return 0;
        }
        Arrays.sort(nums);
        int min = nums[0];
        int minCount = 1;
        int max = nums[nums.length - 1];
        int maxCount = 1;
        int idxMin = 1;
        int idxMax = nums.length - 2;
        while (idxMin < nums.length) {
            if (nums[idxMin] == min) {
                minCount++;
                idxMin++;
            } else {
                break;
            }
        }
        while (idxMax > 0) {
            if (nums[idxMax] == max) {
                maxCount++;
                idxMax--;
            } else {
                break;
            }
        }
        if (minCount > 3) {
            return nums[nums.length - 4] - min;
        }
        if (maxCount > 3) {
            return max - nums[3];
        }
        int rs = Integer.MAX_VALUE;
        int length = nums.length;
        rs = Math.min(nums[length - 4] - nums[0], rs);
        rs = Math.min(nums[length - 3] - nums[1], rs);
        rs = Math.min(nums[length - 2] - nums[2], rs);
        rs = Math.min(nums[length - 1] - nums[3], rs);
        return rs;
    }
}
