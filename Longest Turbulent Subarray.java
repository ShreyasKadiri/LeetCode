class Solution {
    public int maxTurbulenceSize(int[] arr) {
        if(arr.length < 2){
            return arr.length;
        }
        int maximum = 1;
        int i = 0;
        int j = 0;
        while(i+1 < arr.length){
            if(arr[i] == arr[i+1]){
                i++;
                continue;
            }
            j = i + 1;
            while(j+1 < arr.length && isCurrentIndexTurbulent(arr, j)){
                j++;
            }
            maximum = Math.max(maximum, j-i+1);
            i = j;
        }
        return maximum;
    }
    
    private boolean isCurrentIndexTurbulent(int arr[], int i){
        return arr[i]> arr[i-1] && arr[i]>arr[i+1] || arr[i]< arr[i-1] && arr[i]<arr[i+1];
    }
}
