class Solution {
    public List<String> invalidTransactions(String[] transactions) {
       List<String> invalid = new ArrayList<String>();
        HashMap<String,List<String>> map = new HashMap<String,List<String>>();
        for(int i=0;i<transactions.length;i++){
            String current[] = transactions[i].split(",");
            String name = current[0];
            List<String> list = map.getOrDefault(name,new ArrayList<String>());
            list.add(transactions[i]);
            map.put(name,list); 
        }
         for(String name:map.keySet()){
            List<String> currentTransactions = map.get(name);
            boolean[] invalidArray = new boolean[currentTransactions.size()];
            Arrays.fill(invalidArray,false);
            for(int i=0; i<currentTransactions.size(); i++){
                String currentTransaction = currentTransactions.get(i);
                String[] Tokens = currentTransaction.split(",");
                int Time = Integer.parseInt(Tokens[1]);
                int Amount = Integer.parseInt(Tokens[2]);
                String City = Tokens[3];
                if(Amount> 1000){
                    invalidArray[i] = true;
                }
                for(int j=i+1; j<currentTransactions.size(); j++){ 
                    String jTransaction = currentTransactions.get(j);
                    String[] jTokens = jTransaction.split(",");
                    int jTime = Integer.parseInt(jTokens[1]);
                    int jAmount = Integer.parseInt(jTokens[2]);
                    String jCity = jTokens[3];
                    if(!City.equals(jCity) && Math.abs(Time-jTime)<=60){
                        invalidArray[i]=true;
                        invalidArray[j]=true;
                    }
                }
            }
            for(int k=0; k<currentTransactions.size(); k++){
                    if(invalidArray[k]){
                        invalid.add(currentTransactions.get(k));
                    }
                }
        }
        return invalid;
    }
}