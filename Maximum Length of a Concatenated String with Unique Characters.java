class Solution {
    public int maxLength(List<String> arr) {
        List<String> result = new ArrayList<String>();
        int maximumUniqueLength= 0;
        result.add("");
        for(String word : arr){
            if(!checkIfCharactersAreUnique(word)){
                continue;
            }
            List<String> currentList = new ArrayList<String>();
            for(String uniqueWord: result){
                if(checkIfCharactersAreUnique(uniqueWord+word)){
                    currentList.add(uniqueWord+word);
                    maximumUniqueLength = Math.max(maximumUniqueLength, (uniqueWord+word).length());
                }
            }
            result.addAll(currentList);
        }
        return maximumUniqueLength;
    }
    
    private boolean checkIfCharactersAreUnique(String word){
        int frequency[] = new int[26];
        for(char c : word.toCharArray()){
            frequency[c - 'a']++;
        }
         for(int i=0; i<frequency.length; i++){
            if(frequency[i] > 1){
                return false;
            }
        }
        return true;
    }
}
