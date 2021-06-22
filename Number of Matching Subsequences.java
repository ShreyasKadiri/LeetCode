//Brute Force
class Solution {
    public int numMatchingSubseq(String S, String[] words) {
        int result=0;
        for (String word : words) {
            if (isSubsequence(word,S)) {
                result++;
            }
        }
        return result;
    }

    public boolean isSubsequence(String t, String s) {
        int j=0;
        for (int i=0; i<s.length() && j<t.length(); i++) {
            if (s.charAt(i) == t.charAt(j)) {
                j++;
            }
        }
        return j==t.length();
    }
}


// Queue and map  TC: O(nL) and SC: O(n)
class Solution {
    public int numMatchingSubseq(String S, String[] words) {
        int result=0;
        HashMap<Character,Queue<String>> map = new HashMap<Character,Queue<String>>();
        for (char c:S.toCharArray()) {
            if (!map.containsKey(c)) {
                map.put(c, new LinkedList<>());
            }
        }
        for(String word : words) {
            if(word.length()>S.length())
                continue;
            if (map.containsKey(word.charAt(0))) {
                map.get(word.charAt(0)).add(word);
            }
        }

        for (char c:S.toCharArray()) {
            Queue<String> queue = map.get(c);
            int size=queue.size();
            for (int i=0; i<size; i++) {
                String curr=queue.remove();
                if (curr.length()==1) {
                    result++;
                }
                else if (map.containsKey(curr.charAt(1))) {
                    map.get(curr.charAt(1)).add(curr.substring(1));
                }
            }
        }
        return result;
    }
}
