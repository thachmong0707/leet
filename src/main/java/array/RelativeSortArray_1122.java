package array;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class RelativeSortArray_1122 {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int i : arr1) {
            counts.merge(i, 1, Integer::sum);
        }
        int[] rs = new int[arr1.length];
        int idx = 0;
        for (int i : arr2) {
            Integer count = counts.get(i);
            for (int j = 1; j <= count; j++) {
                rs[idx] = i;
                idx++;
            }
            counts.remove(i);
        }
        Set<Integer> remainings = new TreeSet<>(counts.keySet());
        for (Integer i : remainings) {
            Integer count = counts.get(i);
            for (int j = 1; j <= count; j++) {
                rs[idx] = i;
                idx++;
            }
            counts.remove(i);
        }
        return rs;
    }
}
