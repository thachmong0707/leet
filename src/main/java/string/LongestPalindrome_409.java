package string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestPalindrome_409 {
    public int longestPalindrome(String s) {
        Map<Character, Integer> wordCount = new HashMap<>();
        int length = s.length();
        int i = 0;
        int j = length - 1;
        while (i <= j) {
            if (i == j) {
                wordCount.put(s.charAt(i), wordCount.getOrDefault(s.charAt(i), 0) + 1);
            } else {
                wordCount.put(s.charAt(i), wordCount.getOrDefault(s.charAt(i), 0) + 1);
                wordCount.put(s.charAt(j), wordCount.getOrDefault(s.charAt(j), 0) + 1);
            }
            i++;
            j--;
        }
        int max = 0;
        boolean hasOdd = false;
        for (Map.Entry<Character, Integer> item : wordCount.entrySet()) {
            max += item.getValue() / 2;
            if (item.getValue() % 2 == 1) {
                hasOdd = true;
            }
        }
        return hasOdd ? max * 2 + 1 : max * 2;
    }

    public int longestPalindromeV2(String s) {
        Set<Character> words = new HashSet<>();
        int max = 0;
        int i = 0;
        int j = s.length() - 1;
        while (i <= j) {
            char cI = s.charAt(i);
            char cJ = s.charAt(j);
            if (i == j) {
                if (words.contains(cI)) {
                    max += 2;
                    words.remove(cI);
                    continue;
                }
                words.add(cI);
            } else {
                if (words.contains(cJ)) {
                    max += 2;
                    words.remove(cJ);
                } else {
                    words.add(cJ);
                }
                if (words.contains(cI)) {
                    max += 2;
                    words.remove(cI);
                } else {
                    words.add(cI);
                }
            }
            i++;
            j--;
        }
        return words.size() > 0 ? max + 1 : max;
    }
}
