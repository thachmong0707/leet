package array;

public class SortColors_75 {
    public void sortColors(int[] nums) {
        int start0 = 0;
        int start2 = nums.length - 1;
        for (int i = 0; i <= start2; i++) {
            if (nums[i] == 0) {
                //swap with end of list
                nums[i] = nums[start0];
                nums[start0] = 0;
                start0++;
                i--;
            } else if (nums[i] == 2) {
                //swap with end of list
                nums[i] = nums[start2];
                nums[start2] = 2;
                start2--;
                i--;
            }
        }
    }
}
