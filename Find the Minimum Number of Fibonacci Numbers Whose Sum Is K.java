class Solution {
    public int findMinFibonacciNumbers(int k) {
        int a=1; int b=1;
        List<Integer> fibonacci = new ArrayList<Integer>();
        fibonacci.add(a);
        fibonacci.add(b);
        while(b<=k){
            int c=a+b;
            fibonacci.add(c);
            a=b;
            b=c;
        }
        HashSet<Integer> set = new HashSet<Integer>();
        int len=fibonacci.size();
        int index=fibonacci.size()-1;
        while(k>0){
            if(k>=fibonacci.get(len-1)){
                set.add(fibonacci.get(len-1));
                k=k-fibonacci.get(len-1);
            }
            else{
                len--;
            }
        }
        
        return set.size();
    }
}