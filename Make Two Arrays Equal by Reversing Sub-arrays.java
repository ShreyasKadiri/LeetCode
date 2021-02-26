//Sorting
class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        Arrays.sort(target);
        Arrays.sort(arr);
        return Arrays.equals(target,arr);
    }
}

//Linear Solution
class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
       int frequency[] = new int[1001];
        for(int i=0; i<target.length; i++){
            frequency[target[i]]++;
            frequency[arr[i]]--;
        }
        for(int i=0; i<frequency.length; i++){
            if(frequency[i]!=0){
                return false;
            }
        }
        return true;
    }
}
