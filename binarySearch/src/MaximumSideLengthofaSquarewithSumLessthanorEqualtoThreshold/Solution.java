package MaximumSideLengthofaSquarewithSumLessthanorEqualtoThreshold;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] mat = {{1,1,3,2,4,3,2},{1,1,3,2,4,3,2},{1,1,3,2,4,3,2}};
        int k = 16;
        System.out.println(solution.maxSideLength(mat, k));
    }

    public int maxSideLength(int[][] mat, int threshold) {
        int[][] sum = new int[mat.length][mat[0].length];
        for (int i = 0; i < mat.length; i++) {
            sum[i][0] = mat[i][0];
            for (int j = 1; j < mat[i].length; j++) {
                sum[i][j] = mat[i][j] + sum[i][j - 1];
            }
        }

        int left = 1;
        int right = Math.min(mat.length, mat[0].length);
        while (left < right - 1) {
            int mid = (left + right) / 2;
            if (isValid(mid, sum, threshold)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }

        boolean v1 = isValid(left, sum, threshold);
        boolean v2 = isValid(right, sum, threshold);

        if (v1 && v2) {
            return right;
        } else if (v1 && !v2) {
            return left;
        } else {
            return 0;
        }
    }

    private boolean isValid(int length, int[][] sum, int target) {
        for (int j = length - 1; j < sum[0].length; j++) {
            int total = 0;
            for (int i = 0; i < length; i++) {
                total += sum[i][j] - (j - length < 0 ? 0 : sum[i][j - length]);
            }
            if (target >= total) {
                return true;
            }
            for (int i = length; i < sum.length; i++) {
                total += sum[i][j] - (j - length < 0 ? 0 : sum[i][j - length]);
                total -= (sum[i - length][j] - (j - length < 0 ? 0 : sum[i - length][j - length]));
                if (target >= total) {
                    return true;
                }
            }
        }
        return false;
    }
}
