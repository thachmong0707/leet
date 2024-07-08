package math;

public class SumOfSquareNumbers_633 {

    public static void main(String[] args) {
        boolean b = new SumOfSquareNumbers_633().judgeSquareSum(8);
        System.out.println(b);
    }

    public boolean judgeSquareSum(int c) {
        //c - b2 = a2
        // a >= 0 && b >= 0
        // a = c - b2
        // (a+b)2 = a2 + b2 + 2ab
        // (a+b)2 - 2ab = c
        // a+b = can2 c -2ab
        // c >= 2ab
        // a2 = c - b2
        long l = 0, r = (long) Math.sqrt(c);
        while (l <= r) {
            if (l * l + r * r == c) return true;
            if (l * l + r * r > c) r--;
            else l++;
        }
        return false;
    }
}
