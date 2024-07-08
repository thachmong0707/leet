package string;

import java.util.ArrayList;
import java.util.List;

public class FindCommonCharacters_1002 {

    public static void main(String[] args) {
        String[] s = {"bella", "label", "roller"};
        System.out.println(new FindCommonCharacters_1002().commonChars(s));
    }

    public List<String> commonChars(String[] words) {
        // a - z  :  97 - 122
        char[] first = words[0].toCharArray();
        int i = 1;
        while (i < words.length) {
            first = commonTwoString(first, words[i]);
            i++;
        }
        List<String> rs = new ArrayList<>();
        for (char c : first) {
            if (c == '\0') {
                continue;
            }
            rs.add(String.valueOf(c));
        }
        return rs;
    }

    private char[] commonTwoString(char[] s1, String s2) {
        int i = 0;

        int n = 0;
        char[] rs = new char[s1.length];
        char[] chars = s2.toCharArray();
        while (i < s1.length) {
            int j = 0;
            while (j < s2.length()) {
                if (chars[j] == s1[i]) {
                    rs[n] = s1[i];
                    chars[j] = '\0';
                    n++;
                    break;
                }
                j++;
            }
            i++;
        }
        return rs;
    }
}
