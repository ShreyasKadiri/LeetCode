class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        List<Integer> indices = new ArrayList<Integer>();
        for (int i=0; i<s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)){
                indices.add(i);
            } 
        }
        return indices.size()==0 || (indices.size() == 2 && s1.charAt(indices.get(0)) == s2.charAt(indices.get(1))
                                 && s1.charAt(indices.get(1)) == s2.charAt(indices.get(0)));
    }
}
