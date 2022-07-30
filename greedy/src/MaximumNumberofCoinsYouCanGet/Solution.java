package MaximumNumberofCoinsYouCanGet;

import java.util.Arrays;

public class Solution {
    public int maxCoins(int[] piles) {
        int res = 0;
        int n = piles.length / 3;
        Arrays.sort(piles);
        for (int i = 0; i < n; i++) {
            res += piles[piles.length - i * 2 - 2];
        }
        return res;
    }
}
