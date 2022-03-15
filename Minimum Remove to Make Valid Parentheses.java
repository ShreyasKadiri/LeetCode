class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder("");
        int open = 0;
        for(char c : s.toCharArray()){
            if(c == '('){
                open+= 1;
            }else if(c == ')'){
                if(open == 0){
                    continue;
                }
                open--;
            }
            sb.append(c);
        }
        
        StringBuilder result = new StringBuilder("");
        for(int  i=sb.length()-1; i>=0; i--){
            if(sb.charAt(i)=='(' && open-- > 0){
                continue;
            }
            result.append(sb.charAt(i));
        }
        return result.reverse().toString();
    }
}
