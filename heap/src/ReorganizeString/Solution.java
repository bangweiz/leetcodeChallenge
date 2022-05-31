package ReorganizeString;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "aabbcc";
        System.out.println(solution.reorganizeString(s));
    }
    public String reorganizeString(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<Character> heap = new PriorityQueue<>((Character a, Character b) -> {
            int ac =map.get(a);
            int bc = map.get(b);
            return ac == bc ? a - b : bc -ac;
        });
        heap.addAll(map.keySet());
        StringBuilder sb = new StringBuilder();
        while (heap.size() > 1) {
            char firstV = heap.poll();
            char nextV = heap.poll();
            int firstC = map.get(firstV);
            int nextC = map.get(nextV);
            sb.append(firstV);
            sb.append(nextV);
            firstC--;
            nextC--;
            if (firstC > 0) {
                map.replace(firstV, firstC);
                heap.add(firstV);
            }
            if (nextC > 0) {
                map.replace(nextV, nextC);
                heap.add(nextV);
            }
        }
        if (heap.size() == 1) {
            char v = heap.poll();
            int c = map.get(v);
            if (c == 1) {
                sb.append(v);
            } else {
                return "";
            }
        }

        return sb.toString();
    }
}
