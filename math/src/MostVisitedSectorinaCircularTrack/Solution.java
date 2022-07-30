package MostVisitedSectorinaCircularTrack;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> mostVisited(int n, int[] rounds) {
        List<Integer> list = new ArrayList<>();
        if (rounds[0] <= rounds[rounds.length - 1]) {
            for (int i = rounds[0]; i <= rounds[rounds.length - 1]; i++) {
                list.add(i);
            }
        } else {
            for (int i = 1; i <= rounds[rounds.length - 1]; i++) {
                list.add(i);
            }
            for (int i = rounds[0]; i <= n; i++) {
                list.add(i);
            }
        }
        return list;
    }
}
