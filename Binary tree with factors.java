/**
Approach:
1.  Sort the array
2.  Build HashMap to record each Integer, and the number of trees with that Integer as root
3.  Each integer A[i] will always have one tree with only itself
4.  If A[i] has divisor (a) in the map, and if A[i]/a also in the map
    then a can be the root of its left subtree, and A[i]/a can be the root of its right subtree;
5. The number of such tree is map.get(a) * map.get(A[i]/a)
6. Sum over the map
 */

class Solution {    
    public int numFactoredBinaryTrees(int[] A) {
        Arrays.sort(A);
        Map<Integer,Long> map = new HashMap<Integer,Long>();
        long count=1;
        int mod=(int)1e9+7;
        map.put(A[0],count);
        for (int i=1; i<A.length; i++) {
            count=1;
            for (int curr : map.keySet()) {
                if (A[i]%curr==0 && map.containsKey(A[i]/curr)) {
                    count+=map.get(curr) * map.get(A[i]/curr);
                }
            }
            map.put(A[i],count);
        }
        
        long sum = 0;
        for (int curr : map.keySet()) {
            sum=(sum+map.get(curr))%mod;
        }
        return (int) sum;
    }        
}