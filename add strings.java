//Stack
class Solution {
    public String addStrings(String num1, String num2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        for (char ch : num1.toCharArray())
            stack1.push(Integer.parseInt(String.valueOf(ch)));
        for (char ch : num2.toCharArray())
            stack2.push(Integer.parseInt(String.valueOf(ch)));
        StringBuilder sb = new StringBuilder();
        int c = 0;
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            int s = stack1.pop() + stack2.pop() + c;
            sb.append(s % 10);
            c = s / 10;
        }
        while (!stack1.isEmpty()) {
            int s = stack1.pop() + c;
            sb.append(s % 10);
            c = s / 10;
        }
        while (!stack2.isEmpty()) {
            int s = stack2.pop() + c;
            sb.append(s % 10);
            c = s / 10;
        }
        if (c > 0)
            sb.append(c);
        
        return sb.reverse().toString();
    }
}
