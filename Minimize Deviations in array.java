/*
Approach:
1. Even number can only be made smaller
2. Odd number can be increased
3. We try to make every number larger
4. If it is even number add to the heap and if it is odd add double of the number to the heap
5. Try to minimise the largest number half and by maintaining largest number
6. Keep decreasing the largest number by getting maximum value from heap
7. If current number if even then we halve it (minimize maximum value) and push back new value to heap
8. If it is odd we break the loop as we dont want to minimize
9. Also update minimum value to find out overall deviation
*/


class Solution {
    public int minimumDeviation(int[] nums) {
        if(nums==null || nums.length==0){
            return  -1;
        }
        int minimum = Integer.MAX_VALUE;
        int result = Integer.MAX_VALUE;
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
        for(int i=0; i<nums.length; i++){
            if(nums[i]%2 == 1){
                nums[i]*=2;
            }
            heap.add(-nums[i]);
            minimum = Math.min(nums[i], minimum);
        }
        
        while(true){
            int popped = -heap.poll();
            result = Math.min(result, -minimum + popped);
            if(popped%2==1){
                break;
            }
            minimum = Math.min(minimum, popped/2);
            heap.add(-popped/2);
        }
        return result;
    }
}
