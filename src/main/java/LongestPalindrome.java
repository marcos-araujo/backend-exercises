public class LongestPalindrome {

    /*
    Given a string s, return the longest palindromic substring in s.
     */

    public static void main(String[] args) {
        System.out.println(longestPalindromeBruteForce("cbbd"));
        System.out.println(longestPalindromeExpandAroundCenter("cbbd"));
    }

    private static String longestPalindromeExpandAroundCenter(String str) {

        var maxStr = str.substring(0,1);

        for (int x = 0; x < str.length(); x++) {

            var odd = expandFromCenter(str, x, x);
            var even = expandFromCenter(str, x, x+1);

            if (odd.length() > maxStr.length())
                maxStr = odd;

            if (even.length() > maxStr.length())
                maxStr = even;

        }
        return maxStr;
    }

    private static String expandFromCenter(String str, int left, int right) {
        while (left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
            left--;
            right++;
        }
        return str.substring(left+1, right);
    }

    private static String longestPalindromeBruteForce(String str) {

        var maxStg = str.substring(0,1);

        for (int x = 0; x < str.length(); x++)

            for (int y = x + maxStg.length(); y <= str.length(); y++)

                if (y-x > maxStg.length() && isPalindrome(str.substring(x, y)))
                    maxStg = str.substring(x, y);

        return maxStg;
    }

    private static boolean isPalindrome(String substring) {
        int left = 0;
        int right = substring.length()-1;
        while (left < right) {
            if (substring.charAt(left) != substring.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }

}