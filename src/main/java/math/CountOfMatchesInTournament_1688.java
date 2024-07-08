package math;

public class CountOfMatchesInTournament_1688 {

    public static void main(String[] args) {
        int i = new CountOfMatchesInTournament_1688().numberOfMatches(7);
        System.out.println(i);
    }

    public int numberOfMatches(int n) {
        if (n <= 1) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        int rs = 0;
        return rs + n / 2 + (n % 2 == 0 ? numberOfMatches(n / 2) : numberOfMatches(n / 2 + 1));
    }
}
