import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class LengthOfLongestSubstring {

    /**
      *  Given a string s, find the length of the longest substring without repeating characters.
      */

    public static void main(String[] args) {
        System.out.println("Set Result: " + setSolution("pwwkew"));
        System.out.println("Set Result: " + hashMapSolution("pwwkew"));
    }

    /**
     * Time Complexity: O(n)
     */
    public static int setSolution(String s) {
        var charSet = new HashSet<Character>();
        int maxLength = 0;
        int start = 0;

        for (int end = 0; end < s.length(); end++) {
            char currentChar = s.charAt(end);

            while (charSet.contains(currentChar)) {
                charSet.remove(s.charAt(start));
                start++;
            }

            charSet.add(currentChar);
            maxLength = Math.max(maxLength, end - start + 1);
        }

        return maxLength;
    }

    /**
     * Time Complexity: O(n)
     */
    public static int hashMapSolution(String s) {
        int maxLength = 0;
        int start = 0;
        Map<Character, Integer> charIndexMap = new HashMap<>();

        for (int end = 0; end < s.length(); end++) {
            char currentChar = s.charAt(end);

            if (charIndexMap.containsKey(currentChar))
                start = Math.max(start, charIndexMap.get(currentChar) + 1);

            charIndexMap.put(currentChar, end);

            maxLength = Math.max(maxLength, end - start + 1);
        }

        return maxLength;
    }

}
