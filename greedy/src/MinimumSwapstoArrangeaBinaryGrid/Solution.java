package MinimumSwapstoArrangeaBinaryGrid;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] grid = {{1,0,0,0},{1,1,1,1},{1,0,0,0},{1,0,0,0}};
        System.out.println(solution.minSwaps(grid));
    }

    public int minSwaps(int[][] grid) {
        Set<Integer> set = new HashSet<>();
        int[] row = new int[grid.length];
        for (int i = 0; i < grid.length; i++) {
            int zeroCount = countZero(grid[i]);
            int rowNum = grid.length - 1 - zeroCount;
            while (set.contains(rowNum)) {
                rowNum++;
            }
            if (rowNum >= grid.length) {
                return -1;
            }
            set.add(rowNum);
            row[rowNum] = i;
        }
        return countStep(row);
    }

    private int countZero(int[] arr) {
        int res = 0;
        for (int i = arr.length - 1; i > 0; i--) {
            if (arr[i] == 0) {
                res++;
            } else {
                return res;
            }
        }
        return res;
    }

    private int countStep(int[] arr) {
        int res = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    res++;
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }

        return res;
    }
}
