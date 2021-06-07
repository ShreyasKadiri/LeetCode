class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int totalSum = 0;
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr.length; j++){
                if((j-i+1) % 2 ==1){
                    totalSum+= findSum(arr, i, j);
                }      
            }
        }
        return totalSum;
    }
    
    public int findSum(int arr[], int i, int j){
        int sum = 0;
        for(int x=i; x<=j; x++){
            sum+=arr[x];
        }
        return sum;
    }
}
