class Solution {
    public String modifyString(String s) {
       if(s == null || s.length() <= 0){
            return s;
        }
        if(s.length() == 1 && s.charAt(0) == '?'){
            return "a";
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while(i < s.length()){
            if(s.charAt(i) != '?'){
                sb.append(s.charAt(i));
            }else{
                for(char c = 'a'; c <= 'z'; c++){
                    if(i == 0){
                        if(c != s.charAt(i + 1)){
                            sb.append(c);
                            break;
                        }
                    }else if(i == s.length() - 1){
                        if(c != sb.charAt(sb.length() - 1)){
                            sb.append(c);
                            break;
                        }
                    }else{
                        if(c != sb.charAt(sb.length() - 1) && c != s.charAt(i + 1)){
                            sb.append(c);
                            break;
                        }
                    }
                }
            }
            i++;
        }
        return sb.toString();
    }
}
