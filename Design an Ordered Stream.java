class OrderedStream {
    int i;
    String result[];
    public OrderedStream(int n) {
        i = 0;
        result = new String[n];
    }
    
    public List<String> insert(int id, String value) {
        List<String> stream = new ArrayList<String>();
        result[id - 1] = value;
        while(i < result.length && result[i]!=null){
            stream.add(result[i]);
            i++;
        }
        return stream;
    }
}

/**
 * Your OrderedStream object will be instantiated and called as such:
 * OrderedStream obj = new OrderedStream(n);
 * List<String> param_1 = obj.insert(id,value);
 */
