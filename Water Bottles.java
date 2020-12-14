class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int total=numBottles;
        int rem=total;
        int empty=0;
    while(rem>=numExchange){   
        empty=(rem % numExchange);
        total+=(rem/numExchange);
        rem=empty+(rem/numExchange);
    }
    return total;
   }
}
