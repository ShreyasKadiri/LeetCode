class Solution {
    public List<String> simplifiedFractions(int n) {
      List<String> result = new ArrayList<String>();
        for (int i=2; i<=n; i++) {
            for (int j=1; j<i; j++) {
                if (!gcd(i,j) || j == 1) {
                    result.add(j + "/" + i);
                }
            }
        }
        return result;
    }
    
 public boolean gcd(int num1, int num2){
      while (num2>1) {
            int rem=num1%num2;
            num1=num2;
            num2=rem;
        }
        return num2==0;
    }
}