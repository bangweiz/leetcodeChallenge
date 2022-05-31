package SortArrayByParity;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {2,4,1,3};
        int[] res = solution.sortArrayByParity(nums);
        for (int r: res) {
            System.out.println(r);
        }
    }

    public int[] sortArrayByParity(int[] nums) {
        int oddPointer = 0;
        for (int i = 0; i < nums.length; i++) {
            oddPointer = i;
            if (nums[i] % 2 != 0) {
                break;
            }
        }
        int evenPointer = oddPointer;
        while (evenPointer < nums.length && oddPointer < nums.length) {
            if (nums[evenPointer] % 2 == 0 && nums[oddPointer] % 2 != 0) {
                int temp = nums[oddPointer];
                nums[oddPointer] = nums[evenPointer];
                nums[evenPointer] = temp;
                evenPointer++;
                oddPointer++;
            } else {
                if (nums[evenPointer] % 2 != 0) {
                    evenPointer++;
                }
                if (nums[oddPointer] % 2 == 0){
                    oddPointer++;
                }
            }
        }
        return nums;
    }
}
