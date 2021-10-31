class Solution {
    public Node flatten(Node head) {
        if (head == null) return head;
        Deque<Node> stack = new ArrayDeque<>();
        Node cur = head;
        while (cur != null) {
            if (cur.child != null) {
                if (cur.next != null) {
                    stack.push(cur.next);
                }
                
                cur.next = cur.child;
                if (cur.next != null) {
                    cur.next.prev = cur;
                }
                cur.child = null;
            } else if (cur.next == null && !stack.isEmpty()) {
                cur.next = stack.pop();
                if (cur.next != null) {
                    cur.next.prev = cur;
                }
            }
            
            cur = cur.next;
        }
        
        return head;
    }
}
