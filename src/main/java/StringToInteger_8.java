import java.util.Arrays;
import java.util.List;

public class StringToInteger_8 {

    public static void main(String[] args) {
        String s = "9223372036854775808";

//        s = s.replaceAll(s.substring(s.indexOf(".")), "");
        int i = new StringToInteger_8().myAtoi(s);
        System.out.println(i);
    }

    public int myAtoi(String s) {
        long res = 0;
        int pos = 1;
        boolean first = true;
        List<Character> nums = Arrays.asList('0', '1', '2', '3', '4', '5', '6', '7', '8', '9');
        for (char c : s.toCharArray()) {
            if (c == ' ' && first) {
                continue;
            }
            if (first) {
                first = false;
                if (c == '+' || c == '-') {
                    if (c == '-') {
                        pos = -1;
                    }
                    continue;
                }
            }
            if (!nums.contains(c)) {
                return (int) (pos * res);
            }
            res = res * 10 + (c - '0');
            if (res > Integer.MAX_VALUE) {
                return pos == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
        }
        return (int) (res * pos);
    }
}
