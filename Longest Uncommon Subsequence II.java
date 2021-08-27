class Solution {
    public int findLUSlength(String[] strs) {
        int maximumLength = -1;
        for(int i=0; i<strs.length ; i++){
            boolean flag = false ;
            int currentLength = strs[i].length() ;
            for(int j=0 ; j<strs.length; j++){
                if(i!=j && areSubsequences(strs[i], strs[j])){
                    flag = true ;
                    break ;
                }
            }if(!flag){
                maximumLength = Math.max(maximumLength , currentLength);
            }
        }
        return maximumLength ;
    }

    public boolean areSubsequences(String a, String b) {
        if (a.equals(b)){
            return true;
        }
        int i = 0;
        int j = 0;
        while (i<a.length() && j<b.length()) {
            if (a.charAt(i) == b.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == a.length();
    }
}
