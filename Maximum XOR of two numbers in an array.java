class Solution {
	class Node {
		int val;
		Node left;
        Node right;
		Node(int val){
			this.val=val;
			left=right=null;
		}
	}
    
	public int findMaximumXOR(int[] nums) {
		int result=0;
		Node root=new Node(-1);
		for(int i=0; i<nums.length; i++){
			constructTrie(nums[i], root);
			result=Math.max(result, queryForMax(nums[i], root));
		}
    
		return result;
	}

	public void constructTrie(int num, Node current) {
		for(int i=30; i>=0; i--) {
			int value =(num>>i)&1;
			if(value==0){
				if(current.left==null)
					current.left=new Node(0);
				current=current.left;
			} else{
				if(current.right==null)
					current.right=new Node(1);
				current=current.right;
			}
		}
	}

	public int queryForMax(int num, Node current) {
		int result=2147483647;
		for(int i=30; i>=0; i--){
			int value=(num>>i)&1;
			if(value==0 && current.right!=null)
				current=current.right;
			else if(value==1 && current.left!=null)
				current=current.left;
			else{
				result^=(1<<i);
				if(current.left!=null)
					current=current.left;
				else
					current=current.right;
			}
		}
		return result;
	}
}