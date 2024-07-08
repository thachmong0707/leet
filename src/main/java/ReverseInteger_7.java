import java.util.Arrays;

public class ReverseInteger_7 {
    public static void main(String[] args) {
        int x = 10;
        int reverse = new ReverseInteger_7().reverse(x);
        System.out.println(reverse);
    }
    public int reverse(int x) {
        if(x<Integer.MIN_VALUE || x > Integer.MAX_VALUE){
            return 0;
        }
        boolean positive = x >= 0;
        String s = String.valueOf(Math.abs(x));
        int length = s.length();
        char[] chars = s.toCharArray();
        for(int i = 0; i <= (s.length() / 2) -1; i++){
            char tmp = chars[i];
            chars[i] = chars[length - 1 - i];
            chars[length - 1 - i] = tmp;
        }
        try{
            return (positive ? 1 : -1) * Integer.parseInt(String.valueOf(chars));
        } catch (NumberFormatException e){
            return 0;
        }

    }
}
