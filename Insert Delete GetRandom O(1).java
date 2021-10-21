class RandomizedSet {
private List<Integer> nums;
    private HashMap<Integer,Integer> map;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        map = new HashMap<Integer, Integer>();
        nums = new ArrayList<Integer>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(!map.containsKey(val)){
            map.put(val, nums.size());
            nums.add(val);
            return true;
        }
        return false;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val)){
            return false;
        }
        int index = map.get(val);
        map.remove(val);
        if(index != nums.size()-1){
            nums.set(index, nums.get(nums.size() - 1));
            map.put(nums.get(index), index);
        }
        nums.remove(nums.size() - 1);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        int randomIndex = nums.size() == 0 ? 0 : getRandom(0, nums.size() - 1);
        return nums.get(randomIndex);
    }
    
    private int getRandom(int minimum, int maximum){
        return minimum + (int) (Math.random() * (maximum - minimum + 1));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
