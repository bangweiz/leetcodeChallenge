package ThekStrongestValuesinanArray;

import java.util.Arrays;

public class Solution {
    public int[] getStrongest(int[] arr, int k) {
        Arrays.sort(arr);
        int n = arr.length;
        int[] res = new int[k];
        int median = arr[(n - 1) / 2];
        int left = 0;
        int right = n - 1;
        int p = 0;

        while (p < k) {
            int leftVal = Math.abs(arr[left] - median);
            int rightVal = Math.abs(arr[right] - median);
            if (leftVal > rightVal) {
                res[p] = arr[left];
                left++;
            } else {
                res[p] = arr[right];
                right--;
            }
            p++;
        }

        return res;
    }
}
