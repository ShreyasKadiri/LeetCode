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


//Trie based
class Solution {
    private class TrieNode {
        int wordsIndex = -1;
        TrieNode[] nextLetter = new TrieNode[26];
        List<Integer> palindromes = new ArrayList<>();
    }

    private boolean isPalindrome(String word, int headIndex, int tailIndex) {
        while (headIndex < tailIndex) {
            if (word.charAt(headIndex++) != word.charAt(tailIndex--)) { 
                return false; 
            }
        }
        return true;
    }
    
    private void addWordToTrie(TrieNode trieNode, String[] words, int wordIndex) {
        final String word = words[wordIndex];
        for (int i=word.length()-1; i>=0; i--) {
            if (isPalindrome(word, 0, i)){
                trieNode.palindromes.add(wordIndex);
            }
            final int letterIndex = word.charAt(i) - 'a';
            if (trieNode.nextLetter[letterIndex] == null) {
                trieNode.nextLetter[letterIndex] = new TrieNode();
            }
            trieNode = trieNode.nextLetter[letterIndex];
        }
        trieNode.wordsIndex = wordIndex;
        trieNode.palindromes.add(wordIndex);
    }
        
    private void getPalindromePairs(List<List<Integer>> result, TrieNode trieNode, String[] words, int wordIndex) {
        final String word = words[wordIndex];
        
        for (int i=0; i<word.length(); i++) {
            if (trieNode.wordsIndex!=-1 && trieNode.wordsIndex != wordIndex && isPalindrome(word, i, word.length() -1)) {
                result.add(Arrays.asList(wordIndex, trieNode.wordsIndex));
            }
            final TrieNode nextLetterNode = trieNode.nextLetter[word.charAt(i) - 'a'];
            if (nextLetterNode == null) { 
                return;
                }
            trieNode = nextLetterNode;
        }
        
        for (final Integer palindromeWordIndex : trieNode.palindromes) {
            if (wordIndex == palindromeWordIndex) { 
                continue;
            }
            result.add(Arrays.asList(wordIndex, palindromeWordIndex));
        }    
    }

    public List<List<Integer>> palindromePairs(String[] words) {
        final TrieNode trieRoot = new TrieNode();
        for (int i = 0; i < words.length; i++) {
            addWordToTrie(trieRoot, words, i);    
        }        
        final List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            getPalindromePairs(result, trieRoot, words, i);
        }
        return result;
    } 
}
