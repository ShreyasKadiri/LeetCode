class Solution 
{
    public List<String> commonChars(String[] A) 
    {
        Map<Character, Map<Integer,Integer>> map=new HashMap<Character, Map<Integer,Integer>>();
        for (int i=0;i<A.length;i++)
        {
            String curr=A[i];//current word in the string
            
            for (int j=0; j<curr.length();j++) 
            {
                Map<Integer,Integer>currMap= map.getOrDefault(curr.charAt(i), new HashMap<>());
                currMap.put(j, currMap.getOrDefault(i,0)+1);
                map.put(curr.charAt(i),currMap);
            }
        }
        
        
        
        List<String> result = new ArrayList<String>();
        for (Character c:map.keySet()) {
            if (map.get(c).size()<A.length) 
                continue;
            
            int total=Integer.MAX_VALUE;
            for(Map.Entry<Integer, Integer> entry:map.get(c).entrySet()){
                total=Math.min(entry.getValue(),total);}
            for (int i=0;i<total;i++) {
                result.add(""+c);
            }
        }
        return result;
    }
}


