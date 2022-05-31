package MatrixBlockSum;

public class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int[][] prefixSum = new int[mat.length][mat[0].length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                prefixSum[i][j] = mat[i][j] + (j == 0 ? 0 : prefixSum[i][j - 1]);
            }
        }

        int[][] res = new int[mat.length][mat[0].length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                int lowerR = Math.max(i - k, 0);
                int upperR = Math.min(i + k, mat.length - 1);
                int lowerC = Math.max(j - k, 0);
                int upperC = Math.min(j + k, mat[0].length - 1);
                for (int index = lowerR; index <= upperR; index++) {
                    res[i][j] += prefixSum[index][upperC] - (lowerC == 0 ? 0 : prefixSum[index][lowerC - 1]);
                }
            }
        }
        return res;
    }
}
