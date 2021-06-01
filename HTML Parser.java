class Solution {
public String entityParser(String text) {
if(text.length()<3){
return text;
}
HashMap<String, String> map = new HashMap<>();  
String[] str= text.split("&");       
map.put("quot;","\"" );
map.put("apos;", "\'");
map.put("amp;", "&");
map.put("gt;", ">");
map.put("lt;", "<");
map.put("frasl;", "/");
StringBuffer sb= new StringBuffer("");   
for(String f : str){
int k= f.indexOf(";");     
if(k>0){
if(map.containsKey(f.substring(0,k+1))){
String sub = map.get(f.substring(0,k+1));
sb.append(sub);
if(f.length()>k+1){
sb.append(f.substring(k+1, f.length()));
}
}
else{
sb.append("&"+f);}
}
else {
sb.append(f);
}
 }
        return sb.toString();
    }
}