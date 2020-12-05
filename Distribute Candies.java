class Solution {
    public int distributeCandies(int[] candyType) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0; i<candyType.length; i++){
            map.put(candyType[i], map.getOrDefault(candyType[i],0) + 1);
        }
        
        if(candyType.length == 2){
            return 1;
        }
        if(candyType.length==1){
            return 1;
        }
        else if(map.size()>=2 && candyType.length==4){
            return 2;
        }
		else if (map.size()>candyType.length/2){
            return  candyType.length/2;
        } 
		else {
            return map.size();
        }
    }
}
