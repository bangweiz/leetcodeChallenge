package MinimumOperationstoMakeArrayEqual;

public class Solution {
    public int minOperations(int n) {
        int sum = (1 + n * 2 + 1) * n / 2;
        int val = sum / n;
        int half = val * (n / 2);
        int fist = (1 + (n / 2) * 2 + 1) * (n / 2) / 2;
        return half - fist;
    }
}
