class Solution {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i=0; i<=x; i++){
            for(int j=0; j<=y; j++){
                int value = (int)(Math.pow(x,i) + Math.pow(y,j));
                if(value <= bound){
                    set.add(value);
                }
            }
        }
        return new ArrayList<>(set);
    }
}
