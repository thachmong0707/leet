package math;

public class PalindromeNumber_9 {

    public static void main(String[] args) {
        boolean palindrome = new PalindromeNumber_9().isPalindrome(121);
        System.out.println(palindrome);
    }

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int temp = x;
        int reverse = 0;
        while (temp > 0) {
            reverse = reverse * 10 + temp % 10;
            temp = temp / 10;
        }
        return x == reverse;
    }
}
