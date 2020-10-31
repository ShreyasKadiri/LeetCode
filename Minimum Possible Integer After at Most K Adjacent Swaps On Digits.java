/*
class Solution {
    public String minInteger(String num, int k) {
        if(k==0)   return num;
    for (char c='0'; c<='9'; c++) {
        int i=num.indexOf(c);
        if (i>=0) {
            if(i<=k) {
                return c + minInteger(num.substring(0,i) + num.substring(i+1), k-i);
            }
        }
    }
    return num;
    }
}

*/


class Solution {
    public String minInteger(String num, int k) {
        List<Queue<Integer>> queue= new ArrayList<>();
        for (int i=0; i<=9; ++i) {
            queue.add(new LinkedList<>());
        }

        for (int i=0; i<num.length(); ++i) {
            queue.get(num.charAt(i)-'0').add(i);
        }
        
        String result="";
        SegmentTree segmentTree = new SegmentTree(num.length());

        for (int i=0; i<num.length(); ++i) {
            for (int digit=0; digit<=9; ++digit) {
                if (queue.get(digit).size()!=0) {
                    int position = queue.get(digit).peek();
                    int shift=segmentTree.getCountLessThan(position);
                    if (position-shift<=k) {
                        k-=position-shift;
                        segmentTree.add(position); 
                        queue.get(digit).remove();
                        result+=digit;
                        break;
                    }
                }
            }
        }
        return result;
    }

    class SegmentTree {
        int[] nodes;
        int n;

        public SegmentTree(int max) {
            nodes=new int[4*(max)];
            n=max;
        }

        public void add(int num) {
            addUtil(num, 0, n, 0);
        }

        private void addUtil(int num, int l, int r, int node) {
            if (num<l || num>r) {
                return;
            }
            if (l==r) {
                nodes[node]++;
                return;
            }
            
            int mid=(l+r)/2;
            addUtil(num, l, mid, 2*node+1);
            addUtil(num, mid+1, r, 2*node+2);
            nodes[node] = nodes[2*node+1] + nodes[2*node+2];
        }


        public int getCountLessThan(int num) {
            return getUtil(0, num, 0, n, 0);
        }

        private int getUtil(int ql, int qr, int l, int r, int node) {
            if (qr<l || ql>r) 
                return 0;
            if (ql<=l && qr>=r) {
                return nodes[node];
            }

            int mid = (l+r)/2;
            return getUtil(ql, qr, l, mid, 2 * node + 1) + getUtil(ql, qr, mid + 1, r, 2 * node + 2);
        }
    }

}



/*Ref:
https://leetcode.com/problems/minimum-possible-integer-after-at-most-k-adjacent-swaps-on-digits/discuss/728201/Java-or-O(N2)-or-108-ms-Easy-understand-and-with-detailed-explaination

https://leetcode.com/problems/minimum-possible-integer-after-at-most-k-adjacent-swaps-on-digits/discuss/720548/O(n-logn)-or-Detailed-Explanation

*/