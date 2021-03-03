class Solution {
    public double average(int[] salary) {
        double totalSalary = 0;
        int minimumSalary = Integer.MAX_VALUE;
        int maximumSalary = Integer.MIN_VALUE; 
        for (int i=0; i<salary.length; i++) {
            totalSalary += salary[i];
            minimumSalary = Math.min(minimumSalary, salary[i]);
            maximumSalary = Math.max(maximumSalary, salary[i]);
        }
        return (totalSalary - minimumSalary - maximumSalary) / (salary.length - 2);
    }
}
