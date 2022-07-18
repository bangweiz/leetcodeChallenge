package ThousandSeparator;

public class Solution {
    public String thousandSeparator(int n) {
        return helper(n);
    }

    public String helper(int n) {
        if (n < 1000) {
            return "" + n;
        }
        int remainder = n % 1000;
        String prefix = helper(n / 1000);
        if (remainder < 10) {
            return prefix + ".00" + remainder;
        } else if (remainder < 100) {
            return prefix + ".0" + remainder;
        }
        return prefix + "." +remainder;
    }
}
