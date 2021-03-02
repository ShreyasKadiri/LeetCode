class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int consistentStrings = 0;
        HashSet<Character> set = new HashSet<Character>();
        for(char c : allowed.toCharArray()){
            set.add(c);
        }
        
        for(String word : words){
            for(int i=0; i<word.length(); i++){
                if(!set.contains(word.charAt(i))){
                    break;
                }if(i == word.length()-1) {
                    consistentStrings+=1;
                }
            }
        }
        return consistentStrings;
    }
}
