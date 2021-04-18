class Solution {
    public boolean checkIfPangram(String sentence) {
        char frequency[] = new char[26];
        for(char c : sentence.toCharArray()){
            frequency[c-'a']++;
        }
        
        for(int i=0; i<frequency.length; i++){
            if(frequency[i]<1){
                return false;
            }
        }
        return true;
    }
}
