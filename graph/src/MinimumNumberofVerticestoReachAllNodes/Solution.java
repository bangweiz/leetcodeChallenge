package MinimumNumberofVerticestoReachAllNodes;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        List<Integer> res = new ArrayList<>();
        boolean[] hasInEdge = new boolean[n];
        for (List<Integer> edge: edges) {
            hasInEdge[edge.get(1)] = true;
        }
        for (int i = 0; i < n; i++) {
            if (!hasInEdge[i]) {
                res.add(i);
            }
        }
        return res;
    }
}
