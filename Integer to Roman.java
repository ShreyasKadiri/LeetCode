class Solution
{
    public static String intToRoman(int num)
    {
    
    String[] romans = new String[] { "I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M" };
    int[] numbers= new int[] { 1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000 };
    int n=numbers.length;
        
    StringBuilder sb = new StringBuilder();
    int q=0;
        
    for (int i=n-1;i>= 0;i--) 
        {
        q=num/numbers[i];
        num %=numbers[i];
        while (q>0)
        {
            sb.append(romans[i]);
            q--;
        }
    }
    return sb.toString();
} 
}
