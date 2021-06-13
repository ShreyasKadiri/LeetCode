class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0; i<words.length; i++){
            for(int j=i+1; j<words.length; j++){
                if(isPalindrome(words[i]+words[j])){
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    result.add(temp);
                }
                
                if(isPalindrome(words[j]+words[i])){
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(j);
                    temp.add(i);
                    result.add(temp);
                }    
            }
        }
        return result;
    }
    
    private boolean isPalindrome(String word){
        String temp = word;
        int i = 0;
        int j = word.length()-1;
        while(i <= j){
            if(word.charAt(i)!=word.charAt(j)){
                return false;
            }else{
                i++;
                j--;
            }
        }
        return true;
    }
}
