class Solution {
    public boolean canDistribute(int[] nums, int[] quantity) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i=0; i<nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }
       
        int distances[] = new int[nums.length];
        int index=0;
        for(int frequency : map.values(){
            distance[index++] = frequency;
        }
            Arrays.sort(quantity);
            return backTrack(distance, quantity, quantity.length-1);
    }
            
            
    public boolean backTrack(int distance[], int quantity, int j){
     if(j==-1){
         return true;
     }   
        
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i=0; i<distance.length; i++){
            if(distance[i] > =quantity[j] && set.add(distance[i])){
                distance[i]-=quantity[j];
                if(backTrack(distance, quantity, j-1))
                    return true;
            }
            distance[i]+=quantity[j];
        }
    }
        return false;
}
            }

/*
https://leetcode.com/problems/distribute-repeating-integers/discuss/935522/Step-by-step-optimization-more-than-10-methods
*/
