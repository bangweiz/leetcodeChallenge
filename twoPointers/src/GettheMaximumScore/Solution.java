package GettheMaximumScore;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = {2,4,5,8,10};
        int[] nums2 = {4,6,8,9};
        System.out.println(solution.maxSum(nums1, nums2));
    }

    public int maxSum(int[] nums1, int[] nums2) {
        int p1 = 0;
        long sum1 = 0;
        int p2 = 0;
        long sum2 = 0;
        long res = 0;
        long mod = 1000000007;
        while (p1 < nums1.length && p2 < nums2.length) {
            if (nums1[p1] < nums2[p2]) {
                sum1 += nums1[p1++];
            } else if (nums1[p1] > nums2[p2]) {
                sum2 += nums2[p2++];
            } else {
                res += Math.max(sum1, sum2) + nums1[p1];
                p1++;
                p2++;
                sum1 = 0;
                sum2 = 0;
            }
        }
        while (p1 < nums1.length) {
            sum1 += nums1[p1++];
        }
        while (p2 < nums2.length) {
            sum2 += nums2[p2++];
        }
        return (int) ((res + Math.max(sum1, sum2) + mod) % mod);
    }
}
