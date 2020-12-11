class Solution {
    public boolean validMountainArray(int[] arr) {
        int n=arr.length;
        int i=0;
        int j=n-1;
        while (i+1<n && arr[i]<arr[i+1])
            i++;
        while(j>0 && arr[j-1]>arr[j])
            j--;
        return i>0 && i==j && j<n-1;
    }
}
