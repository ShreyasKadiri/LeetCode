class Solution {
    public List<String> readBinaryWatch(int num) {
        List<String> result = new ArrayList<String>();
        for(int i=0; i<12; i++){
            for(int j=0; j<60; j++){
                if (Integer.bitCount(i*64 + j) == num){
                    result.add(String.format("%d:%02d", i, j));
                }                    
            }
        }
        return result;
    }
}
