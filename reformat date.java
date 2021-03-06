class Solution {
    public String reformatDate(String Date) {
        String format = "";
        String parts[] = Date.split(" ");
        String date = parts[0];
        String month = parts[1];
        String year = parts[2];
        HashMap<String, String> map = new HashMap<String, String>();
map.put("Jan", "01"); map.put("Feb", "02"); map.put("Mar", "03"); map.put("Apr", "04");
map.put("May", "05"); map.put("Jun", "06"); map.put("Jul", "07"); map.put("Aug", "08");
map.put("Sep", "09"); map.put("Oct", "10"); map.put("Nov", "11"); map.put("Dec", "12");
        
        
        //Extract current month
      String currentMonth = map.get(month);
        
        //Extract current date
        StringBuilder currentDate = new StringBuilder("");
        for(char c : date.toCharArray()){
            if(c == 's' || c=='t' || c=='r' || c=='d' || c=='h' || c=='n'){
                continue;
            }else{
                currentDate.append(c);
            }
        }
        
        if(currentDate.length() == 1){
            //append o at the beginning
            currentDate.insert(0, "0");
        }
        //Returning the final result
        format = year + "-" + currentMonth + "-" + currentDate.toString(); 
        return format;
    }
}
