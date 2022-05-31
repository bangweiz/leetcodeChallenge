package TrappingRainWater;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(solution.trap(height));
    }

    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int res = 0;
        int prevHeight = 0;

        while (left < right) {
            int h = Math.min(height[left], height[right]);
            if (h > prevHeight) {
                for (int i = left + 1; i < right; i++) {
                    if (height[i] < h) {
                        if (height[i] >= prevHeight) {
                            res += h - height[i];
                        } else {
                            res += h - prevHeight;
                        }
                    }
                }
                prevHeight = h;
            }
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return res;
    }
}
