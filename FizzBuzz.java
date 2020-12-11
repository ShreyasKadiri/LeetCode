class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<String>();
        for(int i=1; i<=n; i++){
            if(i%3==0 && i%5!=0){
                result.add("Fizz");
            }
            else if(i%3!=0 && i%5==0){
                result.add("Buzz");
            }
            else if(i%3==0 && i%5==0){
                result.add("FizzBuzz");
            }
            else{
                result.add(Integer.toString(i));
            }
        }
        return result;
    }
}
