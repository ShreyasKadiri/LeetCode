class Solution{
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        Set<Integer> set = new HashSet<Integer>();
        for(int i=1; i<=bound; i*=x) {
            for(int j=1; i+j <= bound; j*=y) {
                set.add(i+j);
                if(y == 1){
                    break;
                }
            }
            if(x == 1){
                break;
            }
        }
        return new ArrayList(set);
    }
}


class Solution {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        Set<Integer> set = new HashSet<Integer>();  
        int X = (int) (x == 1 ? 0 : Math.log(bound) / Math.log(x));
        int Y = (int) (y == 1 ? 0 : Math.log(bound) / Math.log(y));
        for(int i=0; i<=X; i++) {
            for(int j=0; j<=Y; j++) {
                int value = (int) (Math.pow(x, i) + Math.pow(y, j));
                if(value <= bound){
                    set.add(value);
                }
            }
        }
        return new ArrayList<>(set);
    }
}
