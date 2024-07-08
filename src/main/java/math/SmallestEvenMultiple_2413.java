package math;

public class SmallestEvenMultiple_2413 {
    public int smallestEvenMultiple(int n) {
        if (n % 2 == 0 && n % n == 0) {
            return n;
        }
        return n * 2;
    }
}
