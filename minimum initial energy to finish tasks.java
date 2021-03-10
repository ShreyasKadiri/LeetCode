class Solution {
    public int minimumEffort(int[][] tasks) {
        Arrays.sort(tasks, (a, b) -> {
            return (b[1] - b[0]) - (a[1] - a[0]);
        });
        
        int totalEnergy=0;
        
        for (int[] task: tasks)
            totalEnergy+=task[0];
        int result=totalEnergy;
        
        for (int[] task: tasks) {
            if (task[1]> total)
                totalEnergy+=task[1] - totalEnergy;
            totalEnergy-= task[0];
        }
        return result + totalEnergy;
    }
}
