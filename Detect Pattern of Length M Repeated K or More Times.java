class Solution {
   public boolean containsPattern(int[] arr, int m, int k) {
    int i = 0;
    int j = m;
    int count = m;
    
    while(j < arr.length){
        if(arr[i] == arr[j]){
            count++;
            if(count==k*m || count>k*m){
                return true;
            }
        }else{
            count = m;
        }
        i++;
        j++;
    }
    return false;
   }
}
