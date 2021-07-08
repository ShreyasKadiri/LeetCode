class Solution {
    public boolean canMeasureWater(int x, int y, int z) {
        if(x+y<z) return false;
        int gcd = findGcd(x,y); 
        if(gcd==0 && z!=0)  return false;
        if(gcd!=0 && z%gcd!=0) return false;
        return true;   
    }
    
    public static int findGcd(int x, int y) { 
      if(y==0)  return x; 
      return findGcd(y,x%y);  
    } 
}