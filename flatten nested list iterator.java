/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {

    Queue<Integer> queue = new LinkedList<Integer>();
    public NestedIterator(List<NestedInteger> nestedList) {
        enqueue(nestedList);
    }

    @Override
    public Integer next() {
        return queue.poll;
    }

    @Override
    public boolean hasNext() {
        return !queue.isEmpty();
    }
    
    public void enqueue(List<NestedInteger> nestedList){
       for(NestedInteger value : nestedList){
           if(value.isInteger()){
               queue.offer(value.getInteger());
           }else {
               enqueue(value.getList());
           }
       }
        return ;
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
