class Solution {
    public List<Integer> partitionLabels(String S) {
        List<Integer> result = new ArrayList<>();
        int lastIndexes[] = new int[26];
        for(int i=0;i<S.length();i++){
            lastIndexes[S.charAt(i)-'a']=i;
        }
        int start=0;
        int end=0;
        for(int i=0;i<S.length();i++){
            end=Math.max(end,lastIndexes[S.charAt(i)-'a']);
            if(i==end){
             result.add(end-start+1);
                start=end+1;
            }
        }        
        return result;
    }
}