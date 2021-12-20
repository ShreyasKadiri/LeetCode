class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(arr);
        int minimumDifference = Integer.MAX_VALUE;
        for(int i=1; i<arr.length; i++){
            if(arr[i]-arr[i-1] < minimumDifference){
                result = new ArrayList();
                minimumDifference = arr[i]-arr[i-1];
                result.add(Arrays.asList(arr[i-1], arr[i]));
            }
            else if(arr[i]-arr[i-1] == minimumDifference)
                result.add(Arrays.asList(arr[i-1], arr[i]));
        }
        return result;
    }
}
