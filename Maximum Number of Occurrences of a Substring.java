class Solution{
public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
    HashMap<String, Integer> count = new HashMap<> ();        
    for(int i = 0; i + minSize <= s.length(); i++) {
        String temp = s.substring(i, i + minSize);
        HashSet<Character> letter = new HashSet<>();
        for(char c: temp.toCharArray()) 
            letter.add(c);
        if(letter.size()>maxLetters) 
            continue;
        count.put(temp,count.getOrDefault(temp,0)+ 1);
    }            
    int max=0;
    for(Map.Entry<String, Integer> entry: count.entrySet()) 
    max = max > entry.getValue()? max : entry.getValue();         
    return max;
  }
}