class Solution{
    public int candy(int[] ratings) {
        int sum=0;
        int[] candies = new int[ratings.length];
        for(int i=0; i<candies.length; i++){
            candies[i] = 1;
        }
        for(int i=0; i<ratings.length-1; i++){
            if(ratings[i+1] > ratings[i]){
                candies[i+1] = candies[i] + 1;
            }
        }
        for(int i=ratings.length-1; i>0; i--){
            if(ratings[i-1]>ratings[i]){
                if(candies[i-1] < candies[i]+1){
                    candies[i-1] = candies[i] + 1;
                }
            }
        }
        for(int i=0; i<candies.length; i++){
            sum+= candies[i];
        }
        return sum;
    }
}
