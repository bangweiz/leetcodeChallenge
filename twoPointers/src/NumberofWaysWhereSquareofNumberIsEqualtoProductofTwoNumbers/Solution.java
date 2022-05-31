package NumberofWaysWhereSquareofNumberIsEqualtoProductofTwoNumbers;

import java.util.HashMap;

public class Solution {
    public int numTriplets(int[] nums1, int[] nums2) {
        HashMap<Long, Integer> map = new HashMap<>();
        return helper(nums1, nums2, map) + helper(nums2, nums1, map);
    }

    private int helper(int[] nums1, int[] nums2, HashMap<Long, Integer> map) {
        for (int i = 0; i < nums1.length; i++) {
            for (int j = i + 1; j < nums1.length; j++) {
                long temp = (long) nums1[i] * nums1[j];
                if (map.containsKey(temp)) {
                    int count = map.get(temp);
                    map.replace(temp, count + 1);
                } else {
                    map.put(temp, 1);
                }
            }
        }
        int res = 0;
        for (int j : nums2) {
            long temp = (long) j * j;
            if (map.containsKey(temp)) {
                res += map.get(temp);
            }
        }
        map.clear();
        return res;
    }
}
