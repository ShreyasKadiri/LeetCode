class Solution {
	public int canBeTypedWords(String text, String brokenLetters) {
		String words[] = text.split(" ");
		char frequency[] = new char[26];
		int count = 0;

		for (char c: brokenLetters.toCharArray()) {
			frequency[c - 'a']++;
		}

		for (String word: words) {
			boolean flag = false;

			for (char c: word.toCharArray()) {
				if (frequency[c - 'a'] == 1) {
					flag = true;
				}
			}
			if (!flag) {
				count++;
			}
		}
		return count;
	}
}
