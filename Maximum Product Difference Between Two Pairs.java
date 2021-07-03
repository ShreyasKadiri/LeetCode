//o(nlogn)
class Solution {
    public int maxProductDifference(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length-1]*nums[nums.length-2] - nums[0]*nums[1];
    }
}

//o(n)
class Solution {
    int firstMinimum = Integer.MAX_VALUE;
    int secondMinimum = Integer.MAX_VALUE;
    int firstLargest = Integer.MIN_VALUE;
    int secondLargest = Integer.MIN_VALUE;
    
    int small[] = new int[2];
    int large[] = new int[2];
        
    public int maxProductDifference(int[] nums) {
       small = smallestNumbers(nums);
       large =largestNumbers(nums);
        return large[0]*large[1] - small[1]*small[0];
    }
 
    public int[] smallestNumbers(int nums[]){
        for (int i=0; i<nums.length; i++) {
            if(firstMinimum>nums[i]){
                secondMinimum = firstMinimum;
                firstMinimum = nums[i];
            }else if(secondMinimum>nums[i]){
                secondMinimum = nums[i];
            }
        }
        return new int[]{firstMinimum,secondMinimum};
    }
    
    public int[] largestNumbers (int nums[]){
        for (int i=0; i<nums.length; i++) {
            if(firstLargest < nums[i]){
                secondLargest = firstLargest;
                firstLargest = nums[i];
            }else if(secondLargest < nums[i]){
                secondLargest = nums[i];
            }
        }
        return new int[]{firstLargest, secondLargest};
    }
}


//o(n) Single Pass
class Solution{
    public int maxProductDifference(int[] nums) {
	int largest = 0, secondLargest = 0, smallest = Integer.MAX_VALUE, secondSmallest = Integer.MAX_VALUE;
	for(int i=0;i<nums.length;i++) {
        if(nums[i]>=largest) {
            secondLargest = largest;
            largest = nums[i];
		} else if(nums[i]>secondLargest){
            secondLargest = nums[i];
        }
        if(nums[i]<=smallest) {
            secondSmallest = smallest;
			smallest = nums[i];
		} else if(nums[i]<secondSmallest){
            secondSmallest = nums[i];
        }
	}
	return largest * secondLargest - smallest * secondSmallest;
    }
}
