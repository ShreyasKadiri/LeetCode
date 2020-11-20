class Solution {
    public boolean queryString(String S, int N) {
        int count=0;
        for(int x=1; x<=N; x++){
            String binary =Integer.toBinaryString(x);
            if(S.contains(binary)){
                count+=1;
            }
            else{
                count=0;
                break;
            }
        }
        return count>0;
    }
}