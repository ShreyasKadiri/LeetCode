class Solution {
    public String getHint(String secret, String guess) {
        int bullsCount =0;
        int cowsCount =0;
        
        int[] secretFrequency =new int[10];
        int[] guessFrequency =new int[10];


        for(int i=0; i<secret.length(); i++){
            char secretCharacter = secret.charAt(i);
            char guessCharacter = guess.charAt(i);

            if(secretCharacter == guessCharacter){
                bullsCount++;
            } else{
                secretFrequency[secretCharacter -'0']++;
                guessFrequency[guessCharacter -'0']++;
            }
        }

        for(int i=0; i<10; i++){
            cowsCount+= Math.min(secretFrequency[i], guessFrequency[i]);
        }
        return bullsCount +"A"+ cowsCount +"B";
    }
}
