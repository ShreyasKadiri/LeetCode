//O(n3)
class Solution {
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int count = 0;
        for(int i=0; i<arr.length; i++){
            for(int j=i; j<arr.length; j++){
                for(int k=j; k<arr.length; k++){
                    if(i<j && j<k && Math.abs(arr[i] - arr[j])<=a &&    Math.abs(arr[j] - arr[k])<=b 
                       && Math.abs(arr[i] - arr[k])<=c){
                        count++;
                    }
                }
            }
        }
        return count;
    }
}


//Optimized: O(n3)
class Solution {
  public int countGoodTriplets(int[] arr, int a, int b, int c) {
      int count =0;
      for (int i=0; i<arr.length-2; i++)
		for (int j=i+1; j<arr.length-1; j++)
			if (Math.abs(arr[i] - arr[j]) <= a)
				for (int k=j+1; k<arr.length; k++)
					if (Math.abs(arr[j] - arr[k]) <= b && Math.abs(arr[k] - arr[i]) <= c){
                        count++;
                    }
      return count;
  }
}
