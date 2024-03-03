package hard;

public class LargestRectangleInHistogram {
    public static void main(String[] args) {
        int[] heights = {2, 1, 5, 6, 2, 3};
        System.out.println(largestRectangleArea(heights));
    }

    public static int largestRectangleArea(int[] heights) {
        int result = 0;
        for (int i = 0; i < heights.length; i++) {
            if (i + 1 < heights.length && heights[i] <= heights[i + 1]) {
                continue;
            }
            int min = heights[i];
            for (int j = i; j >= 0; j--) {
                min = Math.min(min, heights[j]);
                result = Math.max(result, min * (i - j + 1));
            }
        }
        return result;
    }
}
