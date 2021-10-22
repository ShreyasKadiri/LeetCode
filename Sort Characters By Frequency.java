class Solution {
    public String frequencySort(String s) {
        if(s==" " || s.length()==0){
            return s;}
        HashMap<Character,Alphabet> map = new HashMap<Character,Alphabet>();
        for(char c:s.toCharArray()) {
            if(map.containsKey(c)){
                map.get(c).count++;
            } else{
                Alphabet alphabet=new Alphabet();
                alphabet.character=c;
                alphabet.count=1;
                map.put(c,alphabet);
            }
        }
        
        List<Alphabet> results=new ArrayList<>(map.values());
        Collections.sort(results,new Comparator<Alphabet>(){
            @Override
            public int compare(Alphabet o1, Alphabet o2) {
                return o2.count.compareTo(o1.count);
            }
        });
        
        StringBuilder result = new StringBuilder("");
        for(int i=0; i<results.size(); i++){
            Alphabet a=results.get(i);
            for(int j=0; j<a.count; j++){
                result.append(a.character);
            }
        }
        return result.toString();
    }
}

  class Alphabet {
        Character character;
        Integer count;
    }
    
