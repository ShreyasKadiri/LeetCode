import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

class Shuffle{
 public int[]  shuffleCards(int cards[], int n){
 if(n==0){
 return cards;
 }
 Random rand = new Random();
 for(int j=n-1; j>=0; j--){
  int i = rand.nextInt(j+1);
  int temp = cards[i];
  cards[i] = cards[j];
  cards[j] = temp;
  }
  return cards;
  }
}

//Time Complexity : o(n)  Space Complexity: O(n)
