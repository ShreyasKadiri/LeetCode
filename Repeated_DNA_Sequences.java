class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new   ArrayList<>();
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        int i=0;
        
        while(i+10 <=s.length()){
            String subsequence=s.substring(i, i++ + 10);
            map.put(subsequence, map.getOrDefault(subsequence,0)+1);
            if(map.get(subsequence)==2)
                result.add(subsequence);
        }
        return result;
    }
}