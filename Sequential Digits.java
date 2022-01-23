class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> result=new ArrayList<Integer>();
        int n1=String.valueOf(low).length();
        int n2=String.valueOf(high).length();
        int a=0;
        while(n1<=n2) {
            for(int i=1; i<=9-n1+1; i++) {
                a=0;
                for(int j=i; j<i+n1; j++) {
                    a=a*10;
                    a=a+j;
                }
                if(a>=low && a<=high) 
                    result.add(a);
            }
            n1++;
        }
        return result;
    }
}
