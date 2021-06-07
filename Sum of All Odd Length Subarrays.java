//Time Complexity o(n3)
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

//Time Complexity o(n2)
//Prefix Sum
class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int result = 0;
        for (int i=0; i<arr.length; i++){
            int currentSum = 0;
            for (int j=i; j<arr.length; j++){
                currentSum += arr[j];
                if ((j-i+1) % 2 == 1){
                    result += currentSum;
                }
            }
        }
        return result;
    }
}


//Using prefix sum
//Prefix Sum
class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int result = 0;
        int[] prefixSum = new int[arr.length+1];
        for (int i=0; i<arr.length; i++) {
            prefixSum[i+1] = prefixSum[i] + arr[i];
        }
        for (int i=0; i<arr.length; i++){
            for (int j=i+1; j <=arr.length; j+=2) {
                result+= prefixSum[j] - prefixSum[i];
            }
        }
        return result;        
    }
}
