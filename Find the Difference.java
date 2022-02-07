class Solution {
    public char findTheDifference(String s, String t) {
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c,0)+1);
        }
        for(char c : t.toCharArray()){
            if(map.containsKey(c) && map.get(c)==0 || !map.containsKey(c)){
                return c;
            }else{
                map.put(c,map.get(c)-1);
            }
        }
        return '!';
    }
}
