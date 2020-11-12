class Solution {
    public int[] closestDivisors(int num) {
        int num1[] = findDivisors(num+1);
        int num2[]= findDivisors(num+2);        
        return Math.abs(num2[1]-num2[0]) > Math.abs(num1[1]-num1[0]) ? num1 : num2;
    }
    
    public int[] findDivisors(int num){
        //We will optimise it by going till sqrt(num)
    for (int i=(int)Math.round(Math.sqrt(num)); i>=1; i--) 
            if (num%i==0)
                return new int[]{num/i, i};
        return new int[]{0, 0};
    }    
}
