package Triangle;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(triangle.get(0).get(0));

        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> tempArr = triangle.get(i);
            ArrayList<Integer> res = new ArrayList<>();
            for (int j = 0; j < tempArr.size(); j++) {
                if (j == 0) {
                    res.add(arr.get(j) + tempArr.get(j));
                } else if (j >= arr.size()) {
                    res.add(arr.get(j - 1) + tempArr.get(j));
                } else {
                    res.add(Math.min(arr.get(j), arr.get(j - 1)) + tempArr.get(j));
                }
            }
            arr = res;
        }

        int res = Integer.MAX_VALUE;
        for (int v: arr) {
            res = Math.min(res, v);
        }

        return res;
    }
}
