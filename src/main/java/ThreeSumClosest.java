import java.util.Arrays;

public class ThreeSumClosest {

    /*
    Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.
    Return the sum of the three integers.
    You may assume that each input would have exactly one solution.
     */

    public static void main(String[] args) {
        System.out.print(solutionThreePointer(new int[] {-1,2,1,-4}, 1));
    }

    public static int solutionThreePointer(int[] array, int target) {



        Arrays.sort(array);
        int closest = array[0] + array[1] + array[2];

        for (int x = 0; x < array.length - 2; x++) {

            int left = x+1;
            int right = array.length-1;

            while (left < right) {

                int currentSum = array[x] + array[left] + array[right];

                if (currentSum == target)
                    return currentSum;

                if (Math.abs(currentSum - target) < Math.abs(closest - target))
                    closest = currentSum;

                if (currentSum < target)
                    left++;
                else
                    right--;
            }

        }

        return closest;
    }

}
