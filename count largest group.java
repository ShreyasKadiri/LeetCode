class Solution {
    public int countLargestGroup(int n) {
        int frequencies[] = new int[37];
        for(int i=1; i<=n; i++){
            frequencies[calculateDigitSum(i)]++;
        }
        
        Arrays.sort(frequencies);
        int count=1;
        int value = frequencies[frequencies.length-1];
        for (int i=frequencies.length-2; i>=0; i--) {
			if (frequencies[i]!= value) {
				break;
			}
			count++;
		}
		return count;
    }
    
    
    private int calculateDigitSum(int number) {
		int digitSum=0;
		while (number>0) {
			digitSum+=number%10;
			number=number/10;
		}
		return digitSum;
	}
}
