class Solution {
    public String modifyString(String s) {
        String result = "";
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) == '?'){
                for (char c='a'; c<= 'c'; c++){
                    if (i>0 && s.charAt(i-1) == c){
                        continue;
                    }
                    if (i+1 < s.length() && s.charAt(i+1) == c){
                        continue;
                    }
                    result+= c;
                    break;
                }
            }
        }
        return result;
    }
}
