package ProbabilityofaTwoBoxesHavingTheSameNumberofDistinctBalls;

public class Solution {
    double[] factory = {1,1,2,6,24,120,720};

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] balls = {6,6,6,6,6,6,6,6};
        System.out.println(solution.getProbability(balls));
    }

    public double getProbability(int[] balls) {
        int sum = 0;
        for (int ball: balls) {
            sum += ball;
        }
        
        double halfFact = 1;
        for (int i = 2; i <= sum / 2; i++) {
            halfFact *= i;
        }
        
        double total = halfFact;
        for (int i = sum / 2 + 1; i <= sum; i++) {
            total *= i;
        }
        for (int ball : balls) {
            total /= factory[ball];
        }
        double valid = helper(balls, 0, 0, 0, 0, 0, halfFact, sum / 2);

        return valid / total;
    }
    
    private double helper(int[] balls, int start, int dl, int sl, int dr, int sr, double halfFact, int half) {
        if (sl > half || sr > half) {
            return 0;
        }
        if (start == balls.length) {
            if (sl == sr && dl == dr) {
                return halfFact * halfFact;
            }
            return 0;
        }
        double temp = 0;
        for (int i = 0; i <= balls[start]; i++) {
            if (i != 0) {
                sl += i;
                dl++;
            }
            if (i != balls[start]) {
                sr += balls[start] - i;
                dr++;
            }
            temp += helper(balls, start + 1, dl, sl, dr, sr, halfFact, half) / (factory[i] * factory[balls[start] - i]);
            if (i != 0) {
                sl -= i;
                dl--;
            }
            if (i != balls[start]) {
                sr -= balls[start] - i;
                dr--;
            }
        }
        return temp;
    }

}
