class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int i=left, n=0; i<=right; i++) {
            for (n=i; n>0; n/=10){
                if (n%10 == 0 || i % (n%10) != 0){
                    break;
                }
            }
            if (n==0){
                result.add(i);
            }
        }
        return result;
    }
}
