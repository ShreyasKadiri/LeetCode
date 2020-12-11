class Solution{
public int countRangeSum(int[] nums, int lower, int upper) {
    int n=nums.length;
    long[] sum=new long[n + 1];
    for (int i=0;i<n;i++)
        sum[i+1]=sum[i]+nums[i];
    return countMergeSort(sum,0,n+1,lower,upper);
}

private int countMergeSort(long[] sums, int low, int high, int lower, int upper) {
    if(high-low<=1)
    return 0;
    int mid=(low+high)/2;
    int count=countMergeSort(sums,low,mid,lower,upper)
              +countMergeSort(sums,mid,high,lower,upper);
    int j=mid;
    int k=mid;
    int t=mid;
    long[] temp=new long[high-low];
    for (int i=low,r=0;i<mid;i++,r++) {
        while (k<high && sums[k]-sums[i] < lower)
            k++;
        while (j<high && sums[j]-sums[i]<=upper)
            j++;
        while(t<high && sums[t]<sums[i])
            temp[r++]=sums[t++];
        temp[r]=sums[i];
        count+=j-k;
    }
    System.arraycopy(temp,0,sums,low,t-low);
    return count;
}
}