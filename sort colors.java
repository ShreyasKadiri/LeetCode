class Solution {
    public void sortColors(int[] nums) {
      int l=0;
      int m=0;
      int h=nums.length-1;
      int n=nums.length-1;
        
      while(m<=h){
          if(nums[m]==0){
              swap(nums[l],nums[m]);
              l+=1;
              m+=1;
          }
          else if(nums[m]==1){
              m++;
          }
          else if(nums[m]==2){
              swap(nums[h], nums[m]);
              h--;
          }   
      }
    }
    
    public void swap(int a, int b){
        int t;
        t=a;
        a=b;
        b=t;
    }
}
