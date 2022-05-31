package ScrambleString;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s1 = "eebaacbcbcadaaedceaaacadccd";
        String s2 = "eadcaacabaddaceacbceaabeccd";
        System.out.println(solution.isScramble(s1, s2));
    }
}
