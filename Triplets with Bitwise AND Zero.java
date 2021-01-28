/*
Approach:
1. Brute Force: Use three for loops to find triplets - Time Complexity: O(n3)
2. Use HashMap: First calculate the pairs with bitwise AND zero. Then iterate through the array to find another 
number when And ed with previous paired AND from Hashmap that equals to zero


*/

class Solution {
    public int countTriplets(int[] A) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i=0; i<A.length; i++){
            for(int j=0; j<A.length; j++){
                    map.put(A[i]&A[j], map.getOrDefault(A[i]&A[j],0)+1);
            }
        }
        int result = 0;
        for(int k=0; k<A.length; k++){
            for(int key : map.keySet()){
                if( (key&A[k]) == 0){
                    result+=map.get(key);
                }
            }
        }
        return result;
    }
}
