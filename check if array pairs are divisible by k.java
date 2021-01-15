class Solution {
    public boolean canArrange(int[] arr, int k) {
        int[] frequency = new int[k];
        for(int i=0; i<arr.length; i++){
            arr[i]%=k;
            if(arr[i]<0){
                 arr[i]+= k;
            }
            frequency[arr[i]]++;
        }
        if(frequency[0]%2!=0){
          return false;  
        } 
        
        for(int i=1; i<=k/2; i++)
            if(frequency[i]!= frequency[k-i]) {
             return false;   
            }
        return true;
    }
}
