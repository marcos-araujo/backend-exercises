import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

    /*
    Given an array of integers and an integer target, return indices of the two numbers such that they add up to target.
    You may assume that each input would have exactly one solution, and you may not use the same element twice.
    You can return the answer in any order.
     */

    public static void main(String[] args) {
        int[] array = {2, 7, 11, 15};
        int target = 9;

        int[] bruteForceResult = bruteForce(array, target);
        int[] twoPassResult = twoPassHashTable(array, target);
        int[] onePassResult = onePassHashTable(array, target);

        System.out.println("Brute Force: " + Arrays.toString(bruteForceResult));
        System.out.println("Two-Pass Hash Table: " + Arrays.toString(twoPassResult));
        System.out.println("One-Pass Hash Table: " + Arrays.toString(onePassResult));
    }

    /**
     * Brute force solution
     * Time Complexity: O(n^2)
     */
    private static int[] bruteForce(int[] nums, int target) {
        for (int i = 0; i < nums.length - 2; i++)
            for (int j = i + 1; j < nums.length - 1; j++)
                if (nums[i] + nums[j] == target)
                    return new int [] {i, j};

        return null;
    }

    /**
     * Two-pass hash table solution
     * Time Complexity: O(n)
     */
    private static int[] twoPassHashTable(int[] nums, int target) {
        var hashMap = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++)
            hashMap.put(nums[i], i);

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (hashMap.containsKey(complement) && hashMap.get(complement) != i)
                return new int [] {i, hashMap.get(complement)};
        }

        return null;
    }

    /**
     * One-pass hash table solution
     * Time Complexity: O(n)
     */
    private static int[] onePassHashTable(int[] nums, int target) {
        var hashMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (hashMap.containsKey(complement))
                return new int [] {hashMap.get(complement), i};
            hashMap.put(nums[i],i);
        }

        return null;
    }

}