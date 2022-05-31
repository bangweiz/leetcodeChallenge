package GroupAnagrams;

import java.util.*;

public class Solution {
    int[] primes = {2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97,101};

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Long, List<String>> map = new HashMap<>();
        for (String s: strs) {
            long hashKey = getHashKey(s);
            if (map.containsKey(hashKey)) {
                map.get(hashKey).add(s);
            } else {
                List<String> list = new ArrayList<>();
                list.add(s);
                map.put(hashKey, list);
            }
        }
        List<List<String>> res = new ArrayList<>();
        for (Map.Entry<Long, List<String>> integerListEntry : map.entrySet()) {
            res.add(integerListEntry.getValue());
        }
        return res;
    }

    private long getHashKey(String s) {
        char[] arr = s.toCharArray();
        long res = 1;
        for (char c: arr) {
            res *= primes[c - 97];
        }
        return res;
    }
}
