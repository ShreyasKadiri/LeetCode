class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> result = new ArrayList<Integer>();
        for(int i=0; i<expression.length(); i++){
            if(expression.charAt(i) == '-' || expression.charAt(i) == '*' || expression.charAt(i) == '+'){
                String leftSideOfExpression = expression.substring(0,i);
                String rightSideOfExpression = expression.substring(i+1);
                List<Integer> leftSolution = diffWaysToCompute(leftSideOfExpression);
                List<Integer> rightSolution = diffWaysToCompute(rightSideOfExpression);
                for(int left : leftSolution){
                    for(int right : rightSolution){
                        if(expression.charAt(i) == '-'){
                            result.add(left-right);
                        }else if(expression.charAt(i) == '+'){
                            result.add(left+right);
                        }else if(expression.charAt(i) == '*'){
                            result.add(left*right);
                        }
                    }
                }
            }
        }
        if(result.size() == 0){
            result.add(Integer.parseInt(expression));
        }
        return result;
    }
}
