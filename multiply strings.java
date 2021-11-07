class Solution
{
    public String multiply(String num1, String num2) 
    {
     int m=num1.length();
     int n=num2.length();
     int vals[] = new int[m+n];
        
    for(int i=m-1; i>=0; i--)
    {
        for(int j=n-1; j>=0; j--)
        {
            int mul=(num1.charAt(i)-'0')*(num2.charAt(j)-'0');
            int sum=mul+vals[i+j+1];
            
            vals[i+j]+=sum/10;
            vals[i+j+1]=sum%10;
        }
    }
        
        StringBuilder sb = new StringBuilder();
        for(int val:vals){
            if(val!=0 || sb.length()!=0){
                sb.append(val);
            }
        }
        
        if(sb.length()==0)
            return "0";
        return sb.toString();
    }
}
