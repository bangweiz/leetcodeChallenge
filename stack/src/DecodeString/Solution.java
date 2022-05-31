package DecodeString;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        Solution solution =  new Solution();
        String s = "3[a]2[bc]";
        System.out.println(solution.decodeString(s));
    }

    public String decodeString(String s) {
        int p = 0;
        char[] arr = s.toCharArray();
        Stack<Integer> numStack = new Stack<>();
        Stack<Character> charStack = new Stack<>();
        while (p < arr.length) {
            if (arr[p] >= 48 && arr[p] <= 57) {
                StringBuilder sbNum = new StringBuilder();
                sbNum.append(arr[p++]);
                while (p < arr.length && arr[p] >= 48 && arr[p] <= 57) {
                    sbNum.append(arr[p++]);
                }
                numStack.push(Integer.parseInt(sbNum.toString()));
            } else if (arr[p] == ']'){
                List<Character> list = new ArrayList<>();
                while (true) {
                    char temp = charStack.pop();
                    if (temp != '[') {
                        list.add(temp);
                    } else {
                        int repeat = numStack.pop();
                        for (int i = 1; i <= repeat; i++) {
                            for (int j = list.size() - 1; j >= 0; j--) {
                                charStack.push(list.get(j));
                            }
                        }
                        break;
                    }
                }
                p++;
            } else {
                charStack.push(arr[p++]);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Character character : charStack) {
            sb.append(character);
        }
        return sb.toString();
    }
}
