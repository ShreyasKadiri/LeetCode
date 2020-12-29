class Solution {
    public double trimMean(int[] arr) {
        Arrays.sort(arr);
	    double sum=0;
	    int removalSize = (int)Math.ceil(arr.length * 0.05);
	    for(int i=removalSize; i<arr.length-removalSize; i++){
	        sum+=arr[i];
	    }
	    return sum / (arr.length - (2*removalSize));
    }
}
