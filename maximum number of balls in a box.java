class Solution {
    public int countBalls(int lowLimit, int highLimit) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int count=0;
        for(int i=lowLimit; i<=highLimit; i++){
             int store = i;
             int sumOfDigits = 0;
            while(store!=0){
                sumOfDigits+=store%10;
                store/=10;
            }
            map.put(sumOfDigits,map.getOrDefault(sumOfDigits,0)+1);
            count = map.get(sumOfDigits) > count ? map.get(sumOfDigits) : count;
        }
        return count;
    }
}
