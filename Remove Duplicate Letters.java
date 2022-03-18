class Solution 
{
    public String removeDuplicateLetters(String s) 
    {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int n=s.length();
        
        for(char c:s.toCharArray()){
            map.put(c, map.getOrDefault(c,0)+1);}
        
        
        Set<Character>set = new HashSet<Character>();
        StringBuilder sb = new StringBuilder();
        int i=0;
        while(i<n)
        {
            char word= s.charAt(i); 
            i++;
            if (set.contains(word)) {
                map.put(word,map.get(word)-1);
                continue;
            }    
            set.add(word);
            
            
    while(sb.length()>0 && word< sb.charAt(sb.length()-1) 
          && map.get(sb.charAt(sb.length()-1)) > 1)
    {
        set.remove(sb.charAt(sb.length()-1));
        map.put(sb.charAt(sb.length()-1),map.get(sb.charAt(sb.length()-1))-1);
                sb.deleteCharAt(sb.length()-1);
            }
            
            sb.append(word);
        }
        
        return sb.toString();
    }
}
