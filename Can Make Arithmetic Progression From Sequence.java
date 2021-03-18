class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        int firstTerm  = 0;
        int secondTerm = 0;
        
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0; i<arr.length; i++){
            map.put(arr[i], map.getOrDefault(arr[i],0)+1);
        }
        
        //Find the firstSmallest and secondSmallest number from array
        for(int i=0; i<arr.length; i++){
            firstTerm = Math.min(arr[i], firstTerm); 
        }
        
        for(int i=0; i<arr.length; i++){
            secondTerm = Math.min(arr[i], secondTerm); 
        }
        
        
        int difference = secondTerm - firstTerm;
        int i=firstTerm;
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(!map.containsKey(i+difference)){
                return false;
            }else {
                i+=difference;
            }
        }
        return true;
    }
}
