class Solution {
    public int maxScoreSightseeingPair(int[] A) {
        if(A.length==0||A.length==1)  return 0;
        int[] temp= new int[A.length];
        temp[0]=A[0];
        temp[1]=A[0]+A[1]-1;
        int max=temp[1];
        for(int i=2;i<A.length;i++){
            temp[i]=Math.max((temp[i-1]-A[i-1]-1+A[i]),(A[i]+A[i-1]-1));
            System.out.println(temp[i]);
        }
        for(int i=0;i<temp.length;i++)
            max=Math.max(max,temp[i]);
        return max;
    }
}