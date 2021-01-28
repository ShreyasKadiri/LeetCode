/*

https://leetcode.com/problems/triples-with-bitwise-and-equal-to-zero/discuss/988061/Java-5-approaches-with-explanation-and-clean-codes

Approach:
1. Brute Force: Use three for loops to find triplets - Time Complexity: O(n3)

2. Use HashMap: First calculate the pairs with bitwise AND zero. Then iterate through the array to find another 
number when And ed with previous paired AND from Hashmap that equals to zero

3. Count pairs using Trie
We can build a trie of depth 16 and insert all A[i] & A[j] values into it. Leaf of the trie node stores the count of the number represented by that path. Then, for each A[i], we can find how many pairs when taken AND with A[i] give 0 by traversing the trie bit by bit. If at any time, bit of A[i] is 1, then we traverse bit 0 child only whereas if bit of A[i] is 0, we traverse both bit 0 and 1 children.

*/

/*
Using HashMap
class Solution {
    public int countTriplets(int[] A) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i=0; i<A.length; i++){
            for(int j=0; j<A.length; j++){
                    map.put(A[i]&A[j], map.getOrDefault(A[i]&A[j],0)+1);
            }
        }
        int result = 0;
        for(int k=0; k<A.length; k++){
            for(int key : map.keySet()){
                if( (key&A[k]) == 0){
                    result+=map.get(key);
                }
            }
        }
        return result;
    }
}
*/


class Trie {
    private int count = 0;
    private Trie[] child = new Trie[2];
    
    public void add(int num) {
        Trie node = this;
        for(int i=15; i>=0; i--) {
            int b = (num>>i) & 1;
            if(node.child[b]==null) {
                node.child[b] = new Trie();
            }
            node = node.child[b];
        }
        node.count++;
    }
    
private int find(Trie node, int num, int i) {
    return node==null ? 0 : (i== -1 ? node.count : (find(node.child[0], num, i - 1) + (((num >> i) & 1) == 0 ? find(node.child[1], num, i - 1) : 0)));
    }
    
public int countZeroAND(int num) {
    return find(this, num, 15);
    }
}


class Solution{
public int countTriplets(int[] A) {
    Trie trie = new Trie();
    for(int a: A)
        for(int b: A)
            trie.add(a & b);
    int result=0;
    for(int a: A) 
        result+= trie.countZeroAND(a);
    return result;
    }
}
