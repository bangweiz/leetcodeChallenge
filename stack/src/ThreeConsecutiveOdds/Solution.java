package ThreeConsecutiveOdds;


import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        Deque<Integer> q = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                while (q.size() > 0) {
                    q.pop();
                }
                continue;
            }
            q.add(i);
            if (q.size() == 3) {
                return true;
            }
        }
        return false;
    }
}
