package DetectCyclesin2DGrid;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] grid = {{'a','a','a','b'},{'b','a','b','b'},{'b','b','b','b'}};
        System.out.println(solution.containsCycle(grid));
    }

    public boolean containsCycle(char[][] grid) {
        int[][] visited = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(dfs(grid, visited, i , j, 1)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] grid, int[][] visited, int i, int j, int cur) {
        if (visited[i][j] > 0) {
            return false;
        }
        visited[i][j] = cur;

        int leftJ = j - 1;
        if (leftJ >= 0 && grid[i][j] == grid[i][leftJ]) {
            if (visited[i][leftJ] > 0) {
                if (cur - visited[i][leftJ] >= 3) {
                    return true;
                }
            } else if (dfs(grid, visited, i, leftJ, cur + 1)) {
                return true;
            }
        }

        int rightJ = j + 1;
        if (rightJ < grid[i].length && grid[i][j] == grid[i][rightJ]) {
            if (visited[i][rightJ] > 0) {
                if (cur - visited[i][rightJ] >= 3) {
                    return true;
                }
            } else if (dfs(grid, visited, i, rightJ, cur + 1)) {
                return true;
            }
        }

        int upI = i - 1;
        if (upI >= 0 && grid[i][j] == grid[upI][j]) {
            if (visited[upI][j] > 0) {
                if (cur - visited[upI][j] >= 3) {
                    return true;
                }
            } else if (dfs(grid, visited, upI, j, cur + 1)) {
                return true;
            }
        }

        int downI = i + 1;
        if (downI < grid.length && grid[i][j] == grid[downI][j]) {
            if (visited[downI][j] > 0) {
                if (cur - visited[downI][j] >= 3) {
                    return true;
                }
            } else if (dfs(grid, visited, downI, j, cur + 1)) {
                return true;
            }
        }
        return false;
    }
}
