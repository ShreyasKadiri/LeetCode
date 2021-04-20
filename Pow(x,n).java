class Solution{
public double myPow(double x, int n) {
        double result=0.0;
        if(n==0) return 1;
        if(x==1 || x==0) return x;
        if(n==1)  return x;
        
        int isNegative= n<0 ? 1:0;
        n=Math.abs(n);
        if(n%2==0){
            double product=myPow(x,n/2);
            result=product*product;}
        else{
            result=x*myPow(x,n-1);}
        return isNegative==1 && result!=0.0?1/result:result;
    }
}