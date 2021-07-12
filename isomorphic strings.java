class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> map1 = new HashMap<Character, Character>();
        HashMap<Character, Character> map2 = new HashMap<Character, Character>();
        
        for(int i=0; i<t.length(); i++){
            map1.putIfAbsent(s.charAt(i), t.charAt(i));
            map2.putIfAbsent(t.charAt(i), s.charAt(i));
                             
            if(map1.get(s.charAt(i))!= t.charAt(i) || map2.get(t.charAt(i))!= s.charAt(i) ){
                return false;
            }
        }
        return true;
    }
}
