class Solution {
    public int sumBase(int n, int k) {
        String base = Integer.toString(Integer.parseInt(String.valueOf(n),10),k);
        int number = Integer.parseInt(base);
        int sum = 0;
        while(number!=0){
            number = number % 10;
            sum+=number;
            number = number/10;
        }
        return sum;
    }
}
