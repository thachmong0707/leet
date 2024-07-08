package prefix_sum;

public class FindThePivotInteger_2485 {
    
    public int pivotInteger(int n) {
        return withPrefixSum(n);
    }

    public int withPrefixSum(int n) {
        int[] prefix = new int[n];
        prefix[0] = 1;
        for (int i = 2; i <= n; i++) {
            prefix[i - 1] = prefix[i - 2] + i;
        }
        int value = 1;
        //check first idx
        if (prefix[0] == prefix[n - 1]) {
            return prefix[0];
        }

        for (int i = 1; i <= n - 1; i++) {
            if (prefix[i] == (prefix[n - 1] - prefix[i - 1])) {
                return prefix[i] - prefix[i - 1];
            }
        }
        return -1;
    }
}
