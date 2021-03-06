package NextGreaterElementI;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        return byStack(nums1, nums2);
    }

    // HashMap
    public int[] byHashMap(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[nums1.length];
        Arrays.fill(res, -1);
        for (int i = 0; i < nums2.length; i++) {
            map.put(nums2[i], i);
        }
        for (int i = 0; i < nums1.length; i++) {
            if (map.containsKey(nums1[i])) {
                for (int j = map.get(nums1[i]) + 1; j < nums2.length; j++) {
                    if (nums2[j] > nums1[i]) {
                        res[i] = nums2[j];
                        break;
                    }
                }
            } else {
                res[i] = -1;
            }
        }

        return res;
    }

    // Stack
    public int[] byStack(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] vals = new int[nums2.length];
        Arrays.fill(vals, -1);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums2.length; i++) {
            map.put(nums2[i], i);
            while (!stack.isEmpty()) {
                if (nums2[stack.peek()] < nums2[i]) {
                    vals[stack.pop()] = nums2[i];
                } else {
                    break;
                }
            }
            stack.push(i);
        }
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            if (map.containsKey(nums1[i])) {
                res[i] = vals[map.get(nums1[i])];
            } else {
                res[i] = -1;
            }
        }
        return res;
    }
}
