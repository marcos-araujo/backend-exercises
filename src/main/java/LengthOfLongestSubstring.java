import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LengthOfLongestSubstring {

    /**
      * Given a string s, find the length of the longest substring without repeating characters.
      */

    public static void main(String[] args) {
        String input = "pwwkew";
        System.out.println("Map Solution: " + mapSolution(input));
        System.out.println("Set Solution: " + setSolution(input));
    }

    /**
     * Time Complexity: O(n)
     */
    public static int mapSolution(String s) {
        int maxLength = 0;
        Map<Character, Integer> charIndexMap = new HashMap<>();
        int start = 0;

        for (int end = 0; end < s.length(); end++) {
            char currentChar = s.charAt(end);

            if (charIndexMap.containsKey(currentChar))
                start = Math.max(start, charIndexMap.get(currentChar) + 1);

            charIndexMap.put(currentChar, end);

            maxLength = Math.max(maxLength, end - start + 1);
        }

        return maxLength;
    }

    /**
     * Time Complexity: O(n)
     */
    public static int setSolution(String s) {
        int n = s.length();
        int maxLength = 0;
        Set<Character> charSet = new HashSet<>();
        int start = 0;

        for (int end = 0; end < n; end++) {
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

}
