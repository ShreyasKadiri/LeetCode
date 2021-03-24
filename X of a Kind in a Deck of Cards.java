class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
       HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int card : deck){
            map.put(card, map.getOrDefault(card,0)+1);
        }
        
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(entry.getValue() < 2){
                return false;
            }
        }
        return true;
    }
}
