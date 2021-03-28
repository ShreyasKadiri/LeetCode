class Solution {
    public String originalDigits(String s) {
        //zero, one, two, three, four, five, six, seven, eight, nine
        int[] counts = new int[26];
        for(char c : s.toCharArray()) {
            counts[c - 'a'] += 1;
        }
        int[] nums = new int[10];
        // zero
        nums[0] = counts['z' - 'a'];
        for(char c : "zero".toCharArray()) {
            counts[c - 'a'] -= nums[0];
        }
        // six
        nums[6] = counts['x' - 'a'];
        for(char c : "six".toCharArray()) {
            counts[c - 'a'] -= nums[6];
        }
        // eight 
        nums[8] = counts['g' - 'a'];
        for(char c : "eight".toCharArray()) {
            counts[c - 'a'] -= nums[8];
        }
        // four
        nums[4] = counts['u' - 'a'];
        for(char c : "four".toCharArray()) {
            counts[c - 'a'] -= nums[4];
        }
        // three
        nums[3] = counts['r' - 'a'];
        for(char c : "three".toCharArray()) {
            counts[c - 'a'] -= nums[3];
        }
        // five
        nums[5] = counts['f' - 'a'];
        for(char c : "five".toCharArray()) {
            counts[c - 'a'] -= nums[5];
        }
        // seven
        nums[7] = counts['v' - 'a'];
        for(char c : "seven".toCharArray()) {
            counts[c - 'a'] -= nums[7];
        }
        // two
        nums[2] = counts['t' - 'a'];
        for(char c : "two".toCharArray()) {
            counts[c - 'a'] -= nums[2];
        }
        // nine
        nums[9] = counts['i' - 'a'];
        for(char c : "nine".toCharArray()) {
            counts[c - 'a'] -= nums[9];
        }
        // one
        nums[1] = counts['o' - 'a'];
        for(char c : "one".toCharArray()) {
            counts[c - 'a'] -= nums[9];
        }
        String res = "";
        for(int i = 0; i < nums.length; i++) {
            for(int j = 0; j < nums[i]; j++) {
                res += (char)('0' + i);
            }
        }
        return res;        
    }
}
