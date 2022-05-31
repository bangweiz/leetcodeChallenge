package MinimumLengthofStringAfterDeletingSimilarEnds;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "aaaaa";
        System.out.println(solution.minimumLength(s));
    }
    public int minimumLength(String s) {
        char[] arr = s.toCharArray();
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            if (start == end) {
                return 1;
            } else if (arr[start] != arr[end]) {
                return end - start + 1;
            } else {
                while (start < end && arr[start] == arr[start + 1]) {
                    start++;
                }
                while (start < end && arr[end] == arr[end - 1]) {
                    end--;
                }
                start++;
                end--;
            }
        }
        return 0;
    }
}
