class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int n=letters.length;
        int low=0; int high = n-1;
        while(low <=high){
            int mid = low + (high-low)/2;
             if(letters[mid] > target){
                if(mid==0 || letters[mid-1]<=target){
                    return letters[mid];
            }
            high = mid-1;
         }
            else{
                low=mid+1;
            }
            mid = low + (high-low)/2;
        }
        return letters[0];
    }
}


/*
O(n)
for(char c : letters){
if(a-target > 0){
return a;
 }
 return letters[0];
}

*/
