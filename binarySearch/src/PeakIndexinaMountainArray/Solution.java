package PeakIndexinaMountainArray;

public class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int left = 1;
        int right = arr.length - 2;
        while (left <= right) {
            int mid = (left + right) / 2;
            int l = arr[mid - 1];
            int r = arr[mid + 1];
            int m = arr[mid];
            if (l < m && m > r) {
                return mid;
            } else if (l < m && m < r) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
