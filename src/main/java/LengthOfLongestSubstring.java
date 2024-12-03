import java.util.HashSet;

public class LengthOfLongestSubstring {

    /*
        Given a string s, find the length of the longest substring without repeating characters.
    */

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstringSet("pwwkew"));
    }

    public static int lengthOfLongestSubstringSet(String s) {
        var myHash = new HashSet<Character>();
        int left = 0;
        int length = 0;

        for (int right = 0; right < s.length(); right++) {

            if (!myHash.contains(s.charAt(right))) {
                myHash.add(s.charAt(right));
                length = Math.max(length, right - left + 1);
            } else {
                while (myHash.contains(s.charAt(right))) {
                    myHash.remove(s.charAt(left));
                    left++;
                }
                myHash.add(s.charAt(right));
            }
        }

        return length;
    }

}
