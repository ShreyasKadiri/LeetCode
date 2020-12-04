class Solution {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> result = new ArrayList<>();
        for(String query : queries){
            result.add(isMatch(query, pattern));
        }
        return result;
    }
    
    private boolean isMatch(String query, String pattern){
        int i=0;
        for(char c:query.toCharArray()){
            if(i<pattern.length() && c==pattern.charAt(i)){
                i++;
            }
            else if(c<'a') {
                return false;
            } 
        }
        return i==pattern.length();
    }
}