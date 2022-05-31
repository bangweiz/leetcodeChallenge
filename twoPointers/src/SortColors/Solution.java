package SortColors;

public class Solution {
    public void sortColors(int[] nums) {
        int p1 = 0;
        int p2 = 0;

        for (int i = 0; i <= 1; i++) {
            while (p2 < nums.length) {
                if (p1 == p2 && nums[p1] == i) {
                    p1++;
                } else if (nums[p2] == i){
                    nums[p2] = nums[p1];
                    nums[p1] = i;
                    p1++;
                }
                p2++;
            }
            p2 = p1;
        }
    }
}
