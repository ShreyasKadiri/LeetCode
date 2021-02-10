class Solution {
    public boolean lemonadeChange(int[] bills) {
        int fiveDollarCount = 0;
        int tenDollarCount = 0;
        for(int i=0; i<bills.length; i++){
            if(bills[i] == 5){                  //Pay using 5
                fiveDollarCount+=1; 
            }else if(bills[i] == 10){           //Pay using 10
                tenDollarCount+=1;
                fiveDollarCount-=1;
            }else if(tenDollarCount > 0){       //Pay using 20 
                tenDollarCount-=1;
                fiveDollarCount-=1;
            }else {
                fiveDollarCount-=3;
            }
           if(fiveDollarCount<0){
               return false;
           }
        }
        return true;
    }
}
