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


//Linear Approach
class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        // there are 2 ^ n numbers in the Gray code sequence.
        int totalLength = 1 << n;
        for (int i=0; i<totalLength; i++) {
            int value = i ^ i >> 1;
            result.add(value);
        }
        return result;
    }
}
