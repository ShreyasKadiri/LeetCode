class Solution {
public static boolean validPalindrome(String s, int low, int high, int deleted) {
	while (high > low && deleted < 2) {
		final char c1 = s.charAt(low);
		final char c2 = s.charAt(high);
		if (c1 == c2) {
			low++;
			high--;
		} else {
			return validPalindrome(s, low + 1, high, deleted + 1) ||
					validPalindrome(s, low, high - 1, deleted + 1);
		}
	}
	return deleted < 2;
}

public static boolean validPalindrome(String s) {
	if (s == null || s.length() < 2) {
		return true;
	}
	return validPalindrome(s, 0, s.length() - 1, 0);        
    }
}
