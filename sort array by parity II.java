class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        int oddNumberAtEvenIndex = 0;
        int evenNumberAtOddIndex= 1;
        while(oddNumberAtEvenIndex < nums.length && evenNumberAtOddIndex<nums.length){
            while(oddNumberAtEvenIndex<nums.length && nums[oddNumberAtEvenIndex] % 2 == 0){
                oddNumberAtEvenIndex+=2;
            }
            while(evenNumberAtOddIndex<nums.length && nums[evenNumberAtOddIndex] % 2 == 1){
                evenNumberAtOddIndex+=2;
            }
            if(evenNumberAtOddIndex < nums.length && oddNumberAtEvenIndex<nums.length){
                swap(oddNumberAtEvenIndex, evenNumberAtOddIndex, nums);
            }
        }
        return nums;
    }
    
    private void swap(int a, int b, int nums[]){
        if(a != b){
            int store = nums[a];
            nums[a] = nums[b];
            nums[b] = store;
        }
    }
}
