package InterleavingString;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s1 = "aadbbbaccc123456789sdfgbsdygvdhvyrsvchtsdvgbnsdtyjfcbrasdeuy";
        String s2 = "aadbbbaccc123456789sdfgbsdygvdhvyrsvchtsdvgbnsdtyjfcbrasdeuy";
        String s3 = "aadbbbaccc123456789sdfgbsdygvdhvyaadbbbaccc123456789sdfgbsdygvdhvyrsvchtsdvgbnsdtyjfcbrasdeuyrsvchtsdvgbnsdtyjfcbrasdeuy";
        System.out.println(solution.isInterleave(s1, s2, s3));
    }
}
