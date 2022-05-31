package WordBreakII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "catsanddog";
        String[] list = {"cat","cats","and","sand","dog","c","a","t","s","n","d","o","g","ca","at","ts","sa","an","nd","dd","do","og"};
        List<String> wordDick = new ArrayList<>(Arrays.asList(list));
        List<String> res = solution.wordBreak(s, wordDick);
        for (String r: res) {
            System.out.println(r);
        }
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> list = new ArrayList<>();
        HashSet<String> map = new HashSet<>(wordDict);
        helper(s, map, 0, new ArrayList<>(), list);
        return list;
    }

    private void helper(String s, HashSet<String> map, int start, List<String> curList, List<String> list) {
        int n = s.length();
        if (start > n - 1) {
            list.add(buildString(curList));
            return;
        }
        for (int i = start; i < n; i++) {
            String subStr = s.substring(start, i + 1);
            if (map.contains(subStr)) {
                curList.add(subStr);
                helper(s, map, i + 1, curList, list);
                curList.remove(curList.size() - 1);
            }
        }
    }

    private String buildString(List<String> curList) {
        StringBuilder builder = new StringBuilder();
        if (curList.size() > 0) {
            builder.append(curList.get(0));
            for (int i = 1; i < curList.size(); i++) {
                builder.append(" ");
                builder.append(curList.get(i));
            }
        }

        return builder.toString();
    }
}
