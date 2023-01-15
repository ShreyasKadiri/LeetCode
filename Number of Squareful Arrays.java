class Solution {
    private static boolean isPerfectSquare(int previousNumber, int currentNumber){
        double sqrt = Math.sqrt(previousNumber + currentNumber);
        return (sqrt - Math.floor(sqrt)) == 0;
    }

    public int numSquarefulPerms(int[] nums) {
        Arrays.sort(nums);
        return dfs(0, null, new boolean[nums.length], nums);
    }

    private static int dfs(int index, Integer previousNumber, boolean seen[], int nums[]){
        int count = 0;
        if(index == nums.length){
            return 1;
        }

        for(int i=0; i<nums.length; i++){
            if(seen[i] || (i != 0 && nums[i] == nums[i-1] && !seen[i-1]) || 
            (previousNumber != null && !isPerfectSquare(previousNumber, nums[i]))){
                continue;
            }else {
                seen[i] = true;
                count+= dfs(index+1, nums[i], seen,nums);
                seen[i] = false;
            }
        }
        return count;
    }
}
