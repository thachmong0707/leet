package string;

import java.util.List;


public class ReplaceWords_648 {
    public String replaceWords(List<String> dictionary, String sentence) {
        String[] arrays = sentence.split(" ");
        String rs = "";
        for (String word : arrays) {
            rs += " " + getRoot(word, dictionary);
        }

        return rs.trim();
    }

    private String getRoot(String word, List<String> dictionary) {
        for (String dic : dictionary) {
            String afDic = dic;
            if (dic.length() > 3 && dic.charAt(dic.length() - 1) == dic.charAt(dic.length() - 2) && isAOE(dic.charAt(dic.length() - 3))) {
                afDic = dic.substring(0, dic.length() - 1);
            }
            if (word.startsWith(afDic)) {
                return afDic;
            }
        }
        return word;
    }

    private boolean isAOE(char c) {
        return c == 'a'
                || c == 'e'
                || c == 'i'
                || c == 'o'
                || c == 'u';
    }
}
