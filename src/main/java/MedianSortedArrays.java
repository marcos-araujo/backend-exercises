import java.util.Arrays;

public class MedianSortedArrays {

    /**
      * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
      */

    public static void main(String[] args) {
        int[] x = new int[]{1,2};
        int[] y = new int[]{3,4};

        System.out.println("Brute Force Solution: " + bruteForceSolution(x,y));
        System.out.println("Two Pointers Solution: " + twoPointersSolution(x,y));
    }

    /**
     * Time Complexity: O(m+n)
     */
    private static double twoPointersSolution(int[] arrayX, int[] arrayY) {
        int totalLength = arrayX.length + arrayY.length;
        int pointerArrayX = 0;
        int pointerArrayY = 0;
        int m1 = 0;
        int m2 = 0;

        for (int count = 0; count <= totalLength / 2; count++) {
            m2 = m1;

            if (pointerArrayX < arrayX.length && (pointerArrayY >= arrayY.length || arrayX[pointerArrayX] <= arrayY[pointerArrayY])) {
                m1 = arrayX[pointerArrayX++];
            } else {
                m1 = arrayY[pointerArrayY++];
            }
        }

        if (totalLength % 2 == 1)
            return m1;

        return (m1 + m2) / 2.0;
    }

    /**
     * Time Complexity: 𝑂((𝑚+𝑛)log(𝑚+𝑛))
     */
    private static double bruteForceSolution(int[] arrayX, int[] arrayY) {
        int[] result = new int[arrayX.length + arrayY.length];
        int k = 0;

        for (int i : arrayX)
            result[k++] = i;
        for (int i : arrayY)
            result[k++] = i;

        Arrays.sort(result);

        if (result.length % 2 == 1)
            return result[result.length / 2];
        else {
            double m1 = result[(result.length / 2) - 1];
            double m2 = result[result.length / 2];
            return (m1 + m2) / 2.0;
        }
    }

}