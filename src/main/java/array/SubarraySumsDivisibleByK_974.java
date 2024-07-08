package array;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumsDivisibleByK_974 {
    public int subarraysDivByK(int[] nums, int k) {
        int count = 0;
        int ps = 0;
        Map<Integer, Integer> modMap = new HashMap<>();
        modMap.put(0, 1);

        for (int num : nums) {
            ps += num;
            int mod = ps % k;
            if (mod < 0) {
                mod += k;
            }
            if (modMap.containsKey(mod)) {
                count += modMap.get(mod);
                modMap.put(mod, modMap.get(mod) + 1);
            } else {
                modMap.put(mod, 1);
            }
        }

        return count;
    }
}
