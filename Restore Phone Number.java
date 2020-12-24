class Solution {
    public String reformatNumber(String number) {
        if(number=="" || number.length()==0){
            return "";
        }
        StringBuilder sb = new StringBuilder("");
        for(char c: number.toCharArray()){
            if(c!=' ' && c!='-'){
                sb.append(c);
            }
        }
        //You have successfully eliminated all the "-" and " "
        if(sb.length()==1 || sb.length()==2 || sb.length()==3){
            return sb.toString();
        }
        
         int i=0;
        while(i<sb.length()-4) {
            sb.insert(i+3,'-');
            i+=4;
        }
        
        if (sb.length()-i==4) {
            sb.insert(i+2,'-');
        }       
        return sb.toString();
    }
}
