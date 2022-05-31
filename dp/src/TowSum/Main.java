package TowSum;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {3,3};
        int[] res = solution.twoSum(nums, 6);
        System.out.println(res[0]);
        System.out.println(res[1]);
    }
}
