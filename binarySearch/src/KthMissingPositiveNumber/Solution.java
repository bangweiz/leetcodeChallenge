package KthMissingPositiveNumber;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = {1,3,5,6,7};
        System.out.println(s.findKthPositive(arr, 2));
    }

    public int findKthPositive(int[] arr, int k) {
        if (arr[0] - 1 >= k) {
            return k;
        }
        int missingNumCount = arr[arr.length - 1] - arr.length;
        if (missingNumCount < k) {
            return arr[arr.length - 1] + k - missingNumCount;
        }

        int left = 0;
        int right = arr.length - 1;
        while (left < right - 1) {
            int mid = (right + left) / 2;
            int missingNum = arr[mid] - mid - 1;
            if (missingNum >= k) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }

        if (arr[right] - right - 1 < k) {
            return k + right + 1;
        } else {
            return k + left + 1;
        }
    }
}
