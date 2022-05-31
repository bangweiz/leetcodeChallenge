package LongestDuplicateSubstring;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    long[] hash;
    long[] power;
    char[] arr;
    long prime = 97L;

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "dcsopfbhupztcyxctlyxocqwgcgydrxkbbeowdlkcehhslmidwphslbf";
        System.out.println(solution.longestDupSubstring(s));
    }

    public String longestDupSubstring(String s) {
        arr = s.toCharArray();
        hash = new long[arr.length + 1];
        power = new long[arr.length + 1];
        power[0] = 1;
        for (int i = 0; i < arr.length; i++) {
            hash[i + 1] = prime * hash[i] + (arr[i] - 96);
            power[i + 1] = prime * power[i];
        }

        int left = 0;
        int right = arr.length - 1;
        int start = 0;
        int length = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int index = rabinKarp(mid);
            if (index != -1) {
                left = mid + 1;
                start = index;
                length = mid;
            } else {
                right = mid - 1;
            }
        }

        if (length == -1) {
            return "";
        }
        return s.substring(start, start + length);
    }

    private int rabinKarp(int n) {
        Map<Long, List<Integer>> map = new HashMap<>();
        for (int i = n - 1; i < arr.length; i++) {
            long hashValue = hash[i + 1] - power[n] * hash[i + 1 - n];
            List<Integer> list;
            if (map.containsKey(hashValue)) {
                list = map.get(hashValue);
                int index = collision(i, list, n);
                if (index == -1) {
                    list.add(i);
                } else {
                    return index;
                }
            } else {
                list = new ArrayList<>();
                list.add(i);
                map.put(hashValue, list);
            }
        }
        return -1;
    }

    private int collision(int index1, List<Integer> list, int n) {
        for (int index: list) {
            boolean flag = true;
            for (int i = 0; i < n; i++) {
                if (arr[index1 - i] != arr[index - i]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return index1 - n + 1;
            }
        }
        return -1;
    }
}
