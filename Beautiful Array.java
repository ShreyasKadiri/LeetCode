class Solution {
    public int[] beautifulArray(int N) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        result.add(1);
        while (result.size() < N) {
            ArrayList<Integer> temp = new ArrayList<Integer>();
            for(int i : result)
                if (i*2-1<=N)
                    temp.add(i*2-1);
            for(int i :result) 
                if (i*2<=N) 
                    temp.add(i*2);
            result=temp;
        }
        return result.stream().mapToInt(i->i).toArray();
    }
}

//https://leetcode.com/problems/beautiful-array/discuss/186679/Odd-%2B-Even-Pattern-O(N)