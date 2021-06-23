class Solution {
    public int countSubstrings(String s, String t) {
        int result = 0;
        for(int i=0; i<s.length(); i++){
            for(int j=0; j<t.length(); j++){
                int x = i;
                int y = j;
                int difference = 0;
                while(x<s.length() && y<t.length()){
                     if(s.charAt(i) != t.charAt(j)){
                    difference++;
                    if(difference == 1){
                        result++;
                    }
                    if(difference == 2){
                        break;
                    }
                }
                x++;
                y++;
                }
            }
        }
        return result;
    }
}
