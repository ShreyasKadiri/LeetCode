class Solution{
    public int longestSubarray(int a[]){
     int max = Integer.MIN_VALUE;
     int sum=0;
     HashMap<Integer, Integer> map = new HashMap<Integer,Integer>();
     map.put(0, -1);
     for(int i=0; i<a.length; i++){
         if(a[i]==0){
             sum+=-1;
         }else{
             sum+=1;
         }
         
         if(map.containsKey(sum)){
             int index = map.getValue(sum);
             max = Math.max(max, i - index);
         }else{
             map.put(sum, i);
         }
     }
     return max;   
    }
}
