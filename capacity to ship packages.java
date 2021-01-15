class Solution{
    public int minimumShipCapacity(int weights[], int D){
        if(weights.length==0 || weights==null || D<=0){
            return -1;
        }
        
        int low =1;
        int high=500*50000;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(validateWeight(weights, D, mid)){
                high = mid;
            }else {
                low =mid+1;
            }
        }
        return low;
    }
    
    public boolean validateWeight(int weights[], int D, int mid){
     if(weights.length==0 || weights==null || D<=0){
            return -1;
        }
     int daysRequired = 1;
     int total = 0;
     int isPossible = true;
     for(int i=0; i<weights.length; i++){
         if(weights[i] >  mid){
             isPossible = false;
         }if(weights[i]+total <=mid) {
             total+=weights[i];
         }else {
             daysRequired++;
             total = weights[i];
         }
     }
     if(isPossible){
         return false;
     }else{
         return daysRequired<=D;
       }
    }
}
