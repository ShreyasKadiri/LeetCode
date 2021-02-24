class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> indices = new ArrayList<Integer>();
        if(p.length()>s.length())
            return indices;
        char[] P=new char[26];
        char result[]= new char[26];
        int i=0;
        for(char c:p.toCharArray())
            P[c-'a']++;
        for(int j=0; j<s.length(); j++){
            result[s.charAt(j)-'a']++;
            while((j-i)+1>p.length()) 
                result[s.charAt(i++)-'a']--;
            if(Arrays.equals(result,P))
                indices.add(i);
        }
        return indices;
    }
}