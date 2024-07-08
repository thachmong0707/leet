package math;

public class RomanToInteger_13 {
    public int romanToInt(String s) {
        int rs = 0;
        int old = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int curValue = get(c);
            rs += curValue;
            if (old != 0) {
                if (old < curValue) {
                    rs -= 2 * old;
                }
            }
            old = curValue;
        }
        return rs;
    }

    public static int get(char c) {
        switch (c) {
            case 'M':
                return 1000;
            case 'D':
                return 500;
            case 'C':
                return 100;
            case 'L':
                return 50;
            case 'X':
                return 10;
            case 'V':
                return 5;
            case 'I':
                return 1;
        }
        return 0;
    }
}
