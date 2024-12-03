import java.util.Arrays;

public class MedianSortedArrays {

    /*
    Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
     */

    public static void main(String[] args) {
        int[] x = new int[]{1,2};
        int[] y = new int[]{3,4};

        System.out.println(findMedianSortedArraysBruteForce(x,y));
        System.out.println(findMedianSortedArraysTwoPointers(x,y));
    }

    private static double findMedianSortedArraysTwoPointers(int[] arrayX, int[] arrayY) {
        int resultLength = arrayX.length + arrayY.length;
        int[] result = new int[resultLength];

        int pointerArrayX = 0;
        int pointerArrayY = 0;
        int m1 = 0;
        int m2 = 0;

        for (int count = 0; count <= resultLength / 2; count++) {

            m2 = m1;

            if (pointerArrayX != arrayX.length && pointerArrayY != arrayY.length)
                if (arrayX[pointerArrayX] > arrayY[pointerArrayY])
                    m1 = arrayY[pointerArrayY++];
                else
                    m1 = arrayX[pointerArrayX++];
            else
                if (pointerArrayX < arrayX.length)
                    m1 = arrayX[pointerArrayX++];
                else
                    m1 = arrayY[pointerArrayY++];
        }

        if (result.length % 2 == 1)
            return m1;

        return (m1 + m2) / 2.0;
    }

    private static double findMedianSortedArraysBruteForce(int[] arrayX, int[] arrayY) {

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