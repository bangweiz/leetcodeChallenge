package RemoveDuplicatesfromSortedArray;

public class Solution {
    public int removeDuplicates(int[] nums) {
        int pointer1 = 1;
        int pointer2 = 1;
        while (pointer1 < nums.length) {
            if (nums[pointer1] == nums[pointer2 - 1]) {
                nums[pointer2] = nums[pointer1];
                pointer2++;
            }
            pointer1++;
        }
        return pointer2;
    }
}
