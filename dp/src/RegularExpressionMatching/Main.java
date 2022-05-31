package RegularExpressionMatching;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        String str = "aasdfasdfasdfasdfas";
        String pattern = "aasdf.*asdf.*asdf.*asdf.*s";
//        String str = "baabbbaccbccacacc";
//        String pattern = "c*..b*a*a.*a..*c";
//        String str = "aabb";
//        String pattern = "a*";
        System.out.println(s.isMatch(str, pattern));
    }
}
