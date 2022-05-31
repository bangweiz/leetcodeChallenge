package MinimumFallingPathSum;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] matrix = { {2, 1, 3}, {6, 5, 4}, {7, 8, 9} };
        System.out.println(solution.minFallingPathSum(matrix));
    }
}
