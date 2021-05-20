class Solution {
    public int[] distributeCandies(int candies, int num_people) {
        int candiesDistribution[] = new int[num_people];
        int i = 0;
        int count = 0;
        while(candies > 0){
            if(i == num_people){
                i = 0;
                count++;
            }
            int currentCandy = (count *num_people) + (i + 1);
            if(candies - currentCandy < 0){
                candiesDistribution[i]+=candies;
            }else {
                candiesDistribution[i]+=currentCandy;
            }
            i++;
            candies-=currentCandy;
        }
        
        return candiesDistribution;
    }
}
