package CountPairsOfNodes;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 4;
        int[][] edges = {{1,2},{2,4},{1,3},{2,3},{2,1}};
        int[] queries = {2,3};
        int[] res = solution.countPairs(n, edges, queries);
        for (int r: res) {
            System.out.println(r);
        }
    }
    public int[] countPairs(int n, int[][] edges, int[] queries) {
        int[] degrees = new int[n];
        int[] res = new int[queries.length];
        Map<Integer, Integer> edgeCount = new HashMap<>();

        for (int[] edge: edges) {
            degrees[edge[0] - 1] += 1;
            degrees[edge[1] - 1] += 1;
            int key = (Math.max(edge[0], edge[1]) - 1) * n + Math.min(edge[0], edge[1]) - 1;
            edgeCount.put(key, edgeCount.getOrDefault(key, 0) + 1);
        }
        int[] sortedDegrees = degrees.clone();
        Arrays.sort(sortedDegrees);

        for (int i = 0; i < queries.length; i++) {
            int curr = 0;
            int left = 0;
            int right = n - 1;
            while (left < right) {
                if (sortedDegrees[left] + sortedDegrees[right] > queries[i]) {
                    curr += right - left;
                    right--;
                } else {
                    left++;
                }
            }
            for (int e : edgeCount.keySet()) {
                int u = e / n;
                int v = e % n;
                if (degrees[u] + degrees[v] > queries[i] && degrees[u] + degrees[v] - edgeCount.get(e) <= queries[i])
                    curr--;
            }

            res[i] = curr;
        }
        return res;
    }
}
