package string;


import java.util.*;

public class MostCommonWord_819 {

    public static void main(String[] args) {
        String p = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] banned = {"hit"};
        System.out.println(new MostCommonWord_819().mostCommonWord(p, banned));
    }

    public String mostCommonWord(String paragraph, String[] banned) {
        String s = paragraph.toLowerCase().replaceAll("[^a-z]", " ").trim().replaceAll(" +", " ");
        String[] words = s.split(" ");
        TreeMap<String, Integer> counts = new TreeMap<>();
        for (String word : words) {
            String s1 = word.replaceAll("[^a-z]", "");
            counts.put(s1, counts.getOrDefault(s1, 0) + 1);
        }
        Set<String> b = new HashSet<>(Arrays.asList(banned));
        String maxStr = "";
        int max = 0;

        for (Map.Entry<String, Integer> wc : counts.entrySet()) {
            if (b.contains(wc.getKey())) {
                continue;
            }
            if (wc.getValue() > max) {
                max = wc.getValue();
                maxStr = wc.getKey();
            }
        }
        return maxStr;
    }
}
