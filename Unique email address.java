class Solution {
    public int numUniqueEmails(String[] emails) {
       HashSet<String> set = new HashSet<String>();
        for(String email : emails){
            String localNames[] = email.split("@");
            String domainNames[] = localNames[0].split("\\+");
            set.add(domainNames[0].replace(".", "") + "@" + localNames[1]);
        }
        return set.size();
    }
}


//2nd
class Solution {
    public int numUniqueEmails(String[] emails) {
    HashSet<String> set = new HashSet<String>();
        for (String email : emails) {
            String split[] = email.split("@");
            String localName = split[0].replace(".", "");
            int i = localName.indexOf('+');
            set.add(localName.substring(0,i) + "@" + split[1]);
        }
        return set.size();
    }
}
