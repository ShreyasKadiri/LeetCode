class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        int firstTerm = arr[0];
        int secondTerm = arr[1];
        int difference = secondTerm - firstTerm;
        for(int i=1; i<arr.length; i++){
            if(arr[i] - arr[i-1]!=difference){
                return false;
            }
        }
        return true;
    }
}
