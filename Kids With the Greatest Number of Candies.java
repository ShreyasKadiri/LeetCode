class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> result = new ArrayList<Boolean>();
        
        for(int i=0; i<candies.length; i++){
            if(candies[i]+extraCandies >= candies.length){
                result.add(true);
            } else{
                result.add(false);
            }
        }        
        return result;
    }
}
