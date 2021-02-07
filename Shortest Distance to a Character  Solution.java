class Solution {
    public int[] shortestToChar(String s, char c) {
        List<Integer> shortestDistance=new ArrayList<Integer>();
        
        shortestDistance.add(-10000);
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)==c){
                shortestDistance.add(i);
            }
        }
        shortestDistance.add(Integer.MAX_VALUE);
        
        int[] result=new int[s.length()];
        
        int firstOccurence=shortestDistance.get(0);
        int secondOccurence=shortestDistance.get(1);
        
        int j=2;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)!=c){
                result[i]=Math.min(i-firstOccurence,secondOccurence-i);
            }
            else{
                firstOccurence=secondOccurence;
                secondOccurence=shortestDistance.get(j++);
            }
        }
        return result;
    }
}
