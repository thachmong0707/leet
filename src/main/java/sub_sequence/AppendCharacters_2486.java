package sub_sequence;

public class AppendCharacters_2486 {

    public int appendCharacters(String s, String t) {
        int cursor = 0;
        for (int i = 0; i < s.length(); i++) {
            if (cursor == t.length()) {
                return 0;
            }
            if (s.charAt(i) == t.charAt(cursor)) {
                cursor++;
            }
        }
        return t.length() - cursor;
    }
}
