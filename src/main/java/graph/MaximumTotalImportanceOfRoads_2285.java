package graph;

import java.util.PriorityQueue;

public class MaximumTotalImportanceOfRoads_2285 {

    public static void main(String[] args) {
        int[][] roads = {{0, 1}, {1, 2}, {2, 3}, {0, 2}, {1, 3}, {2, 4}};
        int n = 5;
        new MaximumTotalImportanceOfRoads_2285().maximumImportance(n, roads);
    }

    public long maximumImportance(int n, int[][] roads) {
        int[] counts = new int[n];
        for (int[] road : roads) {
            counts[road[0]] += 1;
            counts[road[1]] += 1;
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>(n, (a, b) -> Integer.compare(a[1], b[1]));
        for (int i = 0; i < n; i++) {
            int[] e = {i, counts[i]};
            queue.add(e);
        }
        int[] mapVal = new int[n];
        int val = 1;
        while (!queue.isEmpty()) {
            int[] e = queue.poll();
            mapVal[e[0]] = val;
            val++;
        }
        long rs = 0;
        for (int[] road : roads) {
            rs += mapVal[road[0]] + mapVal[road[1]];
        }
        return rs;
    }
}
