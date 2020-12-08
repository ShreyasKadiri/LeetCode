/*
Brute Force:
Generate all possile substrings except null strings and for check uniqueness for such individual substring 
generated
Time Complexity: Exponential
*/



/*
Better Approach

Example:
Firstly, we maintain a HashMap to save the position of every character.
Taking LETTER for example, the HashMap will be like this:

'L': <0>
'E': <1,4>
'T': <2,3>
'R': <5>
Instead of calculating every substring's UNIQ(), we calculate every character respectively.
For the first E in LETTER, the substring contains this E as a unique character have four parts:

itself: E
left: LE
right: ET, ETT
combination of left and right: LET, LETT

We can calculate the distance between this E and previous/next E by the above HashMap, let's say left and right.
The number of the substring contains this E as a unique character will be:
1 + left + right + left * right
We calculate this for every character and the summation is the result

class Solution 
{
    public int uniqueLetterString(String S) 
    {
        Map<Character,ArrayList<Integer>> h = new HashMap<>();
        char[] ca= S.toCharArray();
        for (int i = 0; i < S.length(); i++) {
            ArrayList<Integer> l = h.getOrDefault(ca[i], new ArrayList<>());
            l.add(i);
            h.put(ca[i], l);
        }
        int sum  = 0;
        for (Map.Entry<Character, ArrayList<Integer>> entry : h.entrySet()) {
            ArrayList<Integer> l = entry.getValue();
            for (int i = 0; i < l.size(); i++) {
                int left = i == 0 ? l.get(i) : l.get(i) - l.get(i - 1) - 1;
                int right = i == l.size() - 1 ? S.length() - l.get(i) - 1 : l.get(i + 1) - l.get(i) - 1;
                sum = (sum + 1 + left + right + left * right) % 1000000007;
            }
        }
        return sum;
    }
} 

Time Complexity o(n)  
Space Complexity o(n)

*/


/*
Efficient:

Intuition
Let's think about how a character can be found as a unique character.

Think about string "XAXAXXAX" and focus on making the second "A" a unique character.
We can take "XA(XAXX)AX" and between "()" is our substring.
We can see here, to make the second "A" counted as a uniq character, we need to:

insert "(" somewhere between the first and second A
insert ")" somewhere between the second and third A
For step 1 we have "A(XA" and "AX(A", 2 possibility.
For step 2 we have "A)XXA", "AX)XA" and "AXX)A", 3 possibilities.
So there are in total 2 * 3 = 6 ways to make the second A a unique character in a substring.
In other words, there are only 6 substring, in which this A contribute 1 point as unique string.

Instead of counting all unique characters and struggling with all possible substrings,
we can count for every char in S, how many ways to be found as a unique char.
We count and sum, and it will be out answer.

Explanation
index[26][2] record last two occurrence index for every upper characters.
Initialise all values in index to -1.
Loop on string S, for every character c, update its last two occurrence index to index[c].
Count when loop. For example, if "A" appears twice at index 3, 6, 9 seperately, we need to count:
For the first "A": (6-3) * (3-(-1))"
For the second "A": (9-6) * (6-3)"
For the third "A": (N-9) * (9-6)"
(Right-Curr_Index)*(Curr_Index-Left)

Complexity
One pass, time complexity O(N).
Space complexity O(1).

*/


class Solution 
{
    public int uniqueLetterString(String S)
    {
        int index[][] = new int[26][2];
        int res=0;
        int N=S.length();
        int mod=(int)(Math.pow(10,9) + 7);
        
       for(int[] value:index)
        Arrays.fill(value,-1);
    
        for (int i=0;i<N;i++)
        {
            int c=S.charAt(i)-'A';
            res=(res+(i-index[c][1])*(index[c][1]-index[c][0])%mod)%mod;
            index[c][0]=index[c][1];
            index[c][1]=i;
        }
        
        for(int c=0;c<26;c++)
            res=(res+(N-index[c][1])*(index[c][1]-index[c][0])%mod)%mod;
        return res;
    }
}



