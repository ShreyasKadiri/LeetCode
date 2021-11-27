class Solution {
    public int[] productExceptSelf(int[] nums) {
        int currentProduct = 1; 
        int product[] = new int[nums.length]; 
        for (int i=0; i<nums.length; i++){ 
            product[i] = 1;
        }
  
        //Come from left side and calculate product excluding that current element
        for (int i=0; i<nums.length; i++) { 
            product[i] = currentProduct; 
            currentProduct = currentProduct * nums[i]; 
        } 
        currentProduct=1; 
  
    //Come from right side and calculate product excluding that current element
        for (int i=nums.length-1; i>=0; i--){ 
            product[i] = product[i] * currentProduct; 
            currentProduct = currentProduct *nums[i]; 
        } 
        return product;
    }
}
