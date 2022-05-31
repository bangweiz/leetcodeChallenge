package RangeSumQuery2DImmutable;

public class NumMatrix {
    private int[][] prefixSum;
    public NumMatrix(int[][] matrix) {
        int[][] prefixSum = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                prefixSum[i][j] = matrix[i][j] + (j == 0 ? 0 : prefixSum[i][j - 1]);
            }
        }
        this.prefixSum = prefixSum;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int res = 0;
        for (int i = row1; i <= row2; i++) {
            res += prefixSum[i][col2] - (col1 == 0 ? 0 : prefixSum[i][col1 - 1]);
        }

        return res;
    }
}
