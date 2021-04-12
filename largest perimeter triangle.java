import java.util.Arrays;
import java.util.Collections;
class Solution {
    public int largestPerimeter(int[] arr) {
        int perimeter = 0;
        Integer[] nums = Arrays.stream(arr).boxed().toArray( Integer[]::new);
         Arrays.sort(nums, Collections.reverseOrder());
        
        for(int i=0; i<nums.length-2; i++){
            if(nums[i] < nums[i+1] + nums[i+2]){
                perimeter  = Math.max(perimeter, nums[i] + nums[i+1] + nums[i+2]);
                break;
            }
        }
        return perimeter <=0 ? 0 : perimeter;
    }
}
