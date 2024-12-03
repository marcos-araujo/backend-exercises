public class ContainerWithMostWater {

    /*
    You are given an integer array height of length n.
    There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
    Find two lines that together with the x-axis form a container, such that the container contains the most water.
    Return the maximum amount of water a container can store.
    */

    public static void main(String[] args) {
        System.out.println(solution(new int[] {1,8,6,2,5,4,8,3,7}));
    }

    private static int solution(int[] height) {

        int left = 0;
        int right = height.length-1;
        int maxArea = 0;
        int currentArea = 0;

        while (left < right) {

            currentArea = Math.min(height[left], height[right]) * (right - left);
            maxArea = Math.max(maxArea,currentArea);

            if (height[left] < height[right])
                left++;
            else
                right--;
        }

        return maxArea;
    }

}
