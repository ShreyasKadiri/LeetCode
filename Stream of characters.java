class StreamChecker{
    List<Integer> result = new ArrayList<Integer>();
	Trie trie=new Trie();

public StreamChecker(String[] words) {
	for(String word : words){
		trie.insert(word);
	}
}

public boolean query(char letter) {
	result.add(letter-'a');
	return trie.query(result);
}

class Trie{
	Trie[] next = new Trie[26];
	boolean hasValue;
    
	void insert(String word){
		char[] charArray = word.toCharArray();
		Trie curr=this;
		for(int i=charArray.length-1; i>=0; i--){
			int j=charArray[i]-'a';
			if(curr.next[j]==null){
				curr.next[j]=new Trie();
			}
			curr=curr.next[j];
		}
		curr.hasValue=true;
	}

	boolean query(List<Integer> list){
		Trie curr=this;
		for(int i=result.size()-1; i>=0; i--){
			curr=curr.next[result.get(i)];
			if(curr==null)
                return false;
			if(curr.hasValue)
                return true;
		}
		return false;
	}
  }
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */
