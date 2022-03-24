class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int i = 0;
        int j = people.length-1;
        int numberOfBoatsNeeded = 0;
        while(i<=j){
            if(people[i] + people[j] <=limit){
                i+=1;
                j-=1;
            }else {
                j-=1;
            }
            numberOfBoatsNeeded+=1;
        }
        return numberOfBoatsNeeded;
    }
}
