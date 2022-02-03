class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0; i<A.length; i++){
            for(int j=0; j<B.length; j++){
                int sum = A[i] + B[j];
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
        int result = 0;
        for(int i=0; i<C.length; i++){
            for(int j=0; j<D.length; j++){
                int sum = C[i] + D[j];
                result = result + map.getOrDefault(-sum, 0);
            }
        }
        return result;
    }
}
