package WildcardMatching;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String p = "a*b";
        String s = "adceb";
        System.out.println(solution.isMatch(s, p));
    }
}
