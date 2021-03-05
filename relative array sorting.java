class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int bucket[] = new int[1001];
        for(int i=0; i<arr1.length; i++){
            bucket[i]+=1;
        }
        int result[] = new int[arr1.length];
        
        //Lets store it in order of arr2
        int index = 0;
        for(int i=0; i<arr2.length; i++){
            if(bucket[i]-- > 0){
                result[index++] = i;
            }
        }
        
        
        //Fill remaining elements
        for(int i=0; i<1001; i++){
             while(bucket[i]-- > 0) {
                    result[index++] = i;
                }
        }
        return result;
    }
}
