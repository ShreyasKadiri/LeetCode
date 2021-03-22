class Solution {
    public String thousandSeparator(int n) {
        String number = String.valueOf(n);
        StringBuilder thousandSeparator = new StringBuilder("");
        
        for(int i=number.length(); i>=0; i-=3){
             if (thousandSeparator.length() > 0)  {
               thousandSeparator.insert(0, ".");  
             } 
            else {
                 thousandSeparator.insert(0, number.substring(Math.max(0, i - 3), i));
            }
        }
        return thousandSeparator.toString();
    }
}
