package KthAncestorofaTreeNode;

public class TreeAncestor {
    public static class Start {
        public static void main(String[] args) {
            int[] parent = {-1,0,0,1,1,2,2};
            TreeAncestor tree = new TreeAncestor(parent.length, parent);
            System.out.println(tree.getKthAncestor(3, 1));
        }
    }

    private int[][] dp;

    public TreeAncestor(int n, int[] parent) {
        int m = (int) (Math.log(1.0 * n) / Math.log(2));
        dp = new int[n][m + 1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = parent[i];
        }
        for (int j = 1; j <= m; j++) {
            for (int i = 0; i < n; i++) {
                dp[i][j] = dp[i][j - 1] == -1 ? -1 : dp[dp[i][j - 1]][j - 1];
            }
        }
    }

    public int getKthAncestor(int node, int k) {
        while (k > 0) {
            int index = (int) (Math.log(1.0 * k) / Math.log(2));
            int m = (int) Math.pow(2, index);
            if (index >= dp[0].length || node < 0) {
                return -1;
            }
            k -= m;
            node = dp[node][index];
        }
        return node;
    }
}
