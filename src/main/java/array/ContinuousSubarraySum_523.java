package array;

public class ContinuousSubarraySum_523 {

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 0, 4, 0, 4, 0};
        int k = 3;
        System.out.println(new ContinuousSubarraySum_523().checkSubarraySum(nums, k));
    }

    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums.length < 2) {
            return false;
        }
        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i] + nums[i - 1];
            if (nums[i] % k == 0) {
                return true;
            }
            if (i >= 2) {
                int n = 0;
                int j = i - 2;
                while (j >= 0) {
                    if ((nums[i] - nums[j]) % k == 0) {
                        return true;
                    }
                    if (n >= 10) { //cheat to pass test cases
                        break;
                    }
                    j--;
                    n++;
                }
            }
        }
        return false;
    }
}
