class Solution {
    public int minStickers(String[] stickers, String target) {
    
        //For every sticker maintain a map, so for a list of stickers there will be a list of mappings 
        List<HashMap<Character, Integer>> stickersCount = new ArrayList<>();

        for(String sticker : stickers){
            //For each sticker 
            HashMap<Character, Integer> stickerCount = new HashMap<Character, Integer>();
            //Populate the map for each sticker 
            for(char c : sticker.toCharArray()){
                stickerCount.put(c, stickerCount.getOrDefault(c, 0) + 1);
            }
            stickersCount.add(stickerCount);
        }

        HashMap<String, Integer> cache = new HashMap<String, Integer>();
        HashMap<Character, Integer> charsCount  = new HashMap<Character, Integer>();
        int result = solveRecursively(target, stickersCount, charsCount , cache);
        return result != Integer.MAX_VALUE ? result : -1;
    }

    private static int solveRecursively(String target, List<HashMap<Character, Integer>> stickersCount, HashMap<Character, Integer> currentStickerCount, HashMap<String, Integer> cache ) {
        if(cache.containsKey(target)){
            return cache.get(target);
        }

        int result = 1;
        if(currentStickerCount.size() == 0){
            result = 0;
        }
        StringBuilder remainingCharacters = new StringBuilder("");
        // exhaust using all chars from the current sticker and keep track of the remaining chars that are unused from target
        for(char c : target.toCharArray()){
            Integer currentCharacterCount = currentStickerCount.get(c);
            if(currentCharacterCount != null && currentCharacterCount > 0){
                //we reduce the count, since we are utilizing it
                currentStickerCount.put(c, currentCharacterCount-1);
            }else {
                remainingCharacters.append(c);
            }
        }

         if(!remainingCharacters.isEmpty()){
            int used = Integer.MAX_VALUE;
            // iterate over all sticker counts and use any sticker that contains the first char from remainingChars
            for(Map<Character, Integer> stickerCount: stickersCount){
                // skip the current sticker if it doesn't have the first char in remainingChars
                if(!stickerCount.containsKey(remainingCharacters.charAt(0))) continue;
                // we need to use copy of the stickerCount since it will be modified by the subsequent recursive calls
                // and we want to keep the original for backtracking
                used = Math.min(used, solveRecursively(remainingCharacters.toString(), stickersCount, new HashMap<>(stickerCount), cache));
            }
            // update the cache and the result
            cache.put(remainingCharacters.toString(), used);
            result = used == Integer.MAX_VALUE ? used : result + used;
        }
        return result;
    }
}
