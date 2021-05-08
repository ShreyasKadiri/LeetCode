class Solution{
    public int superpalindromesInRange(String left, String right) {
        int low = (int)Math.ceil(Math.sqrt(Long.parseLong(left)));
        int high = (int)Math.floor(Math.sqrt(Long.parseLong(right)));
        int count = (3 >= low && 3 <= high) ? 1 : 0;
        count += dfs(low, high, "");
	    count += dfs(low, high, "0");
	    count += dfs(low, high, "1");
	    count += dfs(low, high, "2");
        return count;
    }
    
    private int dfs(int low, int high, String string) {
	if (string.length() > Integer.toString(high).length()) {
        return 0;
    }
        
	int count = 0;
	if (!string.isEmpty() && string.charAt(0) != '0') {
		long number = Long.parseLong(string);
		if (number > high){
            return 0;
        }
		if (number >= low && isPalindrome(number * number)){
            count++;
        }
	}

	for (char c='0'; c<='2'; c++) {
		count += dfs(low, high, c+string+c);
	}
	return count;
    }
    
    private boolean isPalindrome(long number) {
        String string = Long.toString(number);
        return string.equals(new StringBuilder(string).reverse().toString());
    }
}
