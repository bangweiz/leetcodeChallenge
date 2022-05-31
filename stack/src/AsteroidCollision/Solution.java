package AsteroidCollision;

import java.util.Stack;

public class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int i: asteroids) {
            if (i > 0) {
                stack.push(i);
            } else {
                boolean flag = true;
                while (!stack.isEmpty()) {
                    if (stack.peek() < 0) {
                        break;
                    } else {
                        if (stack.peek() > -i) {
                            flag = false;
                            break;
                        } else if (stack.peek() < -i) {
                            stack.pop();
                        } else {
                            stack.pop();
                            flag = false;
                            break;
                        }
                    }
                }
                if (flag) {
                    stack.push(i);
                }
            }
        }
        int[] res = new int[stack.size()];
        for (int i = res.length - 1; i >= 0; i--) {
            res[i] = stack.pop();
        }
        return res;
    }
}
