class Solution{
    public String countAndSay(int n){
        if(n<=0){
            return  "";
        }
        String result ="1";
        while(n > 1){
            StringBuilder sb = new StringBuilder("");
            for(int i=0; i<result.length(); i++){
                int count=1;
                while(i+1<result.length() && result.charAt(i) == result.charAt(i+1)){
                    count+=1;
                    i++;
                }
                sb.append(count).append(result.charAt(i));
            }
            result=sb.toString();
            n--;
        }
     return result;   
    }
}