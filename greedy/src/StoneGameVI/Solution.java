package StoneGameVI;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] a = {1,2};
        int[] b = {3,1};
        System.out.println(solution.stoneGameVI(a, b));
    }

    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
        int n = aliceValues.length;
        Integer[] sortedIndex = new Integer[n];
        for (int i = 0; i < n; i++) {
            sortedIndex[i] = i;
        }

        Arrays.sort(sortedIndex, (Integer o1, Integer o2) -> -aliceValues[o1] - bobValues[o1] + aliceValues[o2] + bobValues[o2]);

        int alice = 0;
        int bob = 0;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                alice += aliceValues[sortedIndex[i]];
            } else {
                bob += bobValues[sortedIndex[i]];
            }
        }

        return Integer.compare(alice, bob);
    }
}
