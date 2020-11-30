class Solution {
    public int subarrayBitwiseORs(int[] a) {
        Set<Integer> s=new HashSet<>();
        Set<Integer> s1=new HashSet<>();
        s1.add(0);
        for (int i:a){
            Set<Integer> s2=new HashSet<>();
            for (int j:s1)
                s2.add(i|j);
            s2.add(i);
            s1=s2;
            s.addAll(s1);
        }
        return s.size();
    }
}
/*https://leetcode.com/problems/bitwise-ors-of-subarrays/discuss/165933/Python-Dynamic-programming-solution-with-indepth-explanation-of-intuition.
*/