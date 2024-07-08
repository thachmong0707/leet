import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ServerTrafficMonitor {

    public static void main(String[] args) {
        System.out.println(getMaxTrafficTime(Arrays.asList(1, 6, 2, 9), Arrays.asList(8, 7, 6, 10)));
    }

    public static int getMaxTrafficTime(List<Integer> starts, List<Integer> ends) {
        Map<Integer, Integer> counts = new TreeMap<>();
        for (int i = 0; i < starts.size(); i++) {
            int s = starts.get(i);
            int e = ends.get(i);
            for (int second = s; second <= e; second++) {
                counts.put(second, counts.getOrDefault(second, 0) + 1);
            }
        }
        int minS = 0;
        int maxTraffic = 0;
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            int s = entry.getKey();
            int c = entry.getValue();
            if (c <= maxTraffic) {
                continue;
            }
            minS = s;
            maxTraffic = c;
        }
        return minS;
    }
}
