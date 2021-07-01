class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<Integer>();
        result.add(0);
        
        if(n == 0){
            return result;
        }
        result.add(1);
        int currentValue = 1;
        
        for(int i=2; i<=n; i++){
            currentValue*= 2;
            for(int j=result.size()-1; j>=0; j--){
                result.add(curr + result.get(j));
            }
        }
        return result;
    }
}
