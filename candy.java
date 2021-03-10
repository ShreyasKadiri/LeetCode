class Solution {
    public int candy(int[] ratings) {
        if(ratings.length==0 || ratings==null){
            return -1;
            
        if(ratings.length<=1){
            ratings.length;
        }

            int candiesCount[] = new int[ratings.length];
            Arrays.fill(candiesCount,1);
            int i;
            int j;
            
    // Traversing from right to left:
         i=rating.length-2;
        while(i>=0){
            j=i+1;
        if(ratings[i] > ratings[j] && candiesCount[i]<= candiesCount[j])
            candiesCount[i] = candiesCount[j] + 1;
        else if(ratings[i] < ratings[j] && candiesCount[j] <= candiesCount[i])
            candiesCount[j] = candiesCount[i] + 1;
        i--;
    }
    
    // Traveling from left to right:
     i=1;
     j=0;
    while(i<n){
        j=i-1;
        if(ratings[i] > ratings[j] && candiesCount[i] <= candiesCount[j])
            candiesCount[i] = candiesCount[j] + 1;
        else if(ratings[i] < ratings[j] && candiesCount[j] <= candiesCount[i])
            candiesCount[j] = candiesCount[i] + 1;
        i++;
    }
    int sum=0;
    for(int i=0; i<ratings.length; i++){
        sum+=candy[i];
    }
    return sum;
  }      
}
