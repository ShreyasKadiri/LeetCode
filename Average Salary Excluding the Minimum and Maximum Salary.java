class Solution {
    public double average(int[] salary) {
        Arrays.sort(salary);
        double average = 0;
        for(int i=0; i<salary.length; i++){
            average+=salary[i];
        }
        return (average - (salary[0] - salary[salary.length - 1]) )/salary.length;
    }
}
