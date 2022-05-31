package IsSubsequence;

public class Solutions {
    public boolean isSubsequence(String s, String t) {
        int targetPointer = 0;
        int subPointer = 0;

        while (targetPointer < t.length() && subPointer < s.length()) {
            if (t.charAt(targetPointer) == s.charAt(subPointer)) {
                subPointer++;
            }
            targetPointer++;
        }

        return subPointer == s.length();
    }
}
