package BrickWall;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> map = new HashMap<>();
        for (List<Integer> integers : wall) {
            int sum = 0;
            for (int j = 0; j < integers.size() - 1; j++) {
                sum += integers.get(j);
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
        int res = wall.size();
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            res = Math.min(wall.size() - entry.getValue(), res);
        }
        return res;
    }
}
