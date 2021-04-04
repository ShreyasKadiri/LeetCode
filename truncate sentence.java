class Solution {
    public String truncateSentence(String s, int k) {
        String words[] = s.split(" ");
        String result = "";
        
        int i= 0 ;
        for(String word : words){
            if(i<k){
            result+=word + " ";
                 i++;
            }
        } 
        return result.strip();
    }
}
