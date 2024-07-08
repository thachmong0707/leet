package array;

import java.util.Arrays;

public class HeightChecker_1051 {
    public int heightChecker(int[] heights) {
        int total = 0;
        int[] sortedIds = heights.clone();
        Arrays.sort(sortedIds);
        for (int i = 0; i < heights.length; i++) {
            if (sortedIds[i] != heights[i]) {
                total++;
            }
        }
        return total;
    }
}
