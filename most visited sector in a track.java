class Solution {
    public List<Integer> mostVisited(int n, int[] rounds) {
       int low = rounds[0];
        int end = rounds[rounds.length - 1];
        List<Integer> result = new ArrayList<Integer>();
        if(low < end){
            for(int i=low; i<=end; i++){
                result.add(i);
            }
        }else {
            for(int i=1; i<=end; i++){
                result.add(i);
            }
            for(int i=0; i<=n; i++){
                result.add(i);
            }
        }
        return result;
    }
}
