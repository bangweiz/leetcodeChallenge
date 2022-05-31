package DifferentWaystoAddParentheses;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String exp = "2*3-4*5";
        System.out.println(solution.diffWaysToCompute(exp));
    }

    public List<Integer> diffWaysToCompute(String expression) {
        int n = expression.length();
        List<Integer> operators = new ArrayList<>();
        List<Integer> nums = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char c = expression.charAt(i);
            if (c == '*' || c == '+' || c == '-') {
                operators.add(i);
                nums.add(Integer.parseInt(builder.toString()));
                builder = new StringBuilder();
            } else {
                builder.append(c);
            }
        }
        nums.add(Integer.parseInt(builder.toString()));

        return helper(expression, 0, nums.size() - 1, operators, nums);
    }

    private List<Integer> helper(String exp, int start, int end, List<Integer> operators, List<Integer> nums) {
        List<Integer> list = new ArrayList<>();
        if (start == end) {
            list.add(nums.get(start));
            return list;
        }
        for (int i = start; i < end; i++) {
            List<Integer> left = helper(exp, start, i, operators, nums);
            List<Integer> right = helper(exp, i + 1, end, operators, nums);
            cal(left, right, exp.charAt(operators.get(i)), list);
        }
        return list;
    }

    private void cal(List<Integer> left, List<Integer> right, char operator, List<Integer> list) {
        switch (operator) {
            case '*' -> {
                for (int l : left) {
                    for (int r : right) {
                        list.add(l * r);
                    }
                }
            }
            case '+' -> {
                for (int l : left) {
                    for (int r : right) {
                        list.add(l + r);
                    }
                }
            }
            default -> {
                for (int l : left) {
                    for (int r : right) {
                        list.add(l - r);
                    }
                }
            }
        }
    }
}
