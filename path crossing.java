class Solution {
   public boolean isPathCrossing(String path) {
        HashSet<String> set = new HashSet<String>();
        set.add("(0,0)");
        int x=0;
        int y=0;
        for (int i=0; i<path.length(); i++) {
            if (path.charAt(i) == 'N') {
                y++;
            } else if (path.charAt(i) == 'S') {
                y--;
            } else if (path.charAt(i) == 'E') {
                x++;
            } else {
                x--;
            }
            String result = "(" + x + "," + y + ")";
            if (set.contains(result)) {
                return true;
            } else {
                set.add(result);
            }
        }
        return false;
    }
}
