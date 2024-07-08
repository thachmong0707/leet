package array;

public class LongestContinuousSubarray_1438 {

    public static void main(String[] args) {
        Object a = null;
        assert a != null : "A Must be not null";
        System.out.println("AHIIIIIII");
    }

    public int longestSubarray(int[] nums, int limit) {
        assert limit > 1;
        int idx = 0;
        int current = 1;
        int max = 1;
        int prefixSum = nums[0] - limit;
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(current, max);
            int val = nums[i] - limit;
            if (Math.abs(prefixSum - val) > limit) {
                prefixSum -= (nums[idx] - limit);
                prefixSum += val;
                idx++;
                continue;
            }
            prefixSum += val;
            current++;
        }
        max = Math.max(current, max);
        return max;
    }
}
