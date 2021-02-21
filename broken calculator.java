class Solution {
    public int brokenCalc(int X, int Y) {
        int minimumOperations =0;
        if(X==Y){
            return 0;
        }
        if(X>Y){
            return X-Y;
        }
        return 1 + (Y%2==0 ? brokenCalc(X,Y/2) : brokenCalc(X, Y+1));
    }
}
