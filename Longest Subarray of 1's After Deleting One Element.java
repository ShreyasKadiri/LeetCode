//Most Efficient One
class Solution {
    public int longestSubarray(int[] nums) {
        int prev=0;
        int count=0;
        int result=0;
        for(int i=0; i<nums.length; i++) {
            if(nums[i]==1)
                count++;
            else 
            {
                result=Math.max(result,count+prev);
                prev=count;
                count=0;
            }
        }
        result=Math.max(result,count+prev);
        return result== nums.length ? result-1 : result;  
    }
}



/*Sliding Window
class Solution{
 public int longestSubarray(int[] A) {
        int i=0;
        int j;
        int k=1;
        int result=0;
        for(j=0; j<A.length; j++){
            if(A[j]==0) 
                k--;
            while(k<0)
            {
                if(A[i]==0) {
                    k++;
                }
                i++;
            }
            result=Math.max(result,j-i);
        }
        return result;
    }
}
*/