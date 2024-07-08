public class test {
    public static void main(String[] args) {
        int n = 12;
        long x = 1;
        for (int i = 2; i <= n; i++) {
            x = (x * i) % 10;
        }
        System.out.println(x % 10);
    }

}
