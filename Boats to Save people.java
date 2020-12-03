class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int i=0;
        int j=people.length-1;
        int numBoats=0;
        while(i<=j){
            if(people[i] + people[j] <=limit){
                i+=1;
                j-=1;
            }
            else{
                j-=1;
            }
            numBoats+=1;
        }
        return numBoats;
    }
}