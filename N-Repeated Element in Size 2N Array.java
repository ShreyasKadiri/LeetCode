class Solution {
    public int repeatedNTimes(int[] A) {
        HashMap<Integer, Integer> map = new HashMap<Integer,Integer>();
        for(int i=0; i<A.length; i++){
            map.put(A[i], map.getOrDefault(A[i],0)+1);
        }
        
        int repeatedElement = 0;
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(A.length/2 == entry.getValue()){
                repeatedElement = entry.getKey();
            }
        }
        return repeatedElement;
    }
}



//O(1)
class Solution {
    public int repeatedNTimes(int[] A) {
        int frequency[] = new int [10000];
        int repeatedElement = 0;
        for(int i=0; i<A.length; i++){
            if(frequency[A[i]]++ == 1){
                repeatedElement = A[i];
            }
        }
        return repeatedElement;
    }
}
