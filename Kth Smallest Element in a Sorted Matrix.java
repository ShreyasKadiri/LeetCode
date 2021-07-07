//Brute Force
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int matrixElements[] = new int[matrix.length * matrix[0].length];
        int index = 0;
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                matrixElements[index++] = matrix[i][j];
            }
        }
        Arrays.sort(matrixElements);
        
        return matrixElements[k-1];
    }
}


//PriorityQueue
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>((a,b) -> (b-a));
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                heap.add(matrix[i][j]);
            }
        }
        while(heap.size() > k){
            heap.poll();
        }        
        return heap.poll();
    }
}

//Binary Search
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int low = matrix[0][0];
        int high = matrix[matrix.length-1][matrix.length-1];
        while(low < high){
            int mid = low + (high - low)/2;
            int placement = findSmallerElementsThanMid(matrix, mid);
            if(placement < k){
                low = mid + 1;
            }else {
                high = mid;
            }
        }
        return low;
    }
    
    public int findSmallerElementsThanMid(int matrix[][], int mid){
        int count = 0;
        int i = matrix.length-1;
        int j = 0;
        while(i>=0 && j<matrix.length){
            if(matrix[i][j] > mid){
                i--;
            }else {
                count = count + i + 1;
                j++;
            }
        }
        return count;
    }
}
