package NumberofDigitOne;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countDigitOne(120));
    }
    public int countDigitOne(int n) {
        long res = 0;

        int powerIndex = 0;
        while (true) {
            long power = (long) Math.pow(10, powerIndex);
            long power1 = power * 10;
            long remainder = n % power1;
            long leadNum = n / power1;
            long temp = remainder / power;

            if (temp < 1) {
                res += leadNum * power;
            } else if (temp == 1) {
                res += leadNum * power + remainder % power + 1;
            } else {
                res += (leadNum + 1) * power;
            }
            if (leadNum == 0) {
                break;
            }

            powerIndex++;
        }

        return (int) res;
    }
}
