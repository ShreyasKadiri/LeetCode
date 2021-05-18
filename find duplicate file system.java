class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        List<List<String>> result = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        if(paths == null){
            return result;
        }
        
        for(String path : paths){
            String directories[] = path.split(" ");
            String root = directories[0];
            for(int i=1; i<directories.length; i++){
                String content = directories[i].substring(directories[i].indexOf("("), directories[i].indexOf(")"));
                if(!map.containsKey(content)){
                    map.put(content, new ArrayList<>());
                }
                map.get(content).add(root + "/" + directories[i].substring(0, directories[i].indexOf("(")));
            }
        }
        
        for(Map.Entry<String, List<String>> entry: map.entrySet()){
            if(entry.getValue().size() > 1){
                result.add(entry.getValue());
            }
        }
        return result;
    }
}
