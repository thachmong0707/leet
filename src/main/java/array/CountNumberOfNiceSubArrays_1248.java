package array;

import java.util.Arrays;

public class CountNumberOfNiceSubArrays_1248 {

    public static void main(String[] args) {
        int[] nums = {2, 2, 2, 1, 2, 2, 1, 2, 2, 2};
        int i = new CountNumberOfNiceSubArrays_1248().numberOfSubarrays(nums, 2);
        System.out.println(i);
    }

    public int numberOfSubarrays(int[] nums, int k) {
        int rs = 0;
        int[] prefixSum = new int[nums.length];
        int[] replace = new int[nums.length];
        if (nums[0] % 2 == 1) {
            replace[0] = 1;
            prefixSum[0] = 1;
        } else {
            prefixSum[0] = 0;
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] % 2 == 1) {
                replace[i] = 1;
                prefixSum[i] = prefixSum[i - 1] + 1;
            } else {
                prefixSum[i] = prefixSum[i - 1] + 0;
            }
        }
        System.out.println(Arrays.toString(replace));
        System.out.println(Arrays.toString(prefixSum));
        return rs;
    }
}
