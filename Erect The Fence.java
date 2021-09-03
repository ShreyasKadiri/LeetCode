class Solution {
    public int orientation(int p[], int q[], int r[]){
        return (q[1]-p[1]) * (r[0]-q[0]) - (q[0]-p[0]) * (r[1]-q[1]);
    }
    
    public int distance(int p[],int q[]){ 
        return (p[0]-q[0]) * (p[0]-q[0]) + (p[1]-q[1]) * (p[1]-q[1]);
    } 
    
    public int[] bottomLeft(int[][] trees) { 
        int[] bottomleft = trees[0];
        for(int[] tree : trees){ 
            if(tree[1] < bottomleft[1]) 
                bottomleft = tree;
        } 
        return bottomleft;
    } 
    
    public int[][] outerTrees(int[][] trees){ 
        if(trees.length <= 1){
            return trees; 
        }
        int[] bm = bottomLeft(trees); 
        Arrays.sort(trees,new Comparator<int[]>(){ 
            public int compare(int p[], int q[]){ 
                double diff = orientation(bm,p,q) - orientation(bm,q,p); 
                if(diff==0) 
                    return distance(bm,p) - distance(bm,q); 
                else return diff > 0 ? 1 : -1;
            }
        }); 
        int i = trees.length - 1; 
        while(i>=0 && orientation(bm,trees[trees.length - 1],trees[i])==0) 
            i--; 
        for(int l = i+1, h = trees.length - 1; l < h; l++, h--){
            int temp[] = trees[l];
            trees[l] = trees[h];
            trees[h] = temp;
        } 
        Stack<int[]> stack = new Stack< > (); 
        stack.push(trees[0]); 
        stack.push(trees[1]);
        for (int j = 2; j < trees.length; j++) { 
            int[] top = stack.pop();
            while (orientation(stack.peek(), top, trees[j]) > 0) 
                top = stack.pop(); 
            stack.push(top); 
            stack.push(trees[j]); 
        } 
        return stack.toArray(new int[stack.size()][]);
    }
}
