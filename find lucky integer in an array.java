class Solution {
    public int findLucky(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int luckyNumber=-1;
        for(int i=0; i<arr.length; i++){
            map.put(arr[i], map.getOrDefault(arr[i],0)+1);
        }
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(entry.getValue() == entry.getKey()){
                luckyNumber  = (int) entry.getKey();
            }
        }
        return luckyNumber;
    }
}
