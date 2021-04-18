class Solution {
     public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        for (int i=0; i<costs.length; ++i)
            if ((coins -= A[i]) < 0)
                return i;
        return A.length;
    }
}
