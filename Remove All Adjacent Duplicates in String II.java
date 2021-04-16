class Solution {
    public String removeDuplicates(String s, int k) {
        int i=0;
        int count[]=new int[s.length()];
        char[] stack=s.toCharArray();
        for (int j=0; j<s.length(); j++, i++){
            stack[i]=stack[j];
            count[i]=i > 0 && stack[i-1]==stack[j] ? count[i-1]+1 : 1;
            if(count[i]==k)
                i-=k;
        }
        return new String(stack,0,i);
    }
}
