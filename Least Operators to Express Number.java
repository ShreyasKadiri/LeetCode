class Solution {
    public int leastOpsExpressTarget(int x, int target) {
     int pos=0;
     int neg=0;
     int k=0;
     int pos2;
     int neg2;
     int curr;
     while(target>0){
            curr=target%x;
            target=target/x;
            if(k>0) {
                pos2=Math.min(curr*k+pos,(curr+1)*k+neg);
                neg2=Math.min((x-curr)*k+pos,(x-curr-1)*k+neg);
                pos=pos2;
                neg=neg2;
            } 
         else 
         {
         pos=curr*2;
         neg=(x-curr)*2;
        }
            k++;
        }
        return Math.min(pos,k+neg)-1;   
    }
}
