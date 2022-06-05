package MinimumInsertionstoBalanceaParenthesestring;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = ")))";
        System.out.println(solution.minInsertions(s));
    }
    public int minInsertions(String s) {
        char[] arr = s.toCharArray();
        int leftParenthesis = 0;
        int rightParenthesis = 0;
        int res = 0;

        for (char c: arr) {
            if (c == '(') {
                if (rightParenthesis == 0) {
                    leftParenthesis++;
                } else {
                    res++;
                    rightParenthesis = 0;
                }
            } else {
                if (leftParenthesis == 0) {
                    leftParenthesis++;
                    rightParenthesis++;
                    res++;
                } else {
                    if (rightParenthesis == 0) {
                        rightParenthesis++;
                    } else {
                        rightParenthesis = 0;
                        leftParenthesis--;
                    }
                }
            }
        }

        res += leftParenthesis * 2 - rightParenthesis;

        return res;
    }
}
