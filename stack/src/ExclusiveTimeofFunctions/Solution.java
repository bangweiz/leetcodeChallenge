package ExclusiveTimeofFunctions;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 2;
        String[] logs = {"0:start:0","0:start:2","0:end:5","1:start:6","1:end:6","0:end:7"};
        int[] res = solution.exclusiveTime(n, new ArrayList<>(List.of(logs)));
        for (int r: res) {
            System.out.println(r);
        }
    }
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<List<Integer>> stack = new Stack<>();
        int[] res = new int[n];
        for (String log: logs) {
            String[] logArr = log.split(":", 3);
            int id = Integer.parseInt(logArr[0]);
            int time = Integer.parseInt(logArr[2]);
            List<Integer> list = new ArrayList<>();
            if (logArr[1].equals("start")) {
                if (!stack.isEmpty()) {
                    List<Integer> prev = stack.pop();
                    prev.set(2, prev.get(2) + time - prev.get(1));
                    stack.push(prev);
                }
                list.add(id);
                list.add(time);
                list.add(0);
                stack.push(list);
            } else {
                List<Integer> prev = stack.pop();
                res[id] += prev.get(2) + time - prev.get(1) + 1;
                if (!stack.isEmpty()) {
                    prev = stack.pop();
                    prev.set(1, time + 1);
                    stack.push(prev);
                }
            }
        }

        return res;
    }

}
