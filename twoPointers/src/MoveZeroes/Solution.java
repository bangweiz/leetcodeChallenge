package MoveZeroes;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {2,1};
        solution.moveZeroes(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }
    public void moveZeroes(int[] nums) {
        int pz = 0;
        int pn = 0;
        while (pz < nums.length && pn < nums.length) {
            if (nums[pz] == 0 && nums[pn] != 0) {
                nums[pz] = nums[pn];
                nums[pn] = 0;
            }
            if (pz == pn && nums[pz] != 0) {
                pz++;
                pn++;
            } else {
                if (nums[pn] == 0) {
                    pn++;
                }
                if (nums[pz] != 0) {
                    pz++;
                }
            }
        }
    }
}
