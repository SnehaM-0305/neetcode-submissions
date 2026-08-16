
public class Solution {

    private int[] prevSmaller(int[] heights) {
        int n = heights.length;
        int[] prev = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {

            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }

            prev[i] = stack.isEmpty() ? -1 : stack.peek();

            stack.push(i);
        }

        return prev;
    }

    private int[] nextSmaller(int[] heights) {
        int n = heights.length;
        int[] next = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {

            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }

            next[i] = stack.isEmpty() ? n : stack.peek();

            stack.push(i);
        }

        return next;
    }

    public int largestRectangleArea(int[] heights) {

        int n = heights.length;

        int[] prev = prevSmaller(heights);
        int[] next = nextSmaller(heights);

        int maxArea = 0;

        for (int i = 0; i < n; i++) {

            int width = next[i] - prev[i] - 1;

            int area = heights[i] * width;

            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }

    
}