class Solution {
    public String pushDominoes(String string) {
     char dominoes [] = string.toCharArray();
        int force=0;
        int forces[] = new int [string.length()];
        for(int i=0; i<string.length(); i++){
            if(dominoes[i]=='R'){
                force=string.length();
            }else if(dominoes[i]=='L'){
                force=0;
            }else{
                force=Math.max(0,force-1);
            }
            forces[i]+=force;
        }
        
        force=0;
        for(int i=string.length()-1; i>=0; i--){
            if(dominoes[i]=='L'){
                force=string.length();
            }else if(dominoes[i]=='R'){
                force=0;
            }else{
                force=Math.max(0,force-1);
            }
            forces[i]-=force;
        }
    
        StringBuilder sb = new StringBuilder();
        for(int f: forces){
            if(f>0){
                sb.append("R");
            }else if(f<0){
                sb.append("L");
            }else{
                sb.append(".");
            }
        }
        return sb.toString();
    }
}