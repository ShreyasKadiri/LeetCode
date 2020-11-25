public class Solution
{
	public static void sortStack(Stack<Integer> stack){
	    if(!stack.isEmpty()){

	    //1st step: Pop the top element
        int popped = stack.pop();
        //2nd step: Sort the rest of the stack
        sortStack(stack);
        //3rd step: Insert the popped element into sorted step
        sortedInsert(stack, popped);
     	}
  }
	
	public static void sortedInsert(Stack<Integer> stack, int ele){
	    if(!stack.isEmpty() || ele >=stack.peek()){
	        stack.push(ele);
	    }
	    
	    int temp = stack.pop();
	    sortedInsert(stack,ele);
	    stack.push(temp);
	 }
}
