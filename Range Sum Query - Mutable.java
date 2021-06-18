public class NumArray {

    class SegmentTreeNode {
        private int start, end;
        private  SegmentTreeNode left, right;
        private  int sum;

        public SegmentTreeNode(int start, int end) {
            this.start = start;
            this.end = end;
            this.left = null;
            this.right = null;
            this.sum = 0;
        }
    }

    SegmentTreeNode root = null;

    public NumArray(int[] nums) {
        root = constructSegmentTree(nums, 0, nums.length-1);
    }
    
    public SegmentTreeNode constructSegmentTree(int nums[], int start, int end){
        if(start > end){
            return null;
        }else {
            SegmentTreeNode node = new SegmentTreeNode(start, end);
            if(start == end){
                node.sum = nums[start];
            }else {
                int mid = start + (end - start)/2;
                node.left = constructSegmentTree(nums, start, mid);
                node.right = constructSegmentTree(nums, mid+1, end);
                node.sum = node.left.sum + node.right.sum;
            }
            return node;
        }
    }
    
     void update(int i, int val) {
        updateValuesHelper(root, i, val);
    }
    
    private void updateValuesHelper(SegmentTreeNode root, int position, int val){
        if (root.start == root.end) {
            root.sum = val;
        } else {
            int mid = root.start + (root.end - root.start) / 2;
            if (position <= mid) {
                updateValuesHelper(root.left, position, val);
            } else {
                updateValuesHelper(root.right, position, val);
            }
            root.sum = root.left.sum + root.right.sum;
        }
    }
    
    
    public int sumRange(int left, int right) {
        return sumRangeHelper(root, left, right);
    }
    
    public int sumRangeHelper(SegmentTreeNode root, int start, int end) {
        if (root.start == start && root.end == end ) {
            return root.sum;
        } else {
            int mid = root.start + (root.end - root.start) / 2;
            if (end <= mid) {
                return sumRangeHelper(root.left, start, end);
            } else if (start >= mid+1) {
                return sumRangeHelper(root.right, start, end);
            }  else {
                return  sumRangeHelper(root.left, start, mid) + sumRangeHelper(root.right, mid+1, end) ;
            }
        }
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */
