class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length()!=t.length())
            return false;
        int[] count=new int[512];
        for (int i=0; i<s.length(); i++) {
            if (count[s.charAt(i)]!= count[t.charAt(i)+256]) return false;
            count[s.charAt(i)]=count[t.charAt(i)+256]=i+1;
        }
        return true;
    }
}