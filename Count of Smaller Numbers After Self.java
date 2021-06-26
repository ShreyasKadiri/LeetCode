//Brute Forcing TLE and 62 / 65 test cases passed.
class Solution {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
       
        for(int i=0; i<nums.length; i++){
             int count = 0;
            for(int  j=1+i; j<nums.length; j++){
                if(nums[j] < nums[i]){
                    count++;
                }
            }
            result.add(count);
        }
        
        return result;
    }
}

//Approach 2
class Solution {
  int[] count;
  public List < Integer > countSmaller(int[] nums) {
    List < Integer > result = new ArrayList < Integer > ();
    count = new int[nums.length];
    int[] indexes = new int[nums.length];

    for (int i = 0; i < nums.length; i++) {
      indexes[i] = i;
    }
    mergesort(nums, indexes, 0, nums.length - 1);

    for (int i = 0; i < count.length; i++) {
      result.add(count[i]);
    }
    return result;
  }

  public void mergesort(int[] nums, int[] indexes, int low, int high) {
    if (high <= low) {
      return;
    }
    int mid = low + (high - low) / 2;
    mergesort(nums, indexes, low, mid);
    mergesort(nums, indexes, mid + 1, high);
    merge(nums, indexes, low, high);
  }

  public void merge(int[] nums, int[] indexes, int low, int high) {
    int mid = (low + high) / 2;
    int left_index = low;
    int right_index = mid + 1;
    int rightcount = 0;
    int[] new_indexes = new int[high - low + 1];
    int sort_index = 0;

    while (left_index <= mid && right_index <= high) {
      if (nums[indexes[right_index]] < nums[indexes[left_index]]) {
          new_indexes[sort_index] = indexes[right_index];
          rightcount++;
          right_index++;
        } else {
          new_indexes[sort_index] = indexes[left_index];
          count[indexes[left_index]] += rightcount;
          left_index++;
        }
        sort_index++;
      }
      while (left_index <= mid) {
        new_indexes[sort_index] = indexes[left_index];
        count[indexes[left_index]] += rightcount;
        left_index++;
        sort_index++;
      }
      while (right_index <= high) {
        new_indexes[sort_index++] = indexes[right_index++];
      }
      for (int i = low; i <= high; i++) {
        indexes[i] = new_indexes[i - low];
      }
    }
  }
