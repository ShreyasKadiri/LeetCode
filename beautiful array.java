class Solution {
    public int[] beautifulArray(int n) {
        ArrayList<Integer> result = new ArrayList<>();
        result.add(1);
        while (result.size() < n){
            ArrayList<Integer> currentElements = new ArrayList<>();
            for (int element : result){
                if(2*element-1 <= n){
                    currentElements.add(element * 2 - 1);
                }
            }
            for (int element : result) {
                if(2*element <=n){
                    currentElements.add(element * 2);
                }
            }
            result = currentElements;
        }
        int[] beautifulElements = new int[n];
        for(int i=0; i<n; i++){
            beautifulElements[i] = result.get(i);
        }
        return beautifulElements;
    }
}
