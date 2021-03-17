class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s2.length()==0 || s1.length()>s2.length())  return false;
        if(s1.length()==0)  return true;
        HashMap<Character,Integer> map1= new HashMap<Character,Integer>();
        HashMap<Character,Integer>map2= new HashMap<Character,Integer>();
        for(char c:s1.toCharArray())
            map1.put(c,map1.getOrDefault(c,0)+1);
        int i=0;
        int j=0;
        while(j<s2.length()) {
            int len=j-i+1;
            char c=s2.charAt(j);
            map2.put(c,map2.getOrDefault(c, 0) + 1);
            
            if(len<s1.length()) {
                j++;
                continue;
            }
            if(len==s1.length()) {
                char last=s2.charAt(i);
                if(map1.equals(map2))
                    return true;
                else {
                    map2.put(last,map2.get(last)-1);
                    if(map2.get(last)==0)
                        map2.remove(last);
                }
                i++;
                j++;   
            }
        }
        return false;
    }
}