class Solution {
    public double largestTriangleArea(int[][] points) {
        double result = 0;
        for (int[] point : points)
            for (int[] values : points)
                for (int[] value: points)
                    result = Math.max(result, 0.5 * Math.abs(point[0] * values[1] + values[0] * value[1] + value[0] * point[1]- values[0] * point[1] - value[0] * values[1] - point[0] * value[1]));
        return result;
    }
}
