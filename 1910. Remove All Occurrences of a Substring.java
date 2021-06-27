class Solution {
    public String removeOccurrences(String s, String p) {
        return s.contains(part) ? removeOccurrences(s.replaceAll(part, ""), part) : s;
    }
}
