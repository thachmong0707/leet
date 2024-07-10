package array;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CrawlerLogFolder_1598 {
    public int minOperations(String[] logs) {
        List<String> files = new ArrayList<>();
        for (int i = 0; i < logs.length; i++) {
            if (Objects.equals(logs[i], "./")) {
                continue;
            }
            if (Objects.equals(logs[i], "../")) {
                if (!files.isEmpty()) {
                    files.remove(files.size() - 1);
                }
                continue;
            }
            files.add(logs[i]);
        }
        return files.size();
    }
}
