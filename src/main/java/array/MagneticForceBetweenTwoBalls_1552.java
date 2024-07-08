package array;

import java.util.Arrays;

public class MagneticForceBetweenTwoBalls_1552 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 7};
        int i = new MagneticForceBetweenTwoBalls_1552().maxDistance(nums, 3);
        System.out.println(i);
    }

    public boolean fn(int[] arr, int m, int mid) {
        int cnt = 1, prev = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - prev >= mid) {
                cnt++;
                prev = arr[i];
            }
        }
        return cnt >= m;
    }

    public int maxDistance(int[] p, int m) {
        Arrays.sort(p);
        int lo = 1, hi = p[p.length - 1] - p[0];
        while (hi - lo > 1) {
            int mid = (lo + hi) / 2;
            if (fn(p, m, mid)) lo = mid;
            else hi = mid - 1;
        }
        if (fn(p, m, hi)) return hi;
        return lo;
    }
}
