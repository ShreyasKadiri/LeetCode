class MyCalendar {
    TreeMap<Integer, Integer> treeMap = null;
    public MyCalendar() {
        this.treeMap = new TreeMap<Integer, Integer>();
    }
    
    public boolean book(int start, int end) {
        if(treeMap.floorEntry(start)!=null && start<treeMap.floorEntry(start).getValue()){
            return false;
        }
        
        if(treeMap.ceilingEntry(start)!=null && end > treeMap.ceilingEntry(start).getKey()){
            return false;
        }
        treeMap.put(start, end);
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
