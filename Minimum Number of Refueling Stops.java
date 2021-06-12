class Solution {
  public int minRefuelStops(int target, int startFuel, int[][] stations) {
    PriorityQueue < Integer > maxHeap = new PriorityQueue < Integer > ((a, b) -> (b - a));
    int minimumStops = 0;
    int currentFuel = startFuel;

    for (int station[]: stations) {
      int nextStation = station[0];
      int fuel = station[1];

      while (currentFuel < nextStation) {
        if (maxHeap.isEmpty()) {
          return -1;
        }
        int maximumFuel = maxHeap.poll();
        currentFuel += maximumFuel;
        minimumStops += 1;
      }
      maxHeap.offer(fuel);
    }

    while (currentFuel < target) {
      if (maxHeap.isEmpty()) {
        return -1;
      }
      int maximumFuel = maxHeap.poll();
      currentFuel += maximumFuel;
      minimumStops += 1;
    }
    return minimumStops;
  }
}
