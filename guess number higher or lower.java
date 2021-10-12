/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is lower than the guess number
 *			      1 if num is higher than the guess number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
     int low =1;
        int high = n;
        while(low<=high){
            int mid = low + (high-low)/2;
            int pickedNumber = guess(mid);
            if(pickedNumber <0){
                high = mid -1;
            }else if(pickedNumber > 0){
                low = mid  + 1;
            }else{
            return mid;
           }
        }
        return 0;
    }
}
