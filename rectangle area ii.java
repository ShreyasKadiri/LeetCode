class Solution {
    long mod = (long)1e9+7;
    public int rectangleArea(int[][] rectangles) {
        long result = 0;
        for (int rectangle[] : rectangles){
            result+= calculateArea(rectangle[0], rectangle[1], rectangle[2], rectangle[3]);
        }
        for (int i=0; i<rectangles.length; i++){
            long overlap = overlap(rectangles, rectangles[i], i+1);
            result = (result - overlap+mod)%mod;
        }
        return (int)result;
    }
    
    public long calculateArea(int x1, int y1, int x2, int y2){
        return (long)(x2-x1)*(y2-y1);
    }
    
    public long overlap(int[][] rectangles, int[] a, int index){
        if (index == rectangles.length) {
            return 0;
        }
        int[] b = rectangles[index++];
        int left = Math.max(a[0], b[0]);
        int right = Math.min(a[2], b[2]);
        int down = Math.max(a[1], b[1]);
        int up = Math.min(a[3], b[3]);
        if (left>=right || up<=down){
            return overlap(rectangles, a, index);
        }
        long result = calculateArea(left, down, right, up);
        if (a[0] < b[0]){
            result = (result + overlap(rectangles, new int[]{a[0], a[1], b[0], a[3]}, index))%mod;
        }
        if (b[2]<a[2]){
            result = (result+overlap(rectangles, new int[]{b[2], a[1], a[2], a[3]}, index))%mod;
        }
        if (a[1]<b[1]){
            result = (result+overlap(rectangles, new int[]{left, a[1], right, b[1]}, index))%mod;
        }
        if (b[3]<a[3]){
            result = (result+overlap(rectangles, new int[]{left, b[3], right, a[3]}, index))%mod;
        }
        return result;
    }
}
