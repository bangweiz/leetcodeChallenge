package MagneticForceBetweenTwoBalls;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] position = {5,4,3};
        int m = 2;
        System.out.println(solution.maxDistance(position, m));
    }

    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int right = (position[position.length - 1] - position[0]) / (m - 1);
        int left = 1;
        while (left < right - 1) {
            int mid = (right + left) / 2;
            if (isValid(position, m, mid)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        if (isValid(position, m, right)) {
            return right;
        }
        return left;
    }

    private boolean isValid(int[] position, int m, int mid) {
        int prev = position[0];
        int count = 1;
        for (int i = 1; i < position.length; i++) {
            if (count + 1 == m) {
                break;
            }
            if ((position[i] - prev) >= mid) {
                count++;
                prev = position[i];
            }
        }
        if (count + 1 == m) {
            return position[position.length - 1] - prev >= mid;
        }
        return false;
    }
}
