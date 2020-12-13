class Solution {
    public int[] sortByBits(int[] arr) {
        int sorted[] = new int[arr.length];
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0; i<arr.length; i++){
            //Get the number of ones in binary representaion
            int count = countOnes(arr[i]);
            map.put(arr[i], map.getOrDefault(count, 0)+1);
            count=0;
        }
        
        
        
        return sorted;
    }
    
    public int countOnes(int n){
        int count = 0;
        while(n!=0){
            n = n & (n-1);
            count+=1;
        }
        return count;
    }
    
}
