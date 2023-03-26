class Solution{
    public static String shortestCompletingWord(String licensePlate, String[] words) {
    int frequency[] = new int[26];
    String result = "";
    //Maintain the characters and their count in frequency array
    for(char c : licensePlate.toCharArray()){
        if((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')){
            char character = Character.toLowerCase(c);
            frequency[character - 'a']++;
        }
    }

    for(String word : words){    
        int wordFrequency[] = new int[26];
        for (char c : word.toCharArray()){
            if((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')){
                char character = Character.toLowerCase(c);
                wordFrequency[character - 'a']++;
            }
        }

        //Check the count
        if(checkTheCount(wordFrequency, frequency, licensePlate)){
            System.out.println("Found match: " + word);
            if(result.isEmpty() || word.length() < result.length()){
                result = word;
            }
        }
    }
    return result;
    }

    private static boolean checkTheCount(int wordFrequency[], int frequency[], String licensePlate){
    for(char c : licensePlate.toCharArray()){
        if((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')){
            char character = Character.toLowerCase(c);
            if(frequency[character - 'a'] > wordFrequency[character - 'a']){
                return false;
            }
        }
    }
    return true;
    }
}
